package com.cesena.milanoBlu.News;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewsManager {

	final static int MODE_MOCK = 2;
	final static int MODE_RELEASE = 1;

	public String getMockJSON() {
		return "[{\"news_id\":0,\"imageURL\":\"http://www.milanoblu.com/wp-content/themes/milanoblu/images/top-notizie-ed-eventi.png\",\"title\":\"cillum laborum est culpa sunt proident\",\"textPreview\":\"Eu sint eu in velit ad esse commodo non pariatur. Enim irure sunt voluptate eiusmod incididunt tempor dolor culpa consectetur irure. Aliqua esse amet consectetur qui occaecat. Voluptate ea non minim elit dolor ullamco eiusmod et.\r\n\",\"timestamp\":1370898142,\"link\":\"http://www.milanoblu.com/2014/03/10/crea-lapp-dellacqua-di-milano/\"},{\"news_id\":1,\"imageURL\":\"http://www.milanoblu.com/wp-content/themes/milanoblu/images/top-notizie-ed-eventi.png\",\"title\":\"magna amet laboris Lorem tempor id\",\"textPreview\":\"Adipisicing enim non nostrud duis. Cupidatat ex occaecat officia ut duis occaecat anim laborum consequat laboris tempor. Esse dolor reprehenderit veniam eu id pariatur fugiat reprehenderit aliqua. Eu sunt adipisicing velit aliqua veniam ad fugiat.\r\n\",\"timestamp\":1370377311,\"link\":\"http://www.milanoblu.com/2014/03/10/crea-lapp-dellacqua-di-milano/\"},{\"news_id\":2,\"imageURL\":\"http://www.milanoblu.com/wp-content/themes/milanoblu/images/top-notizie-ed-eventi.png\",\"title\":\"enim exercitation labore ullamco dolor ad\",\"textPreview\":\"Adipisicing eiusmod deserunt ullamco dolore proident ad quis ad laboris reprehenderit labore dolore. Aliqua laboris officia cupidatat sint deserunt proident ex ea consequat eu. Nisi ut ad fugiat sit in ut culpa consequat ipsum nostrud fugiat laboris nisi sit. Nostrud occaecat amet pariatur pariatur in qui. Nostrud et sit voluptate anim ipsum deserunt non ex ipsum. Deserunt quis sit elit in eiusmod duis cupidatat commodo. Consectetur nisi velit enim laborum ex quis dolore consequat fugiat est reprehenderit nostrud.\r\n\",\"timestamp\":1365288612,\"link\":\"http://www.milanoblu.com/2014/03/10/crea-lapp-dellacqua-di-milano/\"},{\"news_id\":3,\"imageURL\":\"http://www.milanoblu.com/wp-content/themes/milanoblu/images/top-notizie-ed-eventi.png\",\"title\":\"veniam duis cupidatat deserunt enim nisi\",\"textPreview\":\"Aliquip duis in id enim pariatur reprehenderit ipsum in. Cillum nulla non ad deserunt voluptate reprehenderit in labore et ex labore. Consequat et irure laborum exercitation officia commodo exercitation dolore ut ad ad. Aliqua reprehenderit cupidatat cupidatat proident consectetur ea occaecat sunt minim esse eu amet. Tempor laboris et labore ullamco exercitation tempor cillum cupidatat culpa. Aute ut laborum sit dolor exercitation non reprehenderit esse consequat eu fugiat.\r\n\",\"timestamp\":1384236924,\"link\":\"http://www.milanoblu.com/2014/03/10/crea-lapp-dellacqua-di-milano/\"},{\"news_id\":4,\"imageURL\":\"http://www.milanoblu.com/wp-content/themes/milanoblu/images/top-notizie-ed-eventi.png\",\"title\":\"mollit duis tempor ea incididunt aliquip\",\"textPreview\":\"Nostrud incididunt dolor et esse voluptate enim. Exercitation id voluptate id mollit enim irure. Tempor ex minim proident id id dolore nulla Lorem reprehenderit magna aliquip. Excepteur voluptate nisi qui nulla voluptate irure in officia ad sint ea. Veniam incididunt mollit voluptate nostrud nostrud exercitation veniam labore in est id ea mollit. Consequat dolore est in voluptate ad qui dolor laborum. Fugiat minim do minim fugiat eu quis ullamco cillum dolor duis.\r\n\",\"timestamp\":1364776379,\"link\":\"http://www.milanoblu.com/2014/03/10/crea-lapp-dellacqua-di-milano/\"},{\"news_id\":5,\"imageURL\":\"http://www.milanoblu.com/wp-content/themes/milanoblu/images/top-notizie-ed-eventi.png\",\"title\":\"incididunt dolor anim in fugiat incididunt\",\"textPreview\":\"Ea id dolor cupidatat eiusmod culpa consectetur aute et ea nostrud duis ut. Anim veniam laborum et ullamco reprehenderit non Lorem proident culpa culpa consequat nostrud. Ullamco Lorem aliqua aliqua ad. Commodo reprehenderit anim culpa in est amet nostrud id adipisicing et commodo nostrud.\r\n\",\"timestamp\":1386653308,\"link\":\"http://www.milanoblu.com/2014/03/10/crea-lapp-dellacqua-di-milano/\"}]";
	}

	public ArrayList<News> getNews() {
		int mode = MODE_MOCK;
		String jsonData = null;
		if (mode == MODE_MOCK) {
			jsonData = getMockJSON();
		} else {
			// TODO creare il servizio
		}

		ArrayList<News> newsArray = new ArrayList<News>();
		News news;

		JSONArray array;
		try {
			array = new JSONArray(jsonData);
			for (int i = 0; i < array.length(); i++) {
				JSONObject row = array.getJSONObject(i);
				news = new News(row);
				newsArray.add(news);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newsArray;
	}

}
