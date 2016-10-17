package code;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@Startup
public class BackgroundProcess {

	   /* Use the container's timer service */
	   @Resource TimerService tservice;
	   private Random random;
	   private static final Logger logger = Logger.getLogger("BackgroundProcess");
	   
	   @PostConstruct
	   public void init() {
	       /* Initialize the EJB and create a timer */
	       logger.log(Level.INFO, "Initializing EJB.");
	       random = new Random();
	       tservice.createIntervalTimer(1000, 1000, new TimerConfig());
	   }
	   
	   @Timeout
	   public void timeout() {
	       /* Adjust price and volume and send updates */
	       int i = random.nextInt(10);
	       WebsocketServer.send(Integer.toString(i));
	   }
}
