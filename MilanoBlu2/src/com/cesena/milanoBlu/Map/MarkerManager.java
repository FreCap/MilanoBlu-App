package com.cesena.milanoBlu.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerScrollListener;
import android.widget.TextView;

import com.cesena.milanoBlu.Fontanelle.Fontanella;
import com.cesena.milanoBlu.Fontanelle.FontanellaVoto;
import com.cesena.milanoBlu.Fontanelle.FontanelleManager;
import com.cesena.milanoBlu.Fontanelle.FontanelleVotiManager;
import com.cesena.milanoBlu.Map.MarkerDetail.AdapterRating;
import com.cesena.milanoBlu.Map.MarkerDetail.RowRating;
import com.cesenaTeam.milanoBlu.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkerManager implements OnMarkerClickListener, OnMapClickListener {
	GoogleMap map;
	View viewMappa;

	private FontanelleManager fontanelleManager;
	private Map<Marker, Fontanella> markerToModelMappingMap;

	public final static int QUALITA_BASSA = 3;
	public final static int QUALITA_MEDIA = 2;
	public final static int QUALITA_ALTA = 1;

	public MarkerManager(View viewMappa, GoogleMap map) {
		this.map = map;
		this.viewMappa = viewMappa;
		markerToModelMappingMap = new HashMap<Marker, Fontanella>();

		addMarkers();

		map.setOnMarkerClickListener(this);
		map.setOnMapClickListener(this);

		initializeMarkerDetailsDrawer();
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

	public boolean onMarkerClick(Marker marker) {
		Log.e("MarkerManager", "Click sul Marker");

		Fontanella fontanella = markerToModelMappingMap.get(marker);

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

	public void addMarkers() {
		// pulisco visto che adesso andrò ad inserire nuove informazioni
		markerToModelMappingMap.clear();

		fontanelleManager = new FontanelleManager();
		ArrayList<Fontanella> fontanelle = fontanelleManager.getFontane();

		for (Fontanella fontanella : fontanelle) {
			addMarker(fontanella);
		}
	}

	public void addRandomMarkers() {
		// Milano
		// NW 45.535901, 9.082642
		// SE 45.412879, 9.266320

		// LNG diff : 0.123022
		// LAT diff : 0.183678
		for (int i = 0; i < 30; i++)
			addMarker(45.535901f - Math.random() * (0.123022f),
					9.082642f + Math.random() * (0.123022f));
	}

	private Marker addMarker(double lat, double lng) {
		return addMarker(lat, lng, 3);
	}

	private Marker addMarker(Fontanella fontanella) {
		Integer qualita = null;
		if (fontanella.getQualita() > 3.5)
			qualita = QUALITA_ALTA;
		else if (fontanella.getQualita() > 2.5)
			qualita = QUALITA_MEDIA;
		else
			qualita = QUALITA_BASSA;

		Marker marker = addMarker(fontanella.getCoordinate().latitude,
				fontanella.getCoordinate().longitude, qualita);

		marker.setTitle(fontanella.getNome());
		marker.setSnippet(fontanella.getNomeStrada());

		// aggiungo per poi fare il retrieve delle informations dopo
		markerToModelMappingMap.put(marker, fontanella);
		return marker;
	}

	private Marker addMarker(double lat, double lng, Integer quality) {
		Log.e("Msg", lat + " " + lng);

		MarkerOptions markerOptions = new MarkerOptions();

		markerOptions.position(new LatLng(lat, lng));
		markerOptions.icon(BitmapDescriptorFactory.defaultMarker());

		int resource = 0;
		switch (quality) {
		case QUALITA_ALTA:
			resource = R.drawable.goccia_blu;
			break;
		case QUALITA_MEDIA:
			resource = R.drawable.goccia_gialla;
			break;
		case QUALITA_BASSA:
			resource = R.drawable.goccia_verde;
			break;
		}

		markerOptions.icon(BitmapDescriptorFactory.fromResource(resource));
		return map.addMarker(markerOptions);

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
