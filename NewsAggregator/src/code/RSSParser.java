package code;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RSSParser {
	public static final int maxItemsStored = 5;

	public static Deque<RSSFeedItem> initAndParseFeed(Element root, RSSFeed feedQueue)
			throws XPathExpressionException {

		//creates an XPath to get the information from the channel tag
		XPath xPathChannel = XPathFactory.newInstance().newXPath();
		XPathExpression expressionChannel = xPathChannel.compile("//channel");
		Node channel = (Node)expressionChannel.evaluate(root, XPathConstants.NODE);
		Node childChannel;

		//gets the title of the channel and stores it in the object
		expressionChannel = xPathChannel.compile("title");
		childChannel = (Node)expressionChannel.evaluate(channel, XPathConstants.NODE);
		String title = childChannel.getTextContent();

		//gets the description of the channel and stores it in the object
		expressionChannel = xPathChannel.compile("description");
		childChannel = (Node)expressionChannel.evaluate(channel, XPathConstants.NODE);
		String description = childChannel.getTextContent();

/*		//gets the link of the channel and stores it in the object
		expressionChannel = xPathChannel.compile("link");
		childChannel = (Node)expressionChannel.evaluate(channel, XPathConstants.NODE);
		String link = childChannel.getTextContent();*/

		feedQueue.initialise(title, description);

		return parseFeed(root);
	}

	public static Deque<RSSFeedItem> parseFeed(Element root) throws XPathExpressionException {

		//creates an XPath to get the information from all the item tags
		XPath xPath = XPathFactory.newInstance().newXPath();
		XPathExpression expression = xPath.compile("//item");
		NodeList list = (NodeList)expression.evaluate(root, XPathConstants.NODESET);

		Deque<RSSFeedItem> updateData = new ArrayDeque<>();
		//loops through every item in the feed to get the information
		int sz = maxItemsStored;
		if (list.getLength() < sz) sz = list.getLength();
		for (int i = 0; i < sz; i++) {

			Node node = list.item(i);

			RSSFeedItem feedItem = parseFeedItem(expression, xPath, node);
			updateData.push(feedItem);
		}

		return updateData;
	}

	private static RSSFeedItem parseFeedItem(XPathExpression expression, XPath xPath, Node node)
			throws XPathExpressionException {

		Node child;

		//gets the title of the article and stores it in the object
		expression = xPath.compile("title");
		child = (Node)expression.evaluate(node, XPathConstants.NODE);
		String title = child.getTextContent();

		//gets the description of the article and stores it in the object
		expression = xPath.compile("description");
		child = (Node)expression.evaluate(node, XPathConstants.NODE);
		String description = child.getTextContent();

		//gets the link of the article and stores it in the object
		expression = xPath.compile("link");
		child = (Node)expression.evaluate(node, XPathConstants.NODE);
		String link = child.getTextContent();

		//gets the date of the article and stores it in the object
		expression = xPath.compile("pubDate");
		child = (Node)expression.evaluate(node, XPathConstants.NODE);
		String pubDate = child.getTextContent();
		
		System.out.println(pubDate);

		return new RSSFeedItem(title, description, link, pubDate, null);
	}
}