package com.cesena.milanoBlu.Video;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cesenaTeam.milanoBlu.R;

public class VideoListAdapter extends BaseAdapter {
	private static ArrayList<Video> searchArrayList;

	private LayoutInflater mInflater;

	public VideoListAdapter(Context context, ArrayList<Video> results) {
		searchArrayList = results;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return searchArrayList.size();
	}

	public Object getItem(int position) {
		return searchArrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	// La funzione viene chiamata per creare gli elementi nella lista, anche
	// quando questa viene scrollata
	// Per questa ragione devo prevedere il download delle immagini solo la
	// prima volta che viene creato l'elemento n
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.youtube_row, null);
			holder = new ViewHolder();

			holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
			holder.intImage = (ImageView) convertView.findViewById(R.id.thumb);
			holder.txtDate = (TextView) convertView.findViewById(R.id.date);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// Setto il titolo dell'item
		holder.txtTitle.setText(searchArrayList.get(position).getTitle());
		// Controllo in che stato è il download dell'immagine:
		// 0 = Download non ancora iniziato
		// 1 = Download in esecuzione
		// 2 = Download completato
		if (searchArrayList.get(position).imageDownloadStatus == 0) {
			searchArrayList.get(position).download(
					searchArrayList.get(position).getImageURL(),
					holder.intImage);
		} else if (searchArrayList.get(position).imageDownloadStatus == 2) {
			holder.intImage
					.setImageBitmap(searchArrayList.get(position).imagebit);
		}
		holder.txtDate.setText(searchArrayList.get(position).getDateString());

		return convertView;
	}

	static class ViewHolder {
		TextView txtTitle;
		ImageView intImage;
		TextView txtDate;
	}
}
