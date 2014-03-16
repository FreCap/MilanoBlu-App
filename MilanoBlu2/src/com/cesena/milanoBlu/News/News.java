package com.cesena.milanoBlu.News;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class News {
	private Integer news_id;
	private String imageURL;
	private String title;
	private String textPreview;
	private Long timestamp;
	private String link;

	public News(JSONObject jsonObject) {
		try {
			news_id = jsonObject.getInt("news_id");
			imageURL = jsonObject.getString("imageURL");
			title = jsonObject.getString("title");
			textPreview = jsonObject.getString("textPreview");
			timestamp = jsonObject.getLong("timestamp");
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

	public Long getTimestamp() {
		return timestamp;
	}

	public String getDateString() {
		Date date = new Date(timestamp);
		// S is the millisecond
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"MM/dd/yyyy' 'HH:MM:ss:S");
		
		return simpleDateFormat.getDateInstance().format(date);

	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
