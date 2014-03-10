package com.cesena.milanoBlu;

import java.util.Locale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cesena.milanoBlu.Main.TextFragment;

public class Pager extends FragmentPagerAdapter {
	public Pager(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new TextFragment();
		case 1:
			return new MapFragment();
		case 2:
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
			return "Fuck";
		}
		return null;
	}
}