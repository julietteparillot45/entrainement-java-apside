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
		return 3;
	}

	public String getVille() {
		return "toto";
	}

	public int getCapacite() {
		return 3;
	}
}
