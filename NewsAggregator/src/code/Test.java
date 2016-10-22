package code;

import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		Map<String, Set<String>>rssUrls = Links.getLinks();
		RSSDataStore rssData = new RSSDataStore(rssUrls);
		rssData.update();
		/*for (RSSFeed feed : rssData.getFeeds()) {
			Deque<RSSFeedItem> dq = feed.getItems();
			System.out.println(feed.getUrl());
			if (dq == null || dq.isEmpty()) {
				System.err.println("Empty");
			} else {
				System.out.println(dq.getLast().getMedia());
			}
			System.out.println();
		}*/
	}
}
