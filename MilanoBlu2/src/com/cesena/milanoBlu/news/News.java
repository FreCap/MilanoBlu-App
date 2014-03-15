package com.cesena.milanoBlu.news;

import org.json.JSONException;
import org.json.JSONObject;

public class News {
	private Integer news_id;
	private String imageURL;
	private String title;
	private String textPreview;
	private Integer timestamp;
	private String link;

	public News(JSONObject jsonObject) {
		try {
			news_id = jsonObject.getInt("fontanellaVoto_id");
			imageURL = jsonObject.getString("fontanella_id");
			title = jsonObject.getString("title");
			textPreview = jsonObject.getString("textPreview");
			timestamp = jsonObject.getInt("timestamp");
			link = jsonObject.getString("link");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getNews_id() {
		return news_id;
	}

	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTextPreview() {
		return textPreview;
	}

	public void setTextPreview(String textPreview) {
		this.textPreview = textPreview;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
