package com.cesena.milanoBlu;

import android.os.Bundle;
import android.util.Log;

import com.cesenaTeam.milanoBlu.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends SupportMapFragment {

	GoogleMap mapView;

	private final static LatLng COORD_MILANO = new LatLng(45.535901f - 0.06f,
			9.082642f + 0.08f);

	// Non si sa perché ma le lat bounds gli fanno schifo e da errore
	// LatLngBounds MILANO = new LatLngBounds(
	// new LatLng(45.535901f, 9.082642f), new LatLng(45.412879f, 9.266320f));

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// inizializzo la mappa
		mapView = getMap();
//		addRandomMarkers();
//		centerCity(COORD_MILANO);
	}

	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		addRandomMarkers();
		centerCity(COORD_MILANO);

	}
//
//	@Override
//	public void onStart() {
//super.onStart();
//		addRandomMarkers();
//		centerCity(COORD_MILANO);
//	}
//
	@Override
	public void onResume() {
		super.onResume();
		// personalizzazioni
//		addRandomMarkers();
//		centerCity(COORD_MILANO);

	}

	//
	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	// View view = inflater.inflate(R.layout.mapfragments, container, false);
	// return view;
	// }

	private void centerCity(LatLng coordinate) {
		// quanto zoomare sulla città
		int zoom = 11;
		mapView.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate,
				zoom));
	}

	private void addMarker(double lat, double lng) {
		Log.e("Msg", lat + " " + lng);

		MarkerOptions markerOptions = new MarkerOptions();

		markerOptions.position(new LatLng(lat, lng));
		 markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
		 markerOptions.icon(BitmapDescriptorFactory
		 .fromResource(R.drawable.goccia));
		mapView.addMarker(markerOptions);
	}

	private void addRandomMarkers() {
		// Milano
		// NW 45.535901, 9.082642
		// SE 45.412879, 9.266320

		// LNG diff : 0.123022
		// LAT diff : 0.183678
		for (int i = 0; i < 30; i++)
			addMarker(45.535901f - Math.random() * (0.123022f),
					9.082642f + Math.random() * (0.123022f));
	}

}
