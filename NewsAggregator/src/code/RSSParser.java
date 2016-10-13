import java.net.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.io.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RSSParser {
public static void main(String[] args) throws Exception {
		
		//creates a document builder to parse the RSS Feed
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
		Element root = doc.getDocumentElement();
		
		RSSFeed feed = new RSSFeed();
		
		parseFeed(root, feed);
		
		//prints out the information as a test
		System.out.println(feed.getTitle() + "\n" + feed.getDescription() + "\n" + feed.getLink() + "\n\n");
		
		ArrayList<RSSFeedItem> items = feed.getItems();
		
		for (int i = 0; i < items.size(); i++) {
			
			System.out.println(items.get(i).getTitle() + "\n" + items.get(i).getDescription() + "\n" 
					+ items.get(i).getLink() + "\n" + items.get(i).getPubDate() + "\n");
		}
    }

	public static void parseFeed(Element root, RSSFeed feed) throws XPathExpressionException {
		
		//creates an XPath to get the information from the channel tag
		XPath xPathChannel = XPathFactory.newInstance().newXPath();
		XPathExpression expressionChannel = xPathChannel.compile("//channel");
		Node channel = (Node)expressionChannel.evaluate(root, XPathConstants.NODE);
		Node childChannel;
				
		//gets the title of the channel and stores it in the object
		expressionChannel = xPathChannel.compile("title");
		childChannel = (Node)expressionChannel.evaluate(channel, XPathConstants.NODE);
		feed.setTitle(childChannel.getTextContent());
				
		//gets the description of the channel and stores it in the object
		expressionChannel = xPathChannel.compile("description");
		childChannel = (Node)expressionChannel.evaluate(channel, XPathConstants.NODE);
		feed.setDescription(childChannel.getTextContent());
				
		//gets the link of the channel and stores it in the object
		expressionChannel = xPathChannel.compile("link");
		childChannel = (Node)expressionChannel.evaluate(channel, XPathConstants.NODE);
		feed.setLink(childChannel.getTextContent());
		
		parseItems(root, feed);
	}
	
	public static void parseItems(Element root, RSSFeed feed) throws XPathExpressionException {
		
		//creates an XPath to get the information from all the item tags
		XPath xPath = XPathFactory.newInstance().newXPath();
		XPathExpression expression = xPath.compile("//item");
		NodeList list = (NodeList)expression.evaluate(root, XPathConstants.NODESET);
				
		//loops through every item in the feed to get the information
		for (int i = 0; i < list.getLength(); i++) {
					
			Node node = list.item(i);
			RSSFeedItem item = new RSSFeedItem();
			
			parseItem(item, expression, xPath, node);
			
			feed.addItem(item);
		}
	}
	
	public static void parseItem(RSSFeedItem item, XPathExpression expression, XPath xPath, Node node) throws XPathExpressionException {
		
		Node child;
		
		//gets the title of the article and stores it in the object
		expression = xPath.compile("title");
		child = (Node)expression.evaluate(node, XPathConstants.NODE);
		item.setTitle(child.getTextContent());
				
		//gets the description of the article and stores it in the object
		expression = xPath.compile("description");
		child = (Node)expression.evaluate(node, XPathConstants.NODE);
		item.setDescription(child.getTextContent());

		//gets the link of the article and stores it in the object
		expression = xPath.compile("link");
		child = (Node)expression.evaluate(node, XPathConstants.NODE);
		item.setLink(child.getTextContent());
				
		//gets the date of the article and stores it in the object
		expression = xPath.compile("pubDate");
		child = (Node)expression.evaluate(node, XPathConstants.NODE);
		item.setPubDate(child.getTextContent());
	}
}