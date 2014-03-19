package com.cesena.milanoBlu.Contatti;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.cesenaTeam.milanoBlu.R;

public class ContattiActivity extends Activity {
	private ListView contattiList;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contatti_activity);
		
		ArrayList<Contatto> contatti = new ArrayList<Contatto>();
		contatti.add(new Contatto(getString(R.string.contatto_1_titolo), getString(R.string.contatto_1_descrizione)));
		contatti.add(new Contatto(getString(R.string.contatto_2_titolo), getString(R.string.contatto_2_descrizione)));
		contatti.add(new Contatto(getString(R.string.contatto_3_titolo), getString(R.string.contatto_3_descrizione)));
		contatti.add(new Contatto(getString(R.string.contatto_4_titolo), getString(R.string.contatto_4_descrizione)));
		contatti.add(new Contatto(getString(R.string.contatto_5_titolo), getString(R.string.contatto_5_descrizione)));
		
		contattiList = (ListView) getWindow().getDecorView().getRootView().findViewById(R.id.contattiList);
		contattiList.setAdapter(new ContattiAdapter(this, contatti));
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.home:
			finish();
			return true;
		case R.id.contatti:

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}