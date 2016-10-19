package code;

import java.util.List;
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
	private static final long pollingInterval = 20000;
	private static final long rssWaitingTime = pollingInterval / 2;

	private List<String> rssUrls;
	private RSSDataStore rssData;

	/* Use the container's timer service */
	@Resource TimerService tservice;
	private static final Logger logger = Logger.getLogger("BackgroundProcess");

	@PostConstruct
	public void init() {
		/* Initialize the EJB and create a timer */
		logger.log(Level.INFO, "Initializing EJB.");
		rssUrls = readUrls();
		rssData = new RSSDataStore(rssUrls, logger);
		tservice.createIntervalTimer(100, pollingInterval, new TimerConfig());
	}

	@Timeout
	public void pollRSSFeeds() {
		/* Adjust price and volume and send updates */
		try {
			logger.log(Level.INFO, "Reading data from RSS feeds...");
			String updateJson = rssData.update(rssWaitingTime);
			if (updateJson == null) {
				logger.log(Level.INFO, "No new RSS data.");
			} else {
				WebsocketServer.send(updateJson);
				logger.log(Level.INFO, "New RSS data sent.");
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Failed to create JSON from feeds.");
		}
	}
	
	private List<String> readUrls() {
		return null;
	}
}
