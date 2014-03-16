package com.cesena.milanoBlu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cesenaTeam.milanoBlu.R;

public class FragmentDetails extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.news_list_fragment, container,
				false);

		return rootView;
	}
}
