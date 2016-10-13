import java.net.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import org.w3c.dom.Document;

public class MainGetter {
public static void main(String[] args) throws Exception {
				
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
    }
}