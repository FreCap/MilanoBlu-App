package com.cesena.milanoBlu.Video;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

public class Video {
	// Variabili private a cui è possibile accedere in lettura e scrittura
	// tramite le appropriate funzioni get e set
	// listObject è il puntatore a ListView che viene utilizzato per poter
	// effettuare il refresh della listView una volta terminato il download
	// dlel'immagine
	private Integer video_id;
	private String title;
	private Integer timestamp;
	private String link;
	private String imageURL;

	public static ListView listObject;
	// La variabile viene settata dalla funzione di download asincrono e si può
	// accedere ad essa direttamente
	public Bitmap imagebit;

	/**
	 * Stato del download asincrono dell'immagine 0 = Non scaricata 1 = In
	 * download 2 = Scaricata
	 */
	public int imageDownloadStatus = 0;

	public Video(JSONObject jsonObject) {
		try {
			setVideo_id(jsonObject.getInt("video_id"));
			setImageURL(jsonObject.getString("imageURL"));
			setTitle(jsonObject.getString("title"));
			setTimestamp(jsonObject.getInt("timestamp"));
			setLink(jsonObject.getString("link"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Funzione che si occupa del download dell'imagine tramite l'url passato
	// come parametro
	static Bitmap downloadBitmap(String url) {
		final AndroidHttpClient client = AndroidHttpClient
				.newInstance("Android");
		final HttpGet getRequest = new HttpGet(url);

		try {
			HttpResponse response = client.execute(getRequest);
			final int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				Log.w("ImageDownloader", "Error " + statusCode
						+ " while retrieving bitmap from " + url);
				return null;
			}

			final HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream inputStream = null;
				try {
					inputStream = entity.getContent();
					final Bitmap bitmap = BitmapFactory
							.decodeStream(inputStream);
					return bitmap;
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
					entity.consumeContent();
				}
			}
		} catch (Exception e) {
			getRequest.abort();
			Log.w("ImageDownloader",
					"Errore durante il download dell'immagine dall'url " + url
							+ e.toString());
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return null;
	}

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
			return downloadBitmap(params[0]);
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
	
	public String getDateString() {
		Date date = new Date(timestamp);
		// S is the millisecond
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"MM/dd/yyyy' 'HH:MM:ss:S");
		
		return simpleDateFormat.getDateInstance().format(date);

	}

	public Integer getVideo_id() {
		return video_id;
	}

	public void setVideo_id(Integer video_id) {
		this.video_id = video_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}
