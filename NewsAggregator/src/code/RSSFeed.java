package src.code;

import java.util.ArrayList;

//the overall RSS feed
public class RSSFeed {
	
	String title;
	String description;
	String link;
	String category;
	
	//contains all the news stories from the feed
	ArrayList<RSSFeedItem> items = new ArrayList<RSSFeedItem>();

	public RSSFeed() {
		
	}

	//constructor fills the required RSS tags
	public RSSFeed(String title, String description, String link) {
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

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<RSSFeedItem> getItems() {
		return items;
	}
	
	public void addItem(RSSFeedItem item) {
		items.add(item);
	}
}
