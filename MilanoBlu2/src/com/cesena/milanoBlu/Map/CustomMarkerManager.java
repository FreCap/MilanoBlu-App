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
import com.cesena.milanoBlu.Map.Cluster.ClusterMarkerManager;
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
import com.google.maps.android.clustering.ClusterManager;

public class CustomMarkerManager {
	GoogleMap map;
	View viewMappa;

	private FontanelleManager fontanelleManager;
	private ClusterMarkerManager mClusterManager;

	public final static int QUALITA_BASSA = 3;
	public final static int QUALITA_MEDIA = 2;
	public final static int QUALITA_ALTA = 1;

	public CustomMarkerManager(View viewMappa, GoogleMap map) {
		this.map = map;
		this.viewMappa = viewMappa;

		mClusterManager = new ClusterMarkerManager(this.viewMappa, this.map);

		// addMarkers();

		// map.setOnMarkerClickListener(this);
		// map.setOnMapClickListener(this);
	}



}
