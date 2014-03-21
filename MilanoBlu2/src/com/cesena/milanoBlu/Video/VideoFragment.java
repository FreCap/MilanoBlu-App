package com.cesena.milanoBlu.Video;

import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cesenaTeam.milanoBlu.R;

public class VideoFragment extends Fragment {
	ListView videoList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inserisce il file xml del fragment nell'activity
		View rootView = inflater.inflate(R.layout.video_fragment, container,
				false);

		// Inizializzo un vettore di VideoObject con alcuni valori di prova
		// restituiti dalla funzione GetSearchResults
		videoList = (ListView) rootView.findViewById(R.id.list1);
		ArrayList<Video> searchResults = GetSearchResults();
		videoList
				.setAdapter(new VideoListAdapter(getActivity(), searchResults));
		videoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				// Starta l'intent che visualizza il video relativo all'item
				// clickato
				Object o = videoList.getItemAtPosition(position);
				Video fullObject = (Video) o;
				String url = fullObject.getLink();
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});

		return rootView;
	}

	private ArrayList<Video> GetSearchResults() {

		ArrayList<Video> results = new ArrayList<Video>();
		Video.listObject = videoList;
		VideoManager videoManager = new VideoManager();

		return videoManager.getVideo();
	}
}
