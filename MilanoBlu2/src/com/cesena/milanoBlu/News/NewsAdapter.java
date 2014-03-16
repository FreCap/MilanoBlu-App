package com.cesena.milanoBlu.News;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cesenaTeam.milanoBlu.R;

public class NewsAdapter extends BaseAdapter {
	private static ArrayList<News> newsArrayList;

	private LayoutInflater mInflater;

	public NewsAdapter(Context context, ArrayList<News> results) {
		newsArrayList = results;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return newsArrayList.size();
	}

	public Object getItem(int position) {
		return newsArrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.news_row, null);
			holder = new ViewHolder();
			holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
			holder.intImage = (ImageView) convertView.findViewById(R.id.image);
			holder.txtDescription = (TextView) convertView
					.findViewById(R.id.description);
			holder.txtDate = (TextView) convertView.findViewById(R.id.date);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txtTitle.setText(newsArrayList.get(position).getTitle());
		holder.intImage.setImageResource(R.drawable.newark_nj_1922); // todo
		holder.txtDescription.setText(newsArrayList.get(position)
				.getTextPreview());
		holder.txtDate.setText(newsArrayList.get(position).getDateString());

		return convertView;
	}

	static class ViewHolder {
		TextView txtTitle;
		ImageView intImage;
		TextView txtDescription;
		TextView txtDate;
	}
}
