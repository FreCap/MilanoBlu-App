package com.cesena.milanoBlu.Contatti;

public class Contatto {
	private String titolo;
	private String descrizione;

	public Contatto(String titolo, String descrizione) {
		this.titolo = titolo;
		this.descrizione = descrizione;
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
