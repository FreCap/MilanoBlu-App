package com.cesena.milanoBlu;

import java.util.Locale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cesena.milanoBlu.Compass.CompassFragment;
import com.cesena.milanoBlu.Main.TextFragment;
import com.cesena.milanoBlu.Map.MapFragment;
import com.cesena.milanoBlu.News.NewsFragment;

public class Pager extends FragmentPagerAdapter {
	public Pager(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return 5;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new NewsFragment();
		case 1:
			return new MapFragment();
		case 2:
			return new CompassFragment();
		case 3:
			return new TextFragment();
		case 4:
			return new TextFragment();
		default:
			return null;
		}
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return "News";
		case 1:
			return "Mappa";
		case 2:
			return "Ho sete";
		case 3:
			return "Consigli";
		case 4:
			return "Video";
		}
		return null;
	}
}