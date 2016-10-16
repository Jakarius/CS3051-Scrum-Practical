package src.code;


//the separate news items within the RSS feed
public class RSSFeedItem {

	String title;
	String description;
	String link;
	String pubDate;
	String media;
	
	public RSSFeedItem() {
		
	}
	
	//constructor fills the required RSS tags
	public RSSFeedItem(String title, String description, String link) {
		this.title = title;
		this.description = description;
		this.link = link;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	public String getMedia() {
		return media;
	}
	
	public void setMedia(String media) {
		this.media = media;
	}
}
