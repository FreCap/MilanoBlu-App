package com.cesena.milanoBlu.news;

import org.json.JSONException;
import org.json.JSONObject;

public class News {
	private Integer fontanellaVoto_id;
	private Integer fontanella_id;
	private Float voto;
	private String nomeVotante;
	private Integer timestamp;

	public News(JSONObject jsonObject) {
		try {
			fontanellaVoto_id = jsonObject.getInt("fontanellaVoto_id");
			fontanella_id = jsonObject.getInt("fontanella_id");
			voto = Float.valueOf(jsonObject.getString("voto"));
			nomeVotante = jsonObject.getString("voto");
			timestamp = jsonObject.getInt("timestamp");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getFontanellaVoto_id() {
		return fontanellaVoto_id;
	}

	public void setFontanellaVoto_id(Integer fontanellaVoto_id) {
		this.fontanellaVoto_id = fontanellaVoto_id;
	}

	public Integer getFontanella_id() {
		return fontanella_id;
	}

	public void setFontanella_id(Integer fontanella_id) {
		this.fontanella_id = fontanella_id;
	}

	public String getNomeVotante() {
		return nomeVotante;
	}

	public void setNomeVotante(String nomeVotante) {
		this.nomeVotante = nomeVotante;
	}

	public Float getVoto() {
		return voto;
	}

	public void setVoto(Float voto) {
		this.voto = voto;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

}
