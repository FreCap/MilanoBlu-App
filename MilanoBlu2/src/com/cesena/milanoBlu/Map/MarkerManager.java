package com.cesena.milanoBlu.Map;

import android.util.Log;

import com.cesenaTeam.milanoBlu.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkerManager {
	GoogleMap map;

	public MarkerManager(	GoogleMap map) {
		this.map = map;
		addRandomMarkers();
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
		Log.e("Msg", lat + " " + lng);

		MarkerOptions markerOptions = new MarkerOptions();

		markerOptions.position(new LatLng(lat, lng));
		markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
		markerOptions.icon(BitmapDescriptorFactory
				.fromResource(R.drawable.goccia));
		map.addMarker(markerOptions);
	}
}
