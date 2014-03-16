package com.cesena.milanoBlu.Map.Cluster;

import java.util.ArrayList;

import android.view.View;

import com.cesena.milanoBlu.Fontanelle.Fontanella;
import com.cesena.milanoBlu.Fontanelle.FontanelleManager;
import com.cesena.milanoBlu.Map.MarkerDetailsManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;


public class ClusterMarkerManager implements
		ClusterManager.OnClusterClickListener<Fontanella>{
	private ClusterManager<Fontanella> mClusterManager;

	@Override
	public boolean onClusterClick(Cluster<Fontanella> cluster) {
		// aggiungi camera zoom quando clicki
		return true;
	}


	private MarkerDetailsManager markerDetailsManager;
	public ClusterMarkerManager(View view, GoogleMap map) {
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.503186,
				-0.126446), 9.5f));

		mClusterManager = new ClusterManager<Fontanella>(view.getContext(), map);
		mClusterManager.setRenderer(new FontanellaRenderer(view, map,
				mClusterManager));
		map.setOnCameraChangeListener(mClusterManager);
		map.setOnMarkerClickListener(mClusterManager);
		map.setOnInfoWindowClickListener(mClusterManager);
		mClusterManager.setOnClusterClickListener(this);
		markerDetailsManager = new MarkerDetailsManager(view, map,mClusterManager);

		addItems();
		mClusterManager.cluster();
	}

	public void addItems() {

		FontanelleManager fontanelleManager = new FontanelleManager();
		ArrayList<Fontanella> fontanelle = fontanelleManager.getFontane();
		for (Fontanella fontanella : fontanelle) {
			mClusterManager.addItem((Fontanella) fontanella);
		}
	}


}
