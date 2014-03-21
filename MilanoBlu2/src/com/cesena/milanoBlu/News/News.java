package com.cesena.milanoBlu.News;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ListView;

import com.cesena.milanoBlu.Image.ImageDownloader;

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

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDateString() {
		Date date = new Date(getTimestamp() * 1000);
		// S is the millisecond
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return simpleDateFormat.getDateInstance().format(date);

	}

	public static ListView listObject;
	// La variabile viene settata dalla funzione di download asincrono e si può
	// accedere ad essa direttamente
	public Bitmap imagebit;

	/**
	 * Stato del download asincrono dell'immagine 0 = Non scaricata 1 = In
	 * download 2 = Scaricata
	 */
	public int imageDownloadStatus = 0;

	// Funzione richiamata dal MyCustomBaseAdapter per iniziare il download
	// asincrono dell'immagine
	public void download(String url, ImageView imageView) {
		imageDownloadStatus = 1;
		BitmapDownloaderTask task = new BitmapDownloaderTask(imageView);
		task.execute(url);
	}

	// Classe utilizzata per per il download asincrono dell'immagine... questa
	// richiama la funzione di download e setta l'imageView con l'immagine
	// appena scaricata
	class BitmapDownloaderTask extends AsyncTask<String, Void, Bitmap> {
		private final WeakReference<ImageView> imageViewReference;

		public BitmapDownloaderTask(ImageView imageView) {
			imageViewReference = new WeakReference<ImageView>(imageView);
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			return ImageDownloader.downloadBitmap(params[0]);
		}

		@Override
		protected void onPostExecute(Bitmap bitmap) {
			// Questo metodo viene richiamato una volta che il processo
			// asincrono è terminato
			// da qui è possibile modificare il Thread UI (a differenza del
			// metodo doInBackground
			if (isCancelled()) {
				bitmap = null;
			}

			if (imageViewReference != null) {
				ImageView imageView = imageViewReference.get();
				if (imageView != null) {
					// Setta lo stato dell'immagine a 2 (download completato)
					// salva l'immagine nella variabile di tipo bitmap
					// Refresha la listview per applicare le modifiche
					// ci pensa il metodo getView dell'adapter a prelevare
					// l'immagine dalla variabile
					// bitmap appena scaricata grazie al refresh forzato.
					imageDownloadStatus = 2;
					imagebit = bitmap;
					listObject.invalidateViews();
				}
			}
		}
	}

}
