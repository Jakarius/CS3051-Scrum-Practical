package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class Test {

	public static void main(String[] args) {
		List<String> rssUrls = getURLs();
		Logger logger = Logger.getLogger("BackgroundProcess");
		
		init(rssUrls, logger);
		update();
	}
	
	private static List<String> getURLs() {
		try (Stream<String> stream = Files.lines(Paths.get("feedlist.txt"))) {
			return stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	// This code is a slightly modified version of that found in the
	// RSSDataStore class. The only modifications relate to logging state - 
	// the logic is all the same
	private static Set<RSSFeed> feedDataSet;
	
	private static void init(List<String> rssUrls, Logger logger) {
		feedDataSet = new HashSet<>();
		for (String url: rssUrls) {
			add(new RSSFeed(url, logger));
		}
	}
	
	private static void add(RSSFeed feed) {
		feedDataSet.add(feed);
	}
	
	private static String update() {
		Set<JsonObjectBuilder> updateData = new HashSet<>();
		int success = 0, failure = 0;
		for (RSSFeed feed : feedDataSet) {
			JsonObjectBuilder objB = feed.update();
			if (objB != null) {
				updateData.add(objB);
				success++;
			} else failure++;
			
			System.out.println("Success: " + success + " | Failure: " + failure);
		}
		return toJson(updateData);
	}

	private static String toJson(Set<JsonObjectBuilder> jsonObjects) {
		if (jsonObjects.isEmpty()) return null;
		
		JsonArrayBuilder arrayBuilder = 
				Json.createArrayBuilder();
		
		for (JsonObjectBuilder objB : jsonObjects) {
			arrayBuilder.add(objB);
		}
		
		return arrayBuilder.build().toString();
	}	
}
