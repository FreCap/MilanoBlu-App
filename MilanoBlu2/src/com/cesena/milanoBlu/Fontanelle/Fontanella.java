package com.cesena.milanoBlu.Fontanelle;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.cesenaTeam.milanoBlu.R;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class Fontanella implements ClusterItem  {

	public final static int QUALITA_BASSA = 3;
	public final static int QUALITA_MEDIA = 2;
	public final static int QUALITA_ALTA = 1;
	
	private Integer fontanella_id;
	private String nome;
	private LatLng coordinate;
	private String nomeStrada;
	private Float qualita;

	private ArrayList<FontanellaVoto> _voti;

	public Fontanella(JSONObject jsonObject) {
		try {
			setFontanella_id(jsonObject.getInt("fontana_id"));
			nome = jsonObject.getString("nome");
			coordinate = new LatLng(jsonObject.getDouble("latitude"),
					jsonObject.getDouble("longitude"));
			nomeStrada = jsonObject.getString("nomeStrada");
			qualita = Float.valueOf(jsonObject.getString("qualita"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LatLng getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(LatLng coordinate) {
		this.coordinate = coordinate;
	}

	public String getNomeStrada() {
		return nomeStrada;
	}

	public void setNomeStrada(String nomeStrada) {
		this.nomeStrada = nomeStrada;
	}

	public Float getQualita() {
		return qualita;
	}

	public void setQualita(Float qualita) {
		this.qualita = qualita;
	}


	public Integer getFontanella_id() {
		return fontanella_id;
	}


	public void setFontanella_id(Integer fontanella_id) {
		this.fontanella_id = fontanella_id;
	}
	
	@Override
	public LatLng getPosition() {
		return getCoordinate();
	}
	
	public BitmapDescriptor getIcon(){
		// Integer qualita = null;
		// if (getQualita() > 3.5)
		// qualita = QUALITA_ALTA;
		// else if (getQualita() > 2.5)
		// qualita = QUALITA_MEDIA;
		// else
		// qualita = QUALITA_BASSA;
		//
		// int resource = 0;
		// switch (qualita) {
		// case QUALITA_ALTA:
		// resource = R.drawable.goccia_blu;
		// break;
		// case QUALITA_MEDIA:
		// resource = R.drawable.goccia_gialla;
		// break;
		// case QUALITA_BASSA:
		// resource = R.drawable.goccia_verde;
		// break;
		// }
		//
		// return BitmapDescriptorFactory.fromResource(resource);
		
		Integer qualita = null;
		int resource = 0;

		if (getQualita().compareTo((float) (4f-0.1))>0)
			resource = R.drawable.qualita_5;
		else if(getQualita().compareTo((float) (3f-0.1))>0)
			resource = R.drawable.qualita_4;
		else if(getQualita().compareTo((float) (2f-0.1))>0)
			resource = R.drawable.qualita_3;
		else if(getQualita().compareTo((float) (1f-0.1))>0)
			resource = R.drawable.qualita_2;
		else
			resource = R.drawable.qualita_1;

		return BitmapDescriptorFactory.fromResource(resource);
	}

}
