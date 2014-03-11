package com.cesena.milanoBlu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cesenaTeam.milanoBlu.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {

	private final static LatLng COORD_MILANO = new LatLng(45.535901f - 0.06f,
			9.082642f + 0.08f);

	// Non si sa perché ma le lat bounds gli fanno schifo e da errore
	// LatLngBounds MILANO = new LatLngBounds(
	// new LatLng(45.535901f, 9.082642f), new LatLng(45.412879f, 9.266320f));

	MapView mapView;
	GoogleMap map;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.map_fragment, container, false);

		// Gets the MapView from the XML layout and creates it
		mapView = (MapView) v.findViewById(R.id.mapview);
		mapView.onCreate(savedInstanceState);

		// Gets to GoogleMap from the MapView and does initialization stuff
		map = mapView.getMap();
		map.getUiSettings().setMyLocationButtonEnabled(false);
		map.setMyLocationEnabled(true);

		MapsInitializer.initialize(this.getActivity());

		addRandomMarkers();
		centerCity(COORD_MILANO);

		return v;
	}

	@Override
	public void onResume() {
		mapView.onResume();
		super.onResume();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mapView.onLowMemory();
	}

	private void centerCity(LatLng coordinate) {
		// quanto zoomare sulla città
		int zoom = 11;
		map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, zoom));
	}

	private void addMarker(double lat, double lng) {
		Log.e("Msg", lat + " " + lng);

		MarkerOptions markerOptions = new MarkerOptions();

		markerOptions.position(new LatLng(lat, lng));
		markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
		markerOptions.icon(BitmapDescriptorFactory
				.fromResource(R.drawable.goccia));
		map.addMarker(markerOptions);
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
