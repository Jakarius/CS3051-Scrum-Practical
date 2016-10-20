package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

@Singleton
@Startup
public class BackgroundProcess {
	private List<String> rssUrls;
	private RSSDataStore rssData;

	private static final Logger logger = Logger.getLogger("BackgroundProcess");
	@Resource
	TimerService tservice;
	
	@PostConstruct
	public void init() {
		/* Initialize the EJB and create a timer */
		logger.log(Level.INFO, "Initializing EJB.");
		rssUrls = readUrls();
		rssData = new RSSDataStore(rssUrls);
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
	
	private List<String> readUrls() {
		InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("/feedlist.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		List<String> out = new ArrayList<>();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				out.add(line);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Read input from feeds file.");
		}
		return out;
	}
	
	public String getNewConnectionJson() {
		return rssData.toJson();
	}
}
