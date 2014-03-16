package com.cesena.milanoBlu.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cesena.milanoBlu.Fontanelle.Fontanella;
import com.cesena.milanoBlu.Fontanelle.FontanellaVoto;
import com.cesena.milanoBlu.Fontanelle.FontanelleVotiManager;
import com.cesena.milanoBlu.Map.MarkerDetail.AdapterRating;
import com.cesena.milanoBlu.Map.MarkerDetail.RowRating;
import com.cesenaTeam.milanoBlu.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.ClusterManager;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.SlidingDrawer.OnDrawerScrollListener;

public class MarkerDetailsManager implements OnMapClickListener,
		ClusterManager.OnClusterItemClickListener<Fontanella> {

	GoogleMap map;
	View viewMappa;

	public MarkerDetailsManager(View viewMappa, GoogleMap map,
			ClusterManager<Fontanella> mClusterManager) {
		this.map = map;
		this.viewMappa = viewMappa;
		mClusterManager.setOnClusterItemClickListener(this);
		this.map.setOnMapClickListener(this);
	}

	private void refreshFontanellaDetailVoti(Fontanella fontanella) {

		ArrayList<RowRating> rowsRating = null;
		if (1 == 2) {// DEBUG
			rowsRating = getMockRowRating();
		} else {
			FontanelleVotiManager fontanelleVotiManager = new FontanelleVotiManager();
			ArrayList<FontanellaVoto> fontanellaVoti = fontanelleVotiManager
					.getVoti(fontanella);
			rowsRating = new ArrayList<RowRating>();

			for (FontanellaVoto fontanellaVoto : fontanellaVoti) {
				rowsRating.add(new RowRating(fontanellaVoto.getNomeVotante(),
						fontanellaVoto.getVoto()));
			}

		}

		AdapterRating adapter = new AdapterRating(this.viewMappa.getContext(),
				rowsRating);
		ListView listView = (ListView) viewMappa.findViewById(R.id.listview);
		listView.setAdapter(adapter);
	}

	private ArrayList<RowRating> getMockRowRating() {
		ArrayList<RowRating> items = new ArrayList<RowRating>();

		for (int i = 0; i < 10; i++) {
			items.add(new RowRating("Pinco Pallino", (float) 3));
			items.add(new RowRating("Domenico Bochicchio", (float) 3));
			items.add(new RowRating("Francesco Capponi", (float) 3));
		}

		return items;
	}

	@Override
	public void onMapClick(LatLng arg0) {
		Log.e("MarkerManager", "Click sulla mappa");

		SlidingDrawer slidingDrawer = getMarkerDetailsDrawer();
		if (slidingDrawer.isOpened())
			slidingDrawer.animateClose();

	}

	@Override
	public boolean onClusterItemClick(Fontanella fontanella) {
		Log.e("MarkerManager", "Click sul Marker");

		refreshFontanellaDetailVoti(fontanella);

		RatingBar ratingBar = getOverallVotesRatingBar();
		ratingBar.setRating(fontanella.getQualita());

		TextView textView = getOverallVotesTextView();
		textView.setText(fontanella.getQualita() + "/5 stelle");

		SlidingDrawer slidingDrawer = getMarkerDetailsDrawer();
		slidingDrawer.animateOpen();

		return true;
	}

	private SlidingDrawer getMarkerDetailsDrawer() {
		SlidingDrawer slidingDrawer = (SlidingDrawer) viewMappa
				.findViewById(R.id.slidingDrawer);
		return slidingDrawer;
	}

	private RatingBar getOverallVotesRatingBar() {
		RatingBar overallVotesRatingBar = (RatingBar) viewMappa
				.findViewById(R.id.overallVotesRatingBar);
		return overallVotesRatingBar;
	}

	private TextView getOverallVotesTextView() {
		TextView overallVotesTextView = (TextView) viewMappa
				.findViewById(R.id.overallVotesTextView);
		return overallVotesTextView;
	}

	private void initializeMarkerDetailsDrawer() {
		final SlidingDrawer mSlidingDrawer = getMarkerDetailsDrawer();
		mSlidingDrawer.setOnDrawerScrollListener(new OnDrawerScrollListener() {

			private Runnable mRunnable = new Runnable() {

				@Override
				public void run() {
					// finché si muove nn far nulla
					while (mSlidingDrawer.isMoving()) {
						Thread.yield();
					}

					// quando ha finito richiamo il mio handler
					mHandler.sendEmptyMessage(0);
				}
			};

			private Handler mHandler = new Handler() {
				public void handleMessage(Message msg) {
					if (mSlidingDrawer.isOpened()) {
						// Quando si è aperto completamente
					} else {
						// Quando si è chiuso completamente
						mSlidingDrawer.setVisibility(View.GONE);

					}
				}
			};

			@Override
			public void onScrollEnded() {
				new Thread(mRunnable).start();
			}

			@Override
			public void onScrollStarted() {
				// Inizio scroll
				mSlidingDrawer.setVisibility(View.VISIBLE);
			}
		});
	}

}
