package code;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class RSSFeed {
	private final Deque<RSSFeedItem> itemDeque = new ArrayDeque<>();
	
	private final String url, category;
	private String title, description;
	private boolean initialised = false;

	private DocumentBuilder dBuilder;
	private Document prevRSSDoc;
	private static final Logger logger = Logger.getLogger("RSSFeed");
	
	public RSSFeed(String url, String category) {
		this.url = url;
		this.category = category;
		try {
			dBuilder = DocumentBuilderFactory
					.newInstance()
					.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			logger.log(Level.WARNING, "Failed to create document "
					+ "builder for parsing feed: " + url);
		}
	}
	
	public void initialise(String title, String description) {
		this.title = title;
		this.description = description;
		initialised = true;
	}

	/**
	 * Updates the collection of feed nodes from the RSS feed
	 * @return an object containing any new data
	 */
	public JsonObjectBuilder update() {
		Deque<RSSFeedItem> pulledData = pullFeed();
		if (pulledData == null || pulledData.isEmpty()) return null;
		
		Deque<RSSFeedItem> newData = null;
		
		RSSFeedItem newItem;
		while (!pulledData.isEmpty()) {
			newItem = pulledData.removeLast();
			if (!itemDeque.contains(newItem)) {
				
				// Initialize
				if (newData == null) newData = new ArrayDeque<>();
				
				newData.add(newItem);
				itemDeque.push(newItem);
				
				if (itemDeque.size() > RSSParser.maxItemsStored) {
					itemDeque.removeLast();
				}
			}
		}
		
		if (newData == null) return null;
		return getObjectBuilder(newData);
	}
	
	private Deque<RSSFeedItem> pullFeed() {
		try {
			Document doc = dBuilder.parse(url);
			if (prevRSSDoc != null && prevRSSDoc.isEqualNode(doc)) {
				return null;
			} else {
				prevRSSDoc = doc;
			}
			
			Element root = doc.getDocumentElement();
			if (!initialised) {
				return RSSParser.initAndParseFeed(root, this);
			} else {
				return RSSParser.parseFeed(root);
			}
			
		} catch (XPathExpressionException e) {
			logger.log(Level.WARNING, "Failed to read XML into RSS format "
					+ "from feed: " + url);
			
		} catch (IOException e) {
			logger.log(Level.WARNING, "IO error connecting to feed: " + url);
			
		} catch (SAXException e) {
			logger.log(Level.WARNING, "Error parsing XML from feed: " + url);
			
		} catch (Exception e) {
			logger.log(Level.WARNING, "Unexpected error from feed: " + url);
			// e.printStackTrace();
		}
		return null;
	}

	private JsonObjectBuilder getObjectBuilder(Deque<RSSFeedItem> newData) {		
		if (!initialised) return null;
		
		JsonObjectBuilder objectBuilder =
			Json.createObjectBuilder()
			.add("title", title)
			.add("description", description)
			.add("category", category)
			.add("source", title);
		
		JsonArrayBuilder arrayBuilder = 
				Json.createArrayBuilder();
		
		for (RSSFeedItem item : newData) {
			arrayBuilder.add(item.getObjectBuilder());
		}
		
		objectBuilder.add("updates", arrayBuilder);
		return objectBuilder;
	}
	
	public JsonObjectBuilder getObjectBuilder() {
		return getObjectBuilder(itemDeque);
	}

	public Deque<RSSFeedItem> getItems() {
		return itemDeque;
	}

	public String getUrl() {
		return url;
	}
}
