package com.covoit.covoiturage;

public class Voiture {

	private int id;
	private String ville;
	private int capa;

	public Voiture(int id, String ville, int capacite) {
		this.ville = ville;
		this.id = id;
		this.capa = capacite;
	}

	public int getId() {
		return this.id;
	}

	public String getVille() {
		return this.ville;
	}

	public int getCapacite() {
		return this.capa;
	}
}
