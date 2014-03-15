package com.cesena.milanoBlu.Fontanelle;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FontanelleManager {

	final static int MODE_MOCK = 2;
	final static int MODE_RELEASE = 1;

	public String getMockJSON() {
		return "[{\"fontanella_id\":0,\"nome\":\"Michael Leblanc\",\"nomeStrada\":\"194 Irving Avenue, Nash, Indiana, 6662\",\"latitude\":45.518525,\"longitude\":9.103288,\"qualita\":1.7},{\"fontanella_id\":1,\"nome\":\"Robin Horne\",\"nomeStrada\":\"128 Wogan Terrace, Dargan, Michigan, 2288\",\"latitude\":45.50789,\"longitude\":9.165682,\"qualita\":2.2},{\"fontanella_id\":2,\"nome\":\"Hardy Mcbride\",\"nomeStrada\":\"656 Ocean Parkway, Dellview, Pennsylvania, 1613\",\"latitude\":45.43146,\"longitude\":9.237136,\"qualita\":3.8},{\"fontanella_id\":3,\"nome\":\"Silvia Cervantes\",\"nomeStrada\":\"614 Gem Street, Norvelt, Maine, 9797\",\"latitude\":45.450399,\"longitude\":9.105683,\"qualita\":1.6},{\"fontanella_id\":4,\"nome\":\"Goodman Patterson\",\"nomeStrada\":\"159 Wilson Avenue, Lorraine, Nebraska, 3938\",\"latitude\":45.493282,\"longitude\":9.209628,\"qualita\":2},{\"fontanella_id\":5,\"nome\":\"Newton Osborne\",\"nomeStrada\":\"363 Mill Road, Cochranville, Tennessee, 3780\",\"latitude\":45.529968,\"longitude\":9.218826,\"qualita\":2.6},{\"fontanella_id\":6,\"nome\":\"Noelle Alexander\",\"nomeStrada\":\"833 Colin Place, Beyerville, Wisconsin, 8082\",\"latitude\":45.433106,\"longitude\":9.183998,\"qualita\":2},{\"fontanella_id\":7,\"nome\":\"Haley Ellis\",\"nomeStrada\":\"299 Roder Avenue, Barstow, Alaska, 7044\",\"latitude\":45.417395,\"longitude\":9.223514,\"qualita\":2.4},{\"fontanella_id\":8,\"nome\":\"Jenifer Stanley\",\"nomeStrada\":\"839 Cove Lane, Matthews, Mississippi, 4383\",\"latitude\":45.501679,\"longitude\":9.244824,\"qualita\":3.7},{\"fontanella_id\":9,\"nome\":\"Mitchell Harris\",\"nomeStrada\":\"550 Nassau Avenue, Westboro, North Carolina, 4946\",\"latitude\":45.457969,\"longitude\":9.171806,\"qualita\":2.6},{\"fontanella_id\":10,\"nome\":\"Yvonne Chapman\",\"nomeStrada\":\"816 Beverly Road, Century, New Mexico, 3771\",\"latitude\":45.471709,\"longitude\":9.112785,\"qualita\":4.6},{\"fontanella_id\":11,\"nome\":\"Campos Sellers\",\"nomeStrada\":\"975 Coleridge Street, Summerset, New Jersey, 3500\",\"latitude\":45.417621,\"longitude\":9.156998,\"qualita\":2.2},{\"fontanella_id\":12,\"nome\":\"Green Pitts\",\"nomeStrada\":\"744 Conway Street, Stewart, Hawaii, 8647\",\"latitude\":45.508136,\"longitude\":9.243964,\"qualita\":1.6},{\"fontanella_id\":13,\"nome\":\"Puckett Nolan\",\"nomeStrada\":\"967 Bay Parkway, Cloverdale, Georgia, 5292\",\"latitude\":45.467571,\"longitude\":9.207393,\"qualita\":3.5},{\"fontanella_id\":14,\"nome\":\"Ada Gibbs\",\"nomeStrada\":\"285 Gain Court, Bergoo, Kentucky, 6391\",\"latitude\":45.496143,\"longitude\":9.157796,\"qualita\":3.5},{\"fontanella_id\":15,\"nome\":\"Roman Gentry\",\"nomeStrada\":\"759 Polhemus Place, Advance, North Dakota, 8654\",\"latitude\":45.507414,\"longitude\":9.231443,\"qualita\":2.4},{\"fontanella_id\":16,\"nome\":\"Mae Barron\",\"nomeStrada\":\"990 Louis Place, Esmont, Utah, 321\",\"latitude\":45.519672,\"longitude\":9.136868,\"qualita\":3.8},{\"fontanella_id\":17,\"nome\":\"Wade Roy\",\"nomeStrada\":\"825 School Lane, Cucumber, Illinois, 995\",\"latitude\":45.512995,\"longitude\":9.181414,\"qualita\":2.4},{\"fontanella_id\":18,\"nome\":\"Wright Leon\",\"nomeStrada\":\"954 Fillmore Place, Irwin, California, 8381\",\"latitude\":45.480753,\"longitude\":9.205204,\"qualita\":4.4},{\"fontanella_id\":19,\"nome\":\"Valeria Conner\",\"nomeStrada\":\"271 Stillwell Place, Gila, Alabama, 4521\",\"latitude\":45.481079,\"longitude\":9.096215,\"qualita\":2.3},{\"fontanella_id\":20,\"nome\":\"Walsh Jordan\",\"nomeStrada\":\"628 Gerry Street, Jenkinsville, Arkansas, 649\",\"latitude\":45.443167,\"longitude\":9.236627,\"qualita\":4.8},{\"fontanella_id\":21,\"nome\":\"Saunders Velez\",\"nomeStrada\":\"942 Seagate Terrace, Coyote, Texas, 6565\",\"latitude\":45.477824,\"longitude\":9.202198,\"qualita\":4.8},{\"fontanella_id\":22,\"nome\":\"Washington Rivers\",\"nomeStrada\":\"497 National Drive, Bedias, New York, 6606\",\"latitude\":45.529899,\"longitude\":9.175316,\"qualita\":3.5},{\"fontanella_id\":23,\"nome\":\"Mason Bartlett\",\"nomeStrada\":\"793 Fuller Place, Loomis, Iowa, 645\",\"latitude\":45.453048,\"longitude\":9.135571,\"qualita\":3.9},{\"fontanella_id\":24,\"nome\":\"Mavis Chang\",\"nomeStrada\":\"144 Devon Avenue, Rivera, Connecticut, 3876\",\"latitude\":45.508051,\"longitude\":9.1188,\"qualita\":1.7},{\"fontanella_id\":25,\"nome\":\"Evangeline Webster\",\"nomeStrada\":\"807 Gatling Place, Iola, Arizona, 6520\",\"latitude\":45.441517,\"longitude\":9.251169,\"qualita\":4.1},{\"fontanella_id\":26,\"nome\":\"Holder Romero\",\"nomeStrada\":\"704 Dewey Place, Jackpot, South Carolina, 4339\",\"latitude\":45.513881,\"longitude\":9.126132,\"qualita\":4.1},{\"fontanella_id\":27,\"nome\":\"Sondra Foreman\",\"nomeStrada\":\"726 Oakland Place, Longbranch, Kansas, 5323\",\"latitude\":45.46375,\"longitude\":9.26534,\"qualita\":3.3},{\"fontanella_id\":28,\"nome\":\"Mathis Marsh\",\"nomeStrada\":\"950 Meserole Street, Gilmore, Ohio, 340\",\"latitude\":45.520179,\"longitude\":9.188842,\"qualita\":2.1},{\"fontanella_id\":29,\"nome\":\"John Pratt\",\"nomeStrada\":\"819 Fiske Place, Dupuyer, Minnesota, 2403\",\"latitude\":45.468281,\"longitude\":9.265076,\"qualita\":2.6},{\"fontanella_id\":30,\"nome\":\"Carlene Gordon\",\"nomeStrada\":\"131 Bedford Place, Vicksburg, Nevada, 5488\",\"latitude\":45.479483,\"longitude\":9.101165,\"qualita\":4.6}]";
	}

	public ArrayList<Fontanella> getFontane() {
		int mode = MODE_MOCK;
		String jsonData = null;
		if (mode == MODE_MOCK) {
			jsonData = getMockJSON();
		} else {
			// TODO creare il servizio
		}

		ArrayList<Fontanella> fontanelle = new ArrayList<Fontanella>();
		Fontanella fontanella;

		JSONArray array;
		try {
			array = new JSONArray(jsonData);
			for (int i = 0; i < array.length(); i++) {
				JSONObject row = array.getJSONObject(i);
				fontanella = new Fontanella(row);
				fontanelle.add(fontanella);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fontanelle;
	}

}
