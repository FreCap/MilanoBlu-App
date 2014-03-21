package com.cesena.milanoBlu.News;

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

public class NewsFragment extends Fragment {
	ListView newsList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.news_list_fragment,
				container, false);

		NewsManager newsManager = new NewsManager();

		newsList = (ListView) rootView.findViewById(R.id.list1);

		ArrayList<News> arrayList = newsManager.getNews();
		News.listObject = newsList;
		newsList.setAdapter(new NewsAdapter(getActivity(), arrayList));
		newsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				News news = (News) newsList.getItemAtPosition(position);
				String url = news.getLink();
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);

				// Object o = news.getItemAtPosition(position);
				// SearchResults fullObject = (SearchResults) o;
				// Toast.makeText(getActivity(),
				// "You have chosen: " + " " + fullObject.getTitle(),
				// Toast.LENGTH_LONG).show();
			}
		});
		return rootView;
	}

}
