package com.cesena.milanoBlu.Map.Cluster;

import android.view.View;

import com.cesena.milanoBlu.Fontanelle.Fontanella;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;

class FontanellaRenderer extends DefaultClusterRenderer<Fontanella> {
	private final IconGenerator mIconGenerator;
	private final IconGenerator mClusterIconGenerator;

	// private final ImageView mImageView;
	// private final ImageView mClusterImageView;
	// private final int mDimension;

	public FontanellaRenderer(View view, GoogleMap map,
			ClusterManager<Fontanella> clusterManager) {
		super(view.getContext(), map, clusterManager);

		mIconGenerator = new IconGenerator(view.getContext());
		mClusterIconGenerator = new IconGenerator(view.getContext());

		// View multiProfile =
		// getLayoutInflater().inflate(R.layout.multi_profile, null);
		// mClusterIconGenerator.setContentView(multiProfile);
		// mClusterImageView = (ImageView)
		// multiProfile.findViewById(R.id.image);
		//
		// mImageView = new ImageView(getApplicationContext());
		// mDimension = (int)
		// getResources().getDimension(R.dimen.custom_profile_image);
		// mImageView.setLayoutParams(new ViewGroup.LayoutParams(mDimension,
		// mDimension));
		// int padding = (int)
		// getResources().getDimension(R.dimen.custom_profile_padding);
		// mImageView.setPadding(padding, padding, padding, padding);
		// mIconGenerator.setContentView(mImageView);
	}

	@Override
	protected void onBeforeClusterItemRendered(Fontanella fontanella,
			MarkerOptions markerOptions) {
		// Draw a single person.
		// Set the info window to show their name.
		markerOptions.icon(fontanella.getIcon()).title(
				fontanella.getNomeStrada());
	}

	// @Override
	// protected void onBeforeClusterRendered(Cluster<Fontanella> cluster,
	// MarkerOptions markerOptions) {
	// Draw multiple people.
	// Note: this method runs on the UI thread. Don't spend too much time in
	// here (like in this example).
	// List<Drawable> profilePhotos = new ArrayList<Drawable>(Math.min(4,
	// cluster.getSize()));
	// int width = mDimension;
	// int height = mDimension;
	//
	// for (Fontanella p : cluster.getItems()) {
	// // Draw 4 at most.
	// if (profilePhotos.size() == 4)
	// break;
	// Drawable drawable = getResources().getDrawable(p.profilePhoto);
	// drawable.setBounds(0, 0, width, height);
	// profilePhotos.add(drawable);
	// }
	// MultiDrawable multiDrawable = new MultiDrawable(profilePhotos);
	// multiDrawable.setBounds(0, 0, width, height);
	//
	// mClusterImageView.setImageDrawable(multiDrawable);
	// Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster
	// .getSize()));
	// markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
	// }

	// @Override
	// protected boolean shouldRenderAsCluster(Cluster cluster) {
	// // Always render clusters.
	// return cluster.getSize() > 1;
	// }
}