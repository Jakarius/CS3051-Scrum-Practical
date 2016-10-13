import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import java.io.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class MainGetter {
public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse("http://feeds.bbci.co.uk/news/world/rss.xml");
		Element root = doc.getDocumentElement();
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		XPathExpression expression = xPath.compile("//item");
		NodeList list = (NodeList)expression.evaluate(root, XPathConstants.NODESET);
		
		System.out.println("Found " + list.getLength() + "items");
		
		for (int i = 0; i < list.getLength(); i++) {
			
			Node node = list.item(i);
			expression = xPath.compile("title");
			Node child = (Node)expression.evaluate(node, XPathConstants.NODE);
			System.out.println(child.getTextContent());
		}
		
		/*
		
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	//Document doc = dBuilder.parse();
    	
    	
    	
    	URL NEWSITE;
        try{
        	NEWSITE = new URL("	http://feeds.bbci.co.uk/news/world/rss.xml");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(NEWSITE.openStream()));
       	//org.w3c.dom.Document doc = dBuilder.parse(NEWSITE.openStream());
      
     //  	System.out.print(doc.getDoctype());
       	String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
       
        in.close(); 
        }
        catch(IOException ex){
        	System.out.println("bad URL");
        }
        
        */
        
    }
}