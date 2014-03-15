package com.cesena.milanoBlu.Fontanelle;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.model.LatLng;

public class Fontanella {

	private Integer fontanella_id;
	private String nome;
	private LatLng coordinate;
	private String nomeStrada;
	private Float qualita;

	private ArrayList<FontanellaVoto> _voti;

	public Fontanella(JSONObject jsonObject) {
		try {
			setFontanella_id(jsonObject.getInt("fontanella_id"));
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

}
