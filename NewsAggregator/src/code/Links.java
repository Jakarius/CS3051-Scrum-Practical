package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Links {

	// uk, england, scotland, ireland, wales, us, asia, africa, 
	// middle east, europe, americas, australia, world, business, politics,
	// heath, education, science, technology, entertainment, sport, travel
	public static Map<String, Set<String>> getLinks() {

		Map<String, Set<String>> categoryMap = new HashMap<>();
		
		// UK
		Set<String> ukLinks = new HashSet<>();
		ukLinks.add("http://feeds.bbci.co.uk/news/uk/rss.xml?edition=uk");
		ukLinks.add("http://feeds.skynews.com/feeds/rss/uk.xml");
		ukLinks.add("http://www.independent.co.uk/news/uk/rss");
		ukLinks.add("https://www.theguardian.com/uk/rss");
		categoryMap.put("uk", ukLinks);

		// England
		Set<String> engLinks = new HashSet<>();
		engLinks.add("http://feeds.bbci.co.uk/news/england/rss.xml?edition=uk");
		categoryMap.put("england", engLinks);

		// Scotland
		Set<String> scotLinks = new HashSet<>();
		scotLinks.add("http://feeds.bbci.co.uk/news/scotland/rss.xml?edition=uk");
		categoryMap.put("scotland", scotLinks);

		// Ireland
		Set<String> ireLinks = new HashSet<>();
		ireLinks.add("http://feeds.bbci.co.uk/news/northern_ireland/rss.xml?edition=uk");
		categoryMap.put("ireland", ireLinks);

		// Wales
		Set<String> walLinks = new HashSet<>();
		walLinks.add("http://feeds.bbci.co.uk/news/wales/rss.xml?edition=uk");
		categoryMap.put("wales", walLinks);

		// US
		Set<String> usLinks = new HashSet<>();
		usLinks.add("http://feeds.skynews.com/feeds/rss/us.xml");
		//usLinks.add("http://rss.cnn.com/rss/edition_us.rss");
		usLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/US.xml");
		usLinks.add("http://www.dailymail.co.uk/ushome/index.rss");
		categoryMap.put("us", usLinks);

		// Asia
		Set<String> asiaLinks = new HashSet<>();
		//asiaLinks.add("http://rss.cnn.com/rss/edition_asia.rss");
		asiaLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/AsiaPacific.xml");
		categoryMap.put("asia", asiaLinks);

		// Africa
		Set<String> africaLinks = new HashSet<>();
		africaLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Africa.xml");
		//africaLinks.add("http://rss.cnn.com/rss/edition_africa.rss");
		categoryMap.put("africa", africaLinks);

		// Middle East
		Set<String> meLinks = new HashSet<>();
		//meLinks.add("http://rss.cnn.com/rss/edition_meast.rss");
		meLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/MiddleEast.xml");
		categoryMap.put("middle east", meLinks);

		// Europe
		Set<String> euLinks = new HashSet<>();
		euLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Europe.xml");
		//euLinks.add("http://rss.cnn.com/rss/edition_europe.rss");
		categoryMap.put("europe", euLinks);

		// Americas
		Set<String> americaLinks = new HashSet<>();
		//americaLinks.add("http://rss.cnn.com/rss/edition_americas.rss");
		americaLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Americas.xml");
		categoryMap.put("americas", americaLinks);

		// Australia
		Set<String> ausLinks = new HashSet<>();
		ausLinks.add("http://www.dailymail.co.uk/auhome/index.rss");
		categoryMap.put("australia", ausLinks);

		// World
		Set<String> worldLinks = new HashSet<>();
		worldLinks.add("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
		worldLinks.add("http://feeds.skynews.com/feeds/rss/world.xml");
		//worldLinks.add("http://rss.cnn.com/rss/edition_world.rss);
		worldLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/World.xml");
		worldLinks.add("http://www.independent.co.uk/news/world/rss");
		worldLinks.add("https://www.theguardian.com/world/rss");
		categoryMap.put("world", worldLinks);

		// Business
		Set<String> businessLinks = new HashSet<>();
		businessLinks.add("http://feeds.bbci.co.uk/news/business/rss.xml?edition=uk");
		businessLinks.add("http://feeds.skynews.com/feeds/rss/business.xml");
		businessLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Business.xml");
		businessLinks.add("http://www.independent.co.uk/news/business/rss");
		businessLinks.add("https://www.theguardian.com/uk/business/rss");
		categoryMap.put("business", businessLinks);


		// Politics
		Set<String> polLinks = new HashSet<>();
		polLinks.add("http://feeds.bbci.co.uk/news/politics/rss.xml?edition=uk");
		polLinks.add("http://feeds.skynews.com/feeds/rss/politics.xml");
		polLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Politics.xml");
		polLinks.add("http://feeds.foxnews.com/foxnews/politics?format=xml");
		polLinks.add("https://www.theguardian.com/politics/rss");
		polLinks.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-politics/news.xml");
		categoryMap.put("politics", polLinks);

		// Health
		Set<String> healthLinks = new HashSet<>();
		healthLinks.add("http://feeds.bbci.co.uk/news/health/rss.xml?edition=uk");
		healthLinks.add("http://www.dailymail.co.uk/health/index.rss");
		healthLinks.add("http://feeds.foxnews.com/foxnews/health?format=xml");
		categoryMap.put("health", healthLinks);

		// Education
		Set<String> eduLinks = new HashSet<>();
		eduLinks.add("http://feeds.bbci.co.uk/news/education/rss.xml?edition=uk");
		eduLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Education.xml");
		eduLinks.add("http://www.independent.co.uk/news/education/rss");
		categoryMap.put("education", eduLinks);

		// Science
		Set<String> sciLinks = new HashSet<>();
		sciLinks.add("http://feeds.bbci.co.uk/news/science_and_environment/rss.xml?edition=uk");
		//sciLinks.add("http://rss.cnn.com/rss/edition_space.rss");
		sciLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Science.xml");
		sciLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Space.xml");
		sciLinks.add("http://www.independent.co.uk/news/science/rss");
		sciLinks.add("http://www.dailymail.co.uk/sciencetech/index.rss");
		sciLinks.add("http://feeds.foxnews.com/foxnews/science?format=xml");
		categoryMap.put("science", sciLinks);

		// Technology
		Set<String> techLinks = new HashSet<>();
		techLinks.add("http://feeds.bbci.co.uk/news/technology/rss.xml?edition=uk");
		techLinks.add("http://feeds.skynews.com/feeds/rss/technology.xml");
		//techLinks.add("http://rss.cnn.com/rss/edition_technology.rss");
		techLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
		techLinks.add("http://feeds.foxnews.com/foxnews/tech?format=xml");
		techLinks.add("https://www.theguardian.com/uk/technology/rss");
		techLinks.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-tech/news.xml");
		categoryMap.put("technology", techLinks);

		// Entertainment
		Set<String> entLinks = new HashSet<>();
		entLinks.add("http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml?edition=uk");
		entLinks.add("http://feeds.skynews.com/feeds/rss/entertainment.xml");
		//entLinks.add("http://rss.cnn.com/rss/edition_entertainment.rss");
		entLinks.add("http://www.dailymail.co.uk/tvshowbiz/index.rss");
		entLinks.add("http://feeds.foxnews.com/foxnews/entertainment?format=xml");
		entLinks.add("http://www.mtv.com/rss/news/news_full.jhtml");
		entLinks.add("http://www.mtv.com/news/movies/feed/");
		entLinks.add("http://feeds.ign.com/ign/news?format=xml");
		entLinks.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-entertainment/news.xml");
		categoryMap.put("entertainment", entLinks);

		// Sport
		Set<String> sportLinks = new HashSet<>();
		/*sportLinks.add("http://rss.cnn.com/rss/edition_sport.rss");
		sportLinks.add("http://rss.cnn.com/rss/edition_football.rss");
		sportLinks.add("http://rss.cnn.com/rss/edition_golf.rss");
		sportLinks.add("http://rss.cnn.com/rss/edition_motorsport.rss");
		sportLinks.add("http://rss.cnn.com/rss/edition_tennis.rss");
		sportLinks.add("http://rss.nytimes.com/services/xml/rss/nyt/Sports.xml");*/
		sportLinks.add("http://www.dailymail.co.uk/sport/index.rss");
		sportLinks.add("https://www.theguardian.com/uk/sport/rss");
		sportLinks.add("https://www.theguardian.com/football/rss");
		sportLinks.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-sport/news.xml");
		categoryMap.put("sport", sportLinks);

		// Travel
		Set<String> travLinks = new HashSet<>();
		//travLinks.add("http://rss.cnn.com/rss/edition_travel.rss");
		travLinks.add("http://www.dailymail.co.uk/travel/index.rss");
		travLinks.add("https://www.theguardian.com/uk/travel/rss");
		categoryMap.put("travel", travLinks);

		return categoryMap;
	}
}
