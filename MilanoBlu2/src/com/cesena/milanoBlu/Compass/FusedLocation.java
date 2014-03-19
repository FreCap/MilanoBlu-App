package com.cesena.milanoBlu.Compass;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public class FusedLocation implements
		GooglePlayServicesClient.ConnectionCallbacks,
		GooglePlayServicesClient.OnConnectionFailedListener {

	private String TAG = this.getClass().getSimpleName();

	private LocationClient locationclient;
	private LocationRequest locationrequest;
	private LocationListener locationListener;

	public FusedLocation(View view, LocationListener locationListener) {
		this.locationListener = locationListener;
		int resp = GooglePlayServicesUtil.isGooglePlayServicesAvailable(view
				.getContext());
		if (resp == ConnectionResult.SUCCESS) {
			locationclient = new LocationClient(view.getContext(), this, this);
			locationclient.connect();
		} else {
			Toast.makeText(view.getContext(),
					"Google Play Service Error " + resp, Toast.LENGTH_LONG)
					.show();

		}

	}

	public Location getLastLocation() {
		Location loc = null;
		if (locationclient != null && locationclient.isConnected()) {
			loc = locationclient.getLastLocation();
			Log.i(TAG,
					"Last Known Location :" + loc.getLatitude() + ","
							+ loc.getLongitude());
		}
		return loc;
	}

	public void requestLocation(Long interval) {
		locationrequest = LocationRequest.create();
		locationrequest.setInterval(interval);
		locationclient
				.requestLocationUpdates(locationrequest, locationListener);
	}

	public void requestLocationStop() {
		locationclient.removeLocationUpdates(locationListener);
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		Log.i(TAG, "onConnected");
		requestLocation((long) 5000);

	}

	@Override
	public void onDisconnected() {
		Log.i(TAG, "onDisconnected");

	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		Log.i(TAG, "onConnectionFailed");

	}

}
