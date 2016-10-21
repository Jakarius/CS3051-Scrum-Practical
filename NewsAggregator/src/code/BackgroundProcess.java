package code;

import java.util.Map;
import java.util.Set;
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
	private Map<String, Set<String>> rssUrls;
	private RSSDataStore rssData;
	private static final long timeout = 30000;

	private static final Logger logger = Logger.getLogger("BackgroundProcess");
	@Resource
	TimerService tservice;
	
	@PostConstruct
	public void init() {
		/* Initialize the EJB and create a timer */
		logger.log(Level.INFO, "Initializing EJB.");
		rssUrls = Links.getLinks();
		rssData = new RSSDataStore(rssUrls);
		tservice.createIntervalTimer(1000, timeout, new TimerConfig());
	}
	
	@Timeout
	public void pollRSSFeeds() {
		/* Adjust price and volume and send updates */
		try {
			logger.log(Level.INFO, "Reading data from RSS feeds ...");
			String updateJson = rssData.update();
			if (updateJson == null) {
				logger.log(Level.INFO, "No new RSS data.");
			} else {
				logger.log(Level.INFO, "New RSS data read.");
				WebsocketServer.send(updateJson);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Failed to create JSON from feeds.");
			e.printStackTrace();
		}
	}
	
	public String getNewConnectionJson() {
		return rssData == null ? null : rssData.toJson();
	}
}
