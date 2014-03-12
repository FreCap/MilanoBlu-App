package com.cesena.milanoBlu.Map;


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cesenaTeam.milanoBlu.R;

public class AdapterRating extends ArrayAdapter<RowRating> {

		private final Context context;
		private final ArrayList<RowRating> itemsArrayList;

		public AdapterRating(Context context, ArrayList<RowRating> itemsArrayList) {

			super(context, R.layout.rating_row, itemsArrayList);

			this.context = context;
			this.itemsArrayList = itemsArrayList;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View rowView = inflater.inflate(R.layout.rating_row, parent, false);

			RatingBar labelView = (RatingBar) rowView.findViewById(R.id.ratingBar);
		    TextView valueView = (TextView) rowView.findViewById(R.id.nome);

		    labelView.setRating(itemsArrayList.get(position).getRating());
		    valueView.setText(itemsArrayList.get(position).getNome());

		    return rowView;
		}
}