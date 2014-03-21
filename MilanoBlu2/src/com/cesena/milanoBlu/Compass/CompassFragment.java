package com.cesena.milanoBlu.Compass;

import java.util.ArrayList;

import android.content.Context;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.cesena.milanoBlu.Fontanelle.Fontanella;
import com.cesena.milanoBlu.Fontanelle.FontanelleManager;
import com.cesenaTeam.milanoBlu.R;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.model.LatLng;

public class CompassFragment extends Fragment implements SensorEventListener,
		LocationListener {

	// define the display assembly compass picture
	private ImageView image;

	// record the compass picture angle turned
	private float currentDegree = 0f;

	// device sensor manager
	private SensorManager mSensorManager;

	private Location LocationObj;
	private static Location destinationObj;

	private Fontanella nearestFontanella;
	private View view;

	private FusedLocation fusedLocation;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.compass_fragment, container, false);

		image = (ImageView) v.findViewById(R.id.imageViewCompass);

		destinationObj = new Location("Fontanella");
		view = v;

		LocationObj = new Location("Milano");
		LocationObj.setLatitude(1);
		LocationObj.setLongitude(1);

		initCompass();
		initGPS();
		updateDestination();
		return v;
	}

	public void onLocationChanged(Location location) {
		if (location != null) {
			Log.i("sd", "Location Request :" + location.getLatitude() + ","
					+ location.getLongitude());
			LocationObj = location;
			updateDestination();
		}
	}

	private void initCompass() {
		// initialize your android device sensor capabilities
		mSensorManager = (SensorManager) view.getContext().getSystemService(
				view.getContext().SENSOR_SERVICE);

	}

	private void initGPS() {
		fusedLocation = new FusedLocation(view, this);
		// fusedLocation.requestLocation((long) 4);
		// LocationObj = fusedLocation.getLastLocation();
	}

	@Override
	public void onResume() {
		super.onResume();

		// for the system's orientation sensor registered listeners
		mSensorManager.registerListener(this,
				mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_GAME);
	}

	@Override
	public void onPause() {
		super.onPause();

		// to stop the listener and save battery
		mSensorManager.unregisterListener(this);
	}

	private void rotateArrow(float rotation) {
		// get the angle around the z-axis rotated
		float degree = Math.round(rotation);

//		Log.i("Compass", "Heading: " + Float.toString(degree) + " degrees");

		// create a rotation animation (reverse turn degree degrees)
		RotateAnimation ra = new RotateAnimation(currentDegree, -degree,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// how long the animation will take place
		ra.setDuration(210);

		// set the animation after the end of the reservation status
		ra.setFillAfter(true);

		// Start the animation
		image.startAnimation(ra);
		currentDegree = +degree;
	}

	public void onSensorChanged(SensorEvent event) {

		// If we don't have a Location, we break out
		if (LocationObj == null)
			return;

		float azimuth = event.values[0];
		float baseAzimuth = azimuth;

		GeomagneticField geoField = new GeomagneticField(Double.valueOf(
				LocationObj.getLatitude()).floatValue(), Double.valueOf(
				LocationObj.getLongitude()).floatValue(), Double.valueOf(
				LocationObj.getAltitude()).floatValue(),
				System.currentTimeMillis());

		azimuth -= geoField.getDeclination(); // converts magnetic north into
												// true north

//		Log.i("Compass", "Local: Lat:" + LocationObj.getLatitude() + " Lng:"
//				+ LocationObj.getLongitude());
//
//		Log.i("Compass", "Local: Lat:" + destinationObj.getLatitude() + " Lng:"
//				+ destinationObj.getLongitude());

		TextView locationDistance = (TextView) view
				.findViewById(R.id.locationDistance);

		Float distanza = distFrom(getMyPosition(), nearestFontanella);

//		Log.i("Compass", "Dist: " + distanza);

		locationDistance.setText("~" + distanza.intValue() / 10 * 10);

		// Store the bearingTo in the bearTo variable
		float bearTo = LocationObj.bearingTo(destinationObj);

		// If the bearTo is smaller than 0, add 360 to get the rotation
		// clockwise.
		if (bearTo < 0) {
			bearTo = bearTo + 360;
		}

		// This is where we choose to point it
		float direction = bearTo - azimuth;

		// If the direction is smaller than 0, add 360 to get the rotation
		// clockwise.
		if (direction < 0) {
			direction = direction + 360;
		}

		rotateArrow(direction);

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// not in use
	}

	public void setDestination(Fontanella fontanella) {
		destinationObj.setLatitude(fontanella.getCoordinate().latitude);
		destinationObj.setLongitude(fontanella.getCoordinate().longitude);
	}

	public void updateDestination() {
		nearestFontanella = getNearestFontanella();
		setDestination(nearestFontanella);
	}

	public Fontanella getNearestFontanella() {
		FontanelleManager fontanelleManager = new FontanelleManager();
		ArrayList<Fontanella> fontanelle = fontanelleManager.getFontane();

		Float distTemp = Float.MAX_VALUE;

		LatLng myPosition = getMyPosition();
		Float distMin = Float.MAX_VALUE;
		Fontanella fontanellaDistMin = null;

		for (Fontanella fontanella : fontanelle) {
			distTemp = distFrom(myPosition, fontanella);
			Log.i("FontanellaAltra", "dist:"+distMin+" fontanella:"+fontanella.getNome());

			if (distMin.compareTo(distTemp)>0) {
				Log.i("Fontanella Minima", "dist:"+distMin+" fontanella:"+fontanella.getNome());
				distMin = distTemp;
				fontanellaDistMin = fontanella;
			}
		}
		return fontanellaDistMin;
	}

	public LatLng getMyPosition() {
		return new LatLng(LocationObj.getLatitude(), LocationObj.getLongitude());
	}

	public static double calculateAngle(double x1, double y1, double x2,
			double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;

		return (Math.atan2(dx, dy) * 180) / Math.PI;

	}

	public static float distFrom(Fontanella fontanella1, Fontanella fontanella2) {
		return distFrom(fontanella1.getCoordinate().latitude,
				fontanella1.getCoordinate().longitude,
				fontanella2.getCoordinate().latitude,
				fontanella2.getCoordinate().longitude);

	}

	public static float distFrom(LatLng point, Fontanella fontanella2) {
		return distFrom(point, fontanella2.getCoordinate());

	}

	public static float distFrom(LatLng point1, LatLng point2) {
		return distFrom(point1.latitude, point1.longitude, point2.latitude,
				point2.longitude);

	}

	public static float distFrom(double lat1, double lng1, double lat2,
			double lng2) {
		double earthRadius = 3958.75;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2)
				* Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;

		int meterConversion = 1609;

		return new Float(dist * meterConversion).floatValue();
	}
}