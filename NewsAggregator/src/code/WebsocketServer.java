package src.code;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
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

	private static final Logger logger = Logger.getLogger("WebsocketServer");
	/* Queue for all open WebSocket sessions */
	static Queue<Session> queue = new ConcurrentLinkedQueue<>();

	public static void send(String msg) {
		try {
			/* Send updates to all open WebSocket sessions */
			for (Session session : queue) {
				session.getBasicRemote().sendText(msg);
				logger.log(Level.INFO, "Sent: {0}", msg);
			}
		} catch (IOException e) {
			logger.log(Level.INFO, e.toString());
		}
	}

	
	@OnOpen
	public void openConnection(Session session) {
		/* Register this connection in the queue */
		queue.add(session);
		logger.log(Level.INFO, "Connection opened.");
	}

	@OnClose
	public void closedConnection(Session session) {
		/* Remove this connection from the queue */
		queue.remove(session);
		logger.log(Level.INFO, "Connection closed.");
	}

	@OnError
	public void error(Session session, Throwable t) {
		/* Remove this connection from the queue */
		queue.remove(session);
		logger.log(Level.INFO, t.toString());
		logger.log(Level.INFO, "Connection error.");
	}
}