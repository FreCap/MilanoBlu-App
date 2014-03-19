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
		GooglePlayServicesClient.OnConnectionFailedListener, LocationListener {

	private String TAG = this.getClass().getSimpleName();

	private LocationClient locationclient;
	private LocationRequest locationrequest;

	public FusedLocation(View view) {
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
		locationclient.requestLocationUpdates(locationrequest, this);
	}

	public void requestLocationStop() {
		locationclient.removeLocationUpdates(this);
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		Log.i(TAG, "onConnected");

	}

	@Override
	public void onDisconnected() {
		Log.i(TAG, "onDisconnected");

	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		Log.i(TAG, "onConnectionFailed");

	}

	@Override
	public void onLocationChanged(Location location) {
		if (location != null) {
			Log.i(TAG, "Location Request :" + location.getLatitude() + ","
					+ location.getLongitude());
		}

	}

}
