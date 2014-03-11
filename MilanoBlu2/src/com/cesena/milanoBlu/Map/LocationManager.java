package com.cesena.milanoBlu.Map;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class LocationManager {
	GoogleMap map;


	private final static LatLng COORD_MILANO = new LatLng(45.535901f - 0.06f,
			9.082642f + 0.08f);

	// Non si sa perché ma le lat bounds gli fanno schifo e da errore
	// LatLngBounds MILANO = new LatLngBounds(
	// new LatLng(45.535901f, 9.082642f), new LatLng(45.412879f, 9.266320f));

	
	public LocationManager(	GoogleMap map) {
		this.map = map;
		

		// Gets to GoogleMap from the MapView and does initialization stuff
		map.getUiSettings().setMyLocationButtonEnabled(true);
		
		map.setMyLocationEnabled(true);
		
		centerCity(COORD_MILANO);
	}
	
	
	private void centerCity(LatLng coordinate) {
		// quanto zoomare sulla città
		int zoom = 11;
		map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, zoom));
	}

	
}
