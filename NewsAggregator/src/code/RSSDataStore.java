package code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class RSSDataStore {
	private Set<RSSFeed> feedDataSet;
	private static final Logger logger = Logger.getLogger("RSSDataStore");
	
	public RSSDataStore(List<String> rssUrls) {
		feedDataSet = new HashSet<>();
		for (String url: rssUrls) {
			add(new RSSFeed(url));
		}
	}

	public String update() {
		Set<JsonObjectBuilder> updateData = new HashSet<>();
		for (RSSFeed feed : feedDataSet) {
			JsonObjectBuilder objB = feed.update();
			if (objB != null) updateData.add(objB);
		}
		return toJson(updateData);
	}
	
	public void add(RSSFeed feed) {
		feedDataSet.add(feed);
	}

	public boolean isEmpty() {
		return feedDataSet.isEmpty();
	}

	private String toJson(Set<JsonObjectBuilder> jsonObjects) {
		if (jsonObjects.isEmpty()) return null;
		
		JsonArrayBuilder arrayBuilder = 
				Json.createArrayBuilder();
		
		for (JsonObjectBuilder objB : jsonObjects) {
			arrayBuilder.add(objB);
		}
		
		return arrayBuilder.build().toString();
	}
	
	public String toJson() {
		Set<JsonObjectBuilder> jsonObjects = new HashSet<>();
		for (RSSFeed feed : feedDataSet) {
			JsonObjectBuilder objB = feed.getObjectBuilder();
			if (objB != null) jsonObjects.add(objB);
		}
		return toJson(jsonObjects);
	}

	class Updater implements Runnable {
		private final RSSFeed feed;
		private final Set<JsonObjectBuilder> updateData;
		
		public Updater(RSSFeed feed, Set<JsonObjectBuilder> updateData) {
			this.feed = feed;
			this.updateData = updateData;
		}
		
		public void run() {
			JsonObjectBuilder objB = feed.update();
			if (objB != null) updateData.add(objB);
		}
	}
}
