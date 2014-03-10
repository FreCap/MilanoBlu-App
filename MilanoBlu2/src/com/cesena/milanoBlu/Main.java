package com.cesena.milanoBlu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cesenaTeam.milanoBlu.R;


public class Main extends FragmentActivity {
    private Pager mAdapter;
    private ViewPager mPager;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mAdapter = new Pager(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        // This is required to avoid a black flash when the map is loaded.  The flash is due
        // to the use of a SurfaceView as the underlying view of the map.
        mPager.requestTransparentRegion(mPager);
        
    }

    /** A simple fragment that displays a TextView. */
    public static class TextFragment extends Fragment {
      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.text_fragment, container, false);
      }
    }

    
}
