package code;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
 
/** 
 * @ServerEndpoint gives the relative name for the end point
 * This will be accessed via ws://localhost:8080/EchoChamber/echo
 * Where "localhost" is the address of the host,
 * "EchoChamber" is the name of the package
 * and "echo" is the address to access this class from the server
 */
@ApplicationScoped
@ServerEndpoint("/test")
public class WebsocketServer {
    /**
     * @throws Exception 
     * @OnOpen allows us to intercept the creation of a new session.
     * The session class allows us to send data to the user.
     * In the method onOpen, we'll let the user know that the handshake was 
     * successful.
     */
    @OnOpen
    public void onOpen(Session session) throws Exception{
        System.out.println(session.getId() + " has opened a connection");
        try {
          
        /*These are the old tests for the websocket	
          TimeUnit.SECONDS.sleep(5);
          session.getBasicRemote().sendText("here is some news");
            */
         
        //this is the reference to the method that gets the rss feeds and puts them in a very basic html format
        //if i carried on then this would be sending the string representation of a json object for the javascript to parse
		session.getBasicRemote().sendText(xmlToJson.getJson());
			

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
 
    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. For now the message is read as a String.
     */
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
    }
 
    /**
     * The user closes the connection.
     * 
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session){
        System.out.println("Session " +session.getId()+" has ended");
    }
}