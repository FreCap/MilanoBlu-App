package com.cesena.milanoBlu.Fontanelle;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FontanelleVotiManager {

	final static int MODE_MOCK = 2;
	final static int MODE_RELEASE = 1;

	public String getMockJSON() {
		return "[{\"fontanellaVoto_id\":0,\"fontanella_id\":\"1\",\"voto\":4.8,\"nomeVotante\":\"Sue Roach\",\"time\":1382518071},{\"fontanellaVoto_id\":1,\"fontanella_id\":\"1\",\"voto\":3.4,\"nomeVotante\":\"Curtis Love\",\"time\":1390435287},{\"fontanellaVoto_id\":2,\"fontanella_id\":\"1\",\"voto\":2,\"nomeVotante\":\"Baldwin Sutton\",\"time\":1373143654},{\"fontanellaVoto_id\":3,\"fontanella_id\":\"1\",\"voto\":3.1,\"nomeVotante\":\"Woods Fisher\",\"time\":1366422795},{\"fontanellaVoto_id\":4,\"fontanella_id\":\"1\",\"voto\":4.3,\"nomeVotante\":\"Gale Bailey\",\"time\":1381302636},{\"fontanellaVoto_id\":5,\"fontanella_id\":\"1\",\"voto\":4.5,\"nomeVotante\":\"Lancaster Patton\",\"time\":1377144992},{\"fontanellaVoto_id\":6,\"fontanella_id\":\"1\",\"voto\":1.6,\"nomeVotante\":\"Silva Jefferson\",\"time\":1381899079},{\"fontanellaVoto_id\":7,\"fontanella_id\":\"1\",\"voto\":2.6,\"nomeVotante\":\"Harriett Neal\",\"time\":1367979081},{\"fontanellaVoto_id\":8,\"fontanella_id\":\"1\",\"voto\":5,\"nomeVotante\":\"Saundra Terrell\",\"time\":1364877139},{\"fontanellaVoto_id\":9,\"fontanella_id\":\"1\",\"voto\":2.5,\"nomeVotante\":\"Alberta Robbins\",\"time\":1366935113},{\"fontanellaVoto_id\":10,\"fontanella_id\":\"1\",\"voto\":4.1,\"nomeVotante\":\"Mccall Horne\",\"time\":1367787094},{\"fontanellaVoto_id\":11,\"fontanella_id\":\"1\",\"voto\":2.4,\"nomeVotante\":\"Natalia Donaldson\",\"time\":1371392934},{\"fontanellaVoto_id\":12,\"fontanella_id\":\"1\",\"voto\":3.8,\"nomeVotante\":\"Cheryl Preston\",\"time\":1377040570},{\"fontanellaVoto_id\":13,\"fontanella_id\":\"1\",\"voto\":3,\"nomeVotante\":\"Irwin Randall\",\"time\":1389440660},{\"fontanellaVoto_id\":14,\"fontanella_id\":\"1\",\"voto\":3.5,\"nomeVotante\":\"Cantu Byrd\",\"time\":1387069761},{\"fontanellaVoto_id\":15,\"fontanella_id\":\"1\",\"voto\":2.7,\"nomeVotante\":\"Lottie Kim\",\"time\":1373032933},{\"fontanellaVoto_id\":16,\"fontanella_id\":\"1\",\"voto\":3.2,\"nomeVotante\":\"Christine Hobbs\",\"time\":1393384851},{\"fontanellaVoto_id\":17,\"fontanella_id\":\"1\",\"voto\":4.4,\"nomeVotante\":\"Tania Glover\",\"time\":1367202097},{\"fontanellaVoto_id\":18,\"fontanella_id\":\"1\",\"voto\":2.2,\"nomeVotante\":\"Lyons Mcdonald\",\"time\":1371908916},{\"fontanellaVoto_id\":19,\"fontanella_id\":\"1\",\"voto\":4.7,\"nomeVotante\":\"Cherry Watts\",\"time\":1368007467},{\"fontanellaVoto_id\":20,\"fontanella_id\":\"1\",\"voto\":3.2,\"nomeVotante\":\"Hahn Tyler\",\"time\":1391453606},{\"fontanellaVoto_id\":21,\"fontanella_id\":\"1\",\"voto\":2.2,\"nomeVotante\":\"Beverley Rowland\",\"time\":1390700495},{\"fontanellaVoto_id\":22,\"fontanella_id\":\"1\",\"voto\":3.3,\"nomeVotante\":\"Palmer Garza\",\"time\":1373824675},{\"fontanellaVoto_id\":23,\"fontanella_id\":\"1\",\"voto\":4.9,\"nomeVotante\":\"Ferrell Shepard\",\"time\":1393745469},{\"fontanellaVoto_id\":24,\"fontanella_id\":\"1\",\"voto\":2.3,\"nomeVotante\":\"Freeman Bartlett\",\"time\":1384932179},{\"fontanellaVoto_id\":25,\"fontanella_id\":\"1\",\"voto\":4.3,\"nomeVotante\":\"Colleen Walter\",\"time\":1365706165},{\"fontanellaVoto_id\":26,\"fontanella_id\":\"1\",\"voto\":4.3,\"nomeVotante\":\"Lakisha Burke\",\"time\":1374046096},{\"fontanellaVoto_id\":27,\"fontanella_id\":\"1\",\"voto\":3.4,\"nomeVotante\":\"Margaret Carrillo\",\"time\":1377276816},{\"fontanellaVoto_id\":28,\"fontanella_id\":\"1\",\"voto\":3.4,\"nomeVotante\":\"Sylvia Hunt\",\"time\":1380112564},{\"fontanellaVoto_id\":29,\"fontanella_id\":\"1\",\"voto\":2.7,\"nomeVotante\":\"Dodson Sears\",\"time\":1367793107},{\"fontanellaVoto_id\":30,\"fontanella_id\":\"1\",\"voto\":4.2,\"nomeVotante\":\"Christa Mann\",\"time\":1385174826},{\"fontanellaVoto_id\":31,\"fontanella_id\":\"1\",\"voto\":2,\"nomeVotante\":\"Darcy Mccullough\",\"time\":1369934570},{\"fontanellaVoto_id\":32,\"fontanella_id\":\"1\",\"voto\":4.1,\"nomeVotante\":\"Pope Marshall\",\"time\":1382270167},{\"fontanellaVoto_id\":33,\"fontanella_id\":\"1\",\"voto\":2.5,\"nomeVotante\":\"Beatriz Small\",\"time\":1376386077}]";
	}

	public ArrayList<FontanellaVoto> getVoti(Fontanella fontanella) {
		return getVoti(fontanella.getFontanella_id());
	}

	public ArrayList<FontanellaVoto> getVoti(Integer fontana_id) {
		int mode = MODE_MOCK;
		String jsonData = null;
		if (mode == MODE_MOCK) {
			jsonData = getMockJSON();
		} else {
			// TODO creare il servizio
		}

		ArrayList<FontanellaVoto> fontanellaVoti = new ArrayList<FontanellaVoto>();
		FontanellaVoto fontanellaVoto;

		JSONArray array;
		try {
			array = new JSONArray(jsonData);
			for (int i = 0; i < array.length(); i++) {
				JSONObject row = array.getJSONObject(i);
				fontanellaVoto = new FontanellaVoto(row);
				fontanellaVoti.add(fontanellaVoto);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fontanellaVoti;
	}

}
