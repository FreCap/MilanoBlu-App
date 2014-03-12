package com.cesena.milanoBlu.Map;

import java.util.ArrayList;

import android.content.ClipData.Item;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SlidingDrawer;

import com.cesenaTeam.milanoBlu.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkerManager implements OnMarkerClickListener {
	GoogleMap map;
	View viewMappa;

	public final static int QUALITA_BASSA = 3;
	public final static int QUALITA_MEDIA = 2;
	public final static int QUALITA_ALTA = 1;

	public MarkerManager(View viewMappa, GoogleMap map) {
		this.map = map;
		this.viewMappa = viewMappa;

		addRandomMarkers();
		map.setOnMarkerClickListener(this);

		AdapterRating adapter = new AdapterRating(this.viewMappa.getContext(),
				generateData());
		ListView listView = (ListView) viewMappa.findViewById(R.id.listview);
		listView.setAdapter(adapter);

	}

	private ArrayList<RowRating> generateData() {
		ArrayList<RowRating> items = new ArrayList<RowRating>();
		items.add(new RowRating("Pinco Pallino", (float) 3));
		items.add(new RowRating("Domenico Bochicchio", (float) 3));
		items.add(new RowRating("Francesco Capponi", (float) 3));

		return items;
	}

	public boolean onMarkerClick(Marker marker) {

		Log.w("Click", "test");
		SlidingDrawer slidingDrawer = (SlidingDrawer) viewMappa
				.findViewById(R.id.slidingDrawer);

		slidingDrawer.setVisibility(View.GONE);

		return true;
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

	private void addMarker(double lat, double lng) {
		addMarker(lat, lng, 3);
	}

	private void addMarker(double lat, double lng, Integer quality) {
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
		map.addMarker(markerOptions);
	}
}
