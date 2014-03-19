package com.cesena.milanoBlu.Contatti;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cesenaTeam.milanoBlu.R;

public class ContattiAdapter extends BaseAdapter {
	private static ArrayList<Contatto> newsArrayList;

	private LayoutInflater mInflater;

	public ContattiAdapter(Context context, ArrayList<Contatto> results) {
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
			convertView = mInflater.inflate(R.layout.contatti_row, null);
			holder = new ViewHolder();
			holder.contattoTitle = (TextView) convertView
					.findViewById(R.id.contattoTitle);
			holder.contattoDescription = (TextView) convertView
					.findViewById(R.id.contattoDescription);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.contattoTitle.setText(newsArrayList.get(position).getTitolo());
		holder.contattoDescription.setText(newsArrayList.get(position)
				.getDescrizione());

		return convertView;
	}

	static class ViewHolder {
		TextView contattoTitle;
		TextView contattoDescription;
	}
}
