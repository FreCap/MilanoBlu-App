package com.cesena.milanoBlu.Fontanelle;

import org.json.JSONException;
import org.json.JSONObject;

public class FontanellaVoto {

	private Integer fontanellaVoto_id;
	private Integer fontanella_id; // unused, ma magari in futuro...
	private Float voto;
	private String nomeVotante;
	private String commento; // unimplemented
	private Integer timestamp;

	public FontanellaVoto(JSONObject jsonObject) {
		try {
			fontanellaVoto_id = jsonObject.getInt("fontanellaVoto_id");
			fontanella_id = jsonObject.getInt("fontanella_id");
			voto = Float.valueOf(jsonObject.getString("voto"));
			nomeVotante = jsonObject.getString("nomeVotante");
			timestamp = jsonObject.getInt("time");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public Float getVoto() {
		return voto;
	}

	public void setVoto(Float voto) {
		this.voto = voto;
	}

	public String getNomeVotante() {
		return nomeVotante;
	}

	public void setNomeVotante(String nomeVotante) {
		this.nomeVotante = nomeVotante;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public Integer getTime() {
		return timestamp;
	}

	public void setTime(Integer time) {
		this.timestamp = time;
	}

}
