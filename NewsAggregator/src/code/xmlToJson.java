package code;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmlToJson{
	
public static String getJson() throws Exception{

	String Jsontext = "";
	ArrayList<String> rssLinks = RSSParser.getLinks();
	
	for (int i = 0; i < rssLinks.size()/6; i++) {
		try {
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(rssLinks.get(i));
	Element root = doc.getDocumentElement();
	RSSFeed feed = new RSSFeed();
	//this uses Taylor's xml parser
	RSSParser.parseFeed(root, feed);
	
	
	for (int j = 0; j <feed.getItems().size()/6; j++) {
		RSSFeedItem item = feed.getItems().get(j);	
		Jsontext = Jsontext.concat(" <br> <br> "+item.getTitle() + "<br>" + item.getDescription()+"<br><a href=\"url\">" + item.getLink())+"</a>";
	}
	

		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ParserConfigurationException e) {
		e.printStackTrace();
		} 
		catch (SAXException e) {
		e.printStackTrace();
		}	
	}
	System.out.println(Jsontext);
	return Jsontext;
}
}
