package code;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class RSSFeedItem {

	private String title;
	private String description;
	private String link;
	private String pubDate;
	private String media;
	
	public RSSFeedItem(String title, String description, String link,
			String pubDate, String media) {
		this.title = title;
		this.description = description;
		this.link = link;
		this.pubDate = pubDate;
		this.media = media;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	
	public String getMedia() {
		return media;
	}
	
	public JsonObjectBuilder getObjectBuilder() {
		JsonObjectBuilder objB = Json.createObjectBuilder();
		if (title != null) 			objB.add("title", title);
		if (description != null) 	objB.add("description", description);
		if (link != null) 			objB.add("link", link);
		if (pubDate != null) 		objB.add("pubDate", pubDate);
		if (media != null) 			objB.add("media", media);
		return objB;
	}
}
