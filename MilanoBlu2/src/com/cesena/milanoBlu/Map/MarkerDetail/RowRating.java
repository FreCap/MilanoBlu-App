package com.cesena.milanoBlu.Map.MarkerDetail;

public class RowRating {

	private String nome;
	private Float rating;

	public RowRating(String nome, Float rating) {
		super();
		this.setNome(nome);
		this.setRating(rating);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}
}