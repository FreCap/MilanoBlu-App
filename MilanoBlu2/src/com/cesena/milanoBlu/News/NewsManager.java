package com.cesena.milanoBlu.News;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cesena.milanoBlu.Main;
import com.cesenaTeam.milanoBlu.R;

public class NewsManager {

	final static int MODE_MOCK = 2;
	final static int MODE_RELEASE = 1;

	public String getMockJSON() {
		
		InputStream is = Main.context.getResources().openRawResource(R.raw.mock_news);
		Writer writer = new StringWriter();
		char[] buffer = new char[1024];
		try {
		    Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		    int n;
		    while ((n = reader.read(buffer)) != -1) {
		        writer.write(buffer, 0, n);
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String jsonString = writer.toString();
		return jsonString;
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
