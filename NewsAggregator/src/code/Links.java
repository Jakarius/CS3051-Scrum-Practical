package code;

import java.util.ArrayList;
import java.util.List;

public class Links {

public static List<String> getLinks() {
		
		//categories of feeds
		
		//all rss feeds
		ArrayList<String> rssList = new ArrayList<String>();
		
		//news based on location
		ArrayList<String> ukNews = new ArrayList<String>();
		ArrayList<String> englandNews = new ArrayList<String>();
		ArrayList<String> scotlandNews  = new ArrayList<String>();
		ArrayList<String> irelandNews = new ArrayList<String>();
		ArrayList<String> walesNews = new ArrayList<String>();
		ArrayList<String> usNews = new ArrayList<String>();
		ArrayList<String> asiaNews = new ArrayList<String>();
		ArrayList<String> africaNews = new ArrayList<String>();
		ArrayList<String> middleEastNews = new ArrayList<String>();
		ArrayList<String> europeNews = new ArrayList<String>();
		ArrayList<String> americasNews = new ArrayList<String>();
		ArrayList<String> australiaNews = new ArrayList<String>();
		ArrayList<String> worldNews = new ArrayList<String>();
				
		//news based on topic
		ArrayList<String> businessNews = new ArrayList<String>();
		ArrayList<String> politicsNews = new ArrayList<String>();
		ArrayList<String> healthNews = new ArrayList<String>();
		ArrayList<String> educationNews = new ArrayList<String>();
		ArrayList<String> scienceNews = new ArrayList<String>();
		ArrayList<String> technologyNews = new ArrayList<String>();
		ArrayList<String> entertainmentNews = new ArrayList<String>();
		ArrayList<String> sportNews = new ArrayList<String>();
		ArrayList<String> travelNews = new ArrayList<String>();
				
		ukNews.add("http://feeds.bbci.co.uk/news/uk/rss.xml?edition=uk");
		ukNews.add("http://feeds.skynews.com/feeds/rss/uk.xml");
		ukNews.add("http://www.independent.co.uk/news/uk/rss");
		ukNews.add("https://www.theguardian.com/uk/rss");
				
		englandNews.add(" http://feeds.bbci.co.uk/news/england/rss.xml?edition=uk");
		
		scotlandNews.add("http://feeds.bbci.co.uk/news/scotland/rss.xml?edition=uk");
				
		irelandNews.add("http://feeds.bbci.co.uk/news/northern_ireland/rss.xml?edition=uk");
			
		walesNews.add("http://feeds.bbci.co.uk/news/wales/rss.xml?edition=uk");
				
		usNews.add("http://feeds.skynews.com/feeds/rss/us.xml");
		//usNews.add("http://rss.cnn.com/rss/edition_us.rss");
		usNews.add("http://rss.nytimes.com/services/xml/rss/nyt/US.xml");
		usNews.add("http://www.dailymail.co.uk/ushome/index.rss");
			
		//asiaNews.add("http://rss.cnn.com/rss/edition_asia.rss");
		asiaNews.add("http://rss.nytimes.com/services/xml/rss/nyt/AsiaPacific.xml");
			
		//africaNews.add("http://rss.cnn.com/rss/edition_africa.rss");
		africaNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Africa.xml");
				
		//middleEastNews.add("http://rss.cnn.com/rss/edition_meast.rss");
		middleEastNews.add("http://rss.nytimes.com/services/xml/rss/nyt/MiddleEast.xml");
				
		//europeNews.add("http://rss.cnn.com/rss/edition_europe.rss");
		europeNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Europe.xml");
				
		//americasNews.add("http://rss.cnn.com/rss/edition_americas.rss");
		americasNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Americas.xml");
				
		australiaNews.add("http://www.dailymail.co.uk/auhome/index.rss");
				
		worldNews.add("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
		worldNews.add("http://feeds.skynews.com/feeds/rss/world.xml");
		//worldNews.add("http://rss.cnn.com/rss/edition_world.rss");
		worldNews.add("http://rss.nytimes.com/services/xml/rss/nyt/World.xml");
		worldNews.add("http://www.independent.co.uk/news/world/rss");
		worldNews.add("https://www.theguardian.com/world/rss");
			
		businessNews.add("http://feeds.bbci.co.uk/news/business/rss.xml?edition=uk");
		businessNews.add("http://feeds.skynews.com/feeds/rss/business.xml");
		businessNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Business.xml");
		businessNews.add("http://www.independent.co.uk/news/business/rss");
		businessNews.add("https://www.theguardian.com/uk/business/rss");
			
		politicsNews.add("http://feeds.bbci.co.uk/news/politics/rss.xml?edition=uk");
		politicsNews.add("http://feeds.skynews.com/feeds/rss/politics.xml");
		politicsNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Politics.xml");
		politicsNews.add("http://feeds.foxnews.com/foxnews/politics?format=xml");
		politicsNews.add("https://www.theguardian.com/politics/rss");
		politicsNews.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-politics/news.xml");
		
		healthNews.add("http://feeds.bbci.co.uk/news/health/rss.xml?edition=uk");
		healthNews.add("http://www.dailymail.co.uk/health/index.rss");
		healthNews.add("http://feeds.foxnews.com/foxnews/health?format=xml");

		educationNews.add("http://feeds.bbci.co.uk/news/education/rss.xml?edition=uk");
		educationNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Education.xml");
		educationNews.add("http://www.independent.co.uk/news/education/rss");
			
		scienceNews.add("http://feeds.bbci.co.uk/news/science_and_environment/rss.xml?edition=uk");
		//scienceNews.add("http://rss.cnn.com/rss/edition_space.rss");
		scienceNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Science.xml");
		scienceNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Space.xml");
		scienceNews.add("http://www.independent.co.uk/news/science/rss");
		scienceNews.add("http://www.dailymail.co.uk/sciencetech/index.rss");
		scienceNews.add("http://feeds.foxnews.com/foxnews/science?format=xml");

		technologyNews.add("http://feeds.bbci.co.uk/news/technology/rss.xml?edition=uk");
		technologyNews.add("http://feeds.skynews.com/feeds/rss/technology.xml");
		//technologyNews.add("http://rss.cnn.com/rss/edition_technology.rss");
		technologyNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
		technologyNews.add("http://feeds.foxnews.com/foxnews/tech?format=xml");
		technologyNews.add("https://www.theguardian.com/uk/technology/rss");
		technologyNews.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-tech/news.xml");
			
		entertainmentNews.add("http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml?edition=uk");
		entertainmentNews.add("http://feeds.skynews.com/feeds/rss/entertainment.xml");
		//entertainmentNews.add("http://rss.cnn.com/rss/edition_entertainment.rss");
		entertainmentNews.add("http://www.dailymail.co.uk/tvshowbiz/index.rss");
		entertainmentNews.add("http://feeds.foxnews.com/foxnews/entertainment?format=xml");
		entertainmentNews.add("http://www.mtv.com/rss/news/news_full.jhtml");
		entertainmentNews.add("http://www.mtv.com/news/movies/feed/");
		entertainmentNews.add("http://feeds.ign.com/ign/news?format=xml");
		entertainmentNews.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-entertainment/news.xml");
		
		//sportNews.add("http://rss.cnn.com/rss/edition_sport.rss");
		//sportNews.add("http://rss.cnn.com/rss/edition_football.rss");
		//sportNews.add("http://rss.cnn.com/rss/edition_golf.rss");
		//sportNews.add("http://rss.cnn.com/rss/edition_motorsport.rss");
		//sportNews.add("http://rss.cnn.com/rss/edition_tennis.rss");
		sportNews.add("http://rss.nytimes.com/services/xml/rss/nyt/Sports.xml");
		sportNews.add("http://www.dailymail.co.uk/sport/index.rss");
		sportNews.add("https://www.theguardian.com/uk/sport/rss");
		sportNews.add("https://www.theguardian.com/football/rss");
		sportNews.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-sport/news.xml");
		
		//travelNews.add("http://rss.cnn.com/rss/edition_travel.rss");
		travelNews.add("http://www.dailymail.co.uk/travel/index.rss");
		travelNews.add("https://www.theguardian.com/uk/travel/rss");
		
		rssList.add("http://feeds.bbci.co.uk/news/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/uk/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/england/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/northern_ireland/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/scotland/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/wales/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/business/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/politics/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/health/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/education/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/science_and_environment/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/technology/rss.xml?edition=uk");
		rssList.add("http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml?edition=uk");
		rssList.add("http://feeds.skynews.com/feeds/rss/home.xml");
		rssList.add("http://feeds.skynews.com/feeds/rss/uk.xml");
		rssList.add("http://feeds.skynews.com/feeds/rss/world.xml");
		rssList.add("http://feeds.skynews.com/feeds/rss/us.xml");
		rssList.add("http://feeds.skynews.com/feeds/rss/business.xml");
		rssList.add("http://feeds.skynews.com/feeds/rss/politics.xml");
		rssList.add("http://feeds.skynews.com/feeds/rss/technology.xml");
		rssList.add("http://feeds.skynews.com/feeds/rss/entertainment.xml");
		rssList.add("http://feeds.skynews.com/feeds/rss/strange.xml");
		/*rssList.add("http://rss.cnn.com/rss/edition.rss");
		rssList.add("http://rss.cnn.com/rss/edition_world.rss");
		rssList.add("http://rss.cnn.com/rss/edition_africa.rss");
		rssList.add("http://rss.cnn.com/rss/edition_americas.rss");
		rssList.add("http://rss.cnn.com/rss/edition_asia.rss");
		rssList.add("http://rss.cnn.com/rss/edition_europe.rss");
		rssList.add("http://rss.cnn.com/rss/edition_meast.rss");
		rssList.add("http://rss.cnn.com/rss/edition_us.rss");
		rssList.add("http://rss.cnn.com/rss/money_news_international.rss");
		rssList.add("http://rss.cnn.com/rss/edition_technology.rss");
		rssList.add("http://rss.cnn.com/rss/edition_space.rss");
		rssList.add("http://rss.cnn.com/rss/edition_entertainment.rss");
		rssList.add("http://rss.cnn.com/rss/edition_sport.rss");
		rssList.add("http://rss.cnn.com/rss/edition_football.rss");
		rssList.add("http://rss.cnn.com/rss/edition_golf.rss");
		rssList.add("http://rss.cnn.com/rss/edition_motorsport.rss");
		rssList.add("http://rss.cnn.com/rss/edition_tennis.rss");
		rssList.add("http://rss.cnn.com/rss/edition_travel.rss");
		rssList.add("http://rss.cnn.com/rss/cnn_latest.rss");*/
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/World.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Africa.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Americas.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/AsiaPacific.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Europe.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/MiddleEast.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/US.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Education.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Politics.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Business.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Sports.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Science.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Environment.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Space.xml");
		rssList.add("http://rss.nytimes.com/services/xml/rss/nyt/Health.xml");
		rssList.add("http://www.independent.co.uk/news/uk/rss");
		rssList.add("http://www.independent.co.uk/news/world/rss");
		rssList.add("http://www.independent.co.uk/news/business/rss");
		rssList.add("http://www.independent.co.uk/news/people/rss");
		rssList.add("http://www.independent.co.uk/news/science/rss");
		rssList.add("http://www.independent.co.uk/news/media/rss");
		rssList.add("http://www.independent.co.uk/news/education/rss");
		rssList.add("http://www.dailymail.co.uk/articles.rss");
		rssList.add("http://www.dailymail.co.uk/home/index.rss");
		rssList.add("http://www.dailymail.co.uk/news/index.rss");
		rssList.add("http://www.dailymail.co.uk/ushome/index.rss");
		rssList.add("http://www.dailymail.co.uk/auhome/index.rss");
		rssList.add("http://www.dailymail.co.uk/sport/index.rss");
		rssList.add("http://www.dailymail.co.uk/tvshowbiz/index.rss");
		rssList.add("http://www.dailymail.co.uk/femail/index.rss");
		rssList.add("http://www.dailymail.co.uk/health/index.rss");
		rssList.add("http://www.dailymail.co.uk/sciencetech/index.rss");
		rssList.add("http://www.dailymail.co.uk/money/index.rss");
		rssList.add("http://www.dailymail.co.uk/travel/index.rss");
		rssList.add("http://feeds.foxnews.com/foxnews/latest?format=xml");
		rssList.add("http://feeds.foxnews.com/foxnews/entertainment?format=xml");
		rssList.add("http://feeds.foxnews.com/foxnews/health?format=xml");
		rssList.add("http://feeds.foxnews.com/foxnews/politics?format=xml");
		rssList.add("http://feeds.foxnews.com/foxnews/science?format=xml");
		rssList.add("http://feeds.foxnews.com/foxnews/tech?format=xml");
		rssList.add("https://www.theguardian.com/uk/rss");
		rssList.add("https://www.theguardian.com/world/rss");
		rssList.add("https://www.theguardian.com/politics/rss");
		rssList.add("https://www.theguardian.com/uk/sport/rss");
		rssList.add("https://www.theguardian.com/football/rss");
		rssList.add("https://www.theguardian.com/uk/culture/rss");
		rssList.add("https://www.theguardian.com/uk/business/rss");
		rssList.add("https://www.theguardian.com/uk/environment/rss");
		rssList.add("https://www.theguardian.com/uk/technology/rss");
		rssList.add("https://www.theguardian.com/uk/travel/rss");
		rssList.add("http://www.washingtonpost.com/wp-dyn/rss/linkset/2005/03/24/LI2005032400102.xml");
		rssList.add("http://www.washingtonpost.com/wp-dyn/rss/print/index.xml");
		rssList.add("http://www.mtv.com/rss/news/news_full.jhtml");
		rssList.add("http://www.mtv.com/news/movies/feed/");
		rssList.add("https://www.buzzfeed.com/index.xml");
		//rssList.add("http://feeds.feedburner.com/variety/news/frontpage");
		rssList.add("http://feeds.ign.com/ign/news?format=xml");
		rssList.add("http://www.private-eye.co.uk/rss/rss.php");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-politics/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-entertainment/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-style/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-universities-education/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-lifestyle/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-comedy/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/tag/celebrity/feed/");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-tech/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-sport/news.xml");
		rssList.add("http://www.huffingtonpost.co.uk/feeds/verticals/uk-parents/news.xml");

		//only returns all the feeds just now, will write a way to specify later
		return rssList;	
	}
}
