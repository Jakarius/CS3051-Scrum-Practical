package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinksTest {
    public static void main(String[] args) {
    	Map<String, Set<String>> rssUrls = getLinks();
    	RSSDataStore rssData = new RSSDataStore(rssUrls);
    	rssData.update();
    	String rssJSON = rssData.toJson();
		System.out.println((rssJSON == null));
    	jprettyPrint(rssJSON);

} 
    
public static Map<String, Set<String>> getLinks() {

	Map<String, Set<String>> categoryMap = new HashMap<>();
	
	// UK
	Set<String> ukLinks = new HashSet<>();
		ukLinks.add("http://feeds.reuters.com/reuters/UKTopNews");
		ukLinks.add("http://feeds.bbci.co.uk/news/uk/rss.xml?edition=uk");
		ukLinks.add("http://www.independent.co.uk/news/uk/rss");
		ukLinks.add("https://www.theguardian.com/uk/rss");
	categoryMap.put("UK", ukLinks);

	// England
	Set<String> engLinks = new HashSet<>();
		engLinks.add("http://feeds.bbci.co.uk/news/england/rss.xml?edition=uk");
	categoryMap.put("England", engLinks);

	// Scotland
	Set<String> scotLinks = new HashSet<>();
		scotLinks.add("http://feeds.bbci.co.uk/news/scotland/rss.xml?edition=uk");
	categoryMap.put("Scotland", scotLinks);

	// Ireland
	Set<String> ireLinks = new HashSet<>();
		ireLinks.add("http://feeds.bbci.co.uk/news/northern_ireland/rss.xml?edition=uk");
	categoryMap.put("Ireland", ireLinks);

	// Wales
	Set<String> walLinks = new HashSet<>();
		walLinks.add("http://feeds.bbci.co.uk/news/wales/rss.xml?edition=uk");
	categoryMap.put("Wales", walLinks);

	// US
	Set<String> usLinks = new HashSet<>();
		usLinks.add("http://thehill.com/rss/syndicator/19109");
		usLinks.add("http://feeds.skynews.com/feeds/rss/us.xml");
		usLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/US.xml");
		usLinks.add("http://www.dailymail.co.uk/ushome/index.rss");
	categoryMap.put("US", usLinks);

	// Asia
	Set<String> asiaLinks = new HashSet<>();
		asiaLinks.add("http://www.worldpress.org/feeds/Asia.xml");
	categoryMap.put("Asia", asiaLinks);

	// Africa
	Set<String> africaLinks = new HashSet<>();
		africaLinks.add("http://www.worldpress.org/feeds/Africa.xml");
		africaLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Africa.xml");
	categoryMap.put("Afrweica", africaLinks);

	// Middle East
	Set<String> meLinks = new HashSet<>();
		meLinks.add("http://www.worldpress.org/feeds/Mideast.xml");
		meLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/MiddleEast.xml");
	categoryMap.put("Middle East", meLinks);

	// Europe
	Set<String> euLinks = new HashSet<>();
		euLinks.add("http://www.worldpress.org/feeds/Europe.xml");
	categoryMap.put("Europe", euLinks);

	// Americas
	Set<String> americaLinks = new HashSet<>();
		americaLinks.add("http://www.worldpress.org/feeds/Americas.xml");
		americaLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Americas.xml");
	categoryMap.put("Americas", americaLinks);

	// Australia
	Set<String> ausLinks = new HashSet<>();
		ausLinks.add("http://www.dailymail.co.uk/auhome/index.rss");
	categoryMap.put("Australia", ausLinks);

	// World
	Set<String> worldLinks = new HashSet<>();
		worldLinks.add("http://www.aljazeera.com/xml/rss/all.xml");
		worldLinks.add("http://feeds.reuters.com/reuters/UKWorldNews");
		worldLinks.add("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
		//worldLinks.add("http://feeds.skynews.com/feeds/rss/world.xml");
		worldLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/World.xml");
		worldLinks.add("http://www.independent.co.uk/news/world/rss");
		worldLinks.add("https://www.theguardian.com/world/rss");
	categoryMap.put("World", worldLinks);

	// Business
	Set<String> businessLinks = new HashSet<>();
		businessLinks.add("http://feeds.bbci.co.uk/news/business/rss.xml?edition=uk");
		businessLinks.add("http://feeds.skynews.com/feeds/rss/business.xml");
		businessLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Business.xml");
		businessLinks.add("http://www.independent.co.uk/news/business/rss");
		businessLinks.add("https://www.theguardian.com/uk/business/rss");
	categoryMap.put("Business", businessLinks);


	// Politics
	Set<String> polLinks = new HashSet<>();
		polLinks.add("http://feeds.bbci.co.uk/news/politics/rss.xml?edition=uk");
		polLinks.add("http://feeds.skynews.com/feeds/rss/politics.xml");
		polLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Politics.xml");
		polLinks.add("http://feeds.foxnews.com/foxnews/politics?format=xml");
		polLinks.add("https://www.theguardian.com/politics/rss");
	categoryMap.put("Politics", polLinks);

	// Health
	Set<String> healthLinks = new HashSet<>();
		healthLinks.add("http://feeds.reuters.com/reuters/UKHealthNews");
		healthLinks.add("http://feeds.bbci.co.uk/news/health/rss.xml?edition=uk");
		healthLinks.add("http://www.dailymail.co.uk/health/index.rss");
		healthLinks.add("http://feeds.foxnews.com/foxnews/health?format=xml");
	categoryMap.put("Health", healthLinks);

	// Education
	Set<String> eduLinks = new HashSet<>();
		eduLinks.add("http://feeds.bbci.co.uk/news/education/rss.xml?edition=uk");
		eduLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Education.xml");
		eduLinks.add("http://www.independent.co.uk/news/education/rss");
	categoryMap.put("Education", eduLinks);

	// Science
	Set<String> sciLinks = new HashSet<>();
		sciLinks.add("http://feeds.reuters.com/reuters/UKScienceNews");
		sciLinks.add("http://feeds.bbci.co.uk/news/science_and_environment/rss.xml?edition=uk");
		sciLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Space.xml");
		sciLinks.add("http://www.independent.co.uk/news/science/rss");
		sciLinks.add("http://www.dailymail.co.uk/sciencetech/index.rss");
		sciLinks.add("http://feeds.foxnews.com/foxnews/science?format=xml");
	categoryMap.put("Science", sciLinks);

	// Technology
	Set<String> techLinks = new HashSet<>();
		techLinks.add("http://feeds.reuters.com/reuters/technologyNews");
		techLinks.add("http://feeds.bbci.co.uk/news/technology/rss.xml?edition=uk");
		techLinks.add("http://feeds.skynews.com/feeds/rss/technology.xml");
		techLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
		techLinks.add("http://feeds.foxnews.com/foxnews/tech?format=xml");
		techLinks.add("https://www.theguardian.com/uk/technology/rss");
		techLinks.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-tech/news.xml");
	categoryMap.put("Technology", techLinks);

	// Entertainment
	Set<String> entLinks = new HashSet<>();
		entLinks.add("http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml?edition=uk");
		entLinks.add("http://feeds.skynews.com/feeds/rss/entertainment.xml");
		entLinks.add("http://www.dailymail.co.uk/tvshowbiz/index.rss");
		entLinks.add("http://feeds.foxnews.com/foxnews/entertainment?format=xml");
		entLinks.add("http://www.mtv.com/rss/news/news_full.jhtml");
		entLinks.add("http://www.mtv.com/news/movies/feed/");
		entLinks.add("http://feeds.ign.com/ign/news?format=xml");
		entLinks.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-entertainment/news.xml");
	categoryMap.put("Entertainment", entLinks);

	// Sport
	Set<String> sportLinks = new HashSet<>();
		sportLinks.add("http://feeds.reuters.com/reuters/UKSportsNews");
		sportLinks.add("http://www.dailymail.co.uk/sport/index.rss");
		sportLinks.add("https://www.theguardian.com/uk/sport/rss");
		sportLinks.add("https://www.theguardian.com/football/rss");
		sportLinks.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-sport/news.xml");
	categoryMap.put("Sport", sportLinks);

	// Travel
	Set<String> travLinks = new HashSet<>();
		travLinks.add("http://feeds.abcnews.com/abcnews/travelheadlines");
		travLinks.add("http://www.dailymail.co.uk/travel/index.rss");
		travLinks.add("https://www.theguardian.com/uk/travel/rss");
	categoryMap.put("Travel", travLinks);

	return categoryMap;
}
    
    


public static void jprettyPrint(String rssJSON){	
	int x = 50;
	int j = 0;
	while(j+x<rssJSON.length()){
		
		char[] a = new char[90];
		for (int i = 0; i < a.length; i++)
		{
			a[i]=' ';
		}		
		rssJSON.getChars(j, j+x, a, 0);
		int h = 0;
		while (h<x){
		 System.out.print(a[h]);
		 if(a[h]=='}'||((h>1) && ((a[h-1]=='"') && ( (a[h]==',') && (a[h+1]=='"') )) )){
			 System.out.println("");
		 }
		 if(a[h]=='}'){
			 System.out.println("\n");
		 }
		 h++;
		}
		j = j+x;
	}
	int left = rssJSON.length() - j;
	char[] b = new char[left];
	rssJSON.getChars(j, rssJSON.length()-1, b, 0);
	System.out.println(String.valueOf(b));
}
    
}
