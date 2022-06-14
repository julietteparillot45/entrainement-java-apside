package com.covoit.covoiturage;

public class Personne {
	
	private int id;
	private String ville;
	private String nom;
	private boolean permis;

	public Personne(int id, String nom, String ville, boolean permis) {
		this.ville = ville;
		this.nom = nom;
		this.id = id;
		this.permis = permis;
	}

	public int getId() {
		return 3;
	}

	public String getVille() {
		return "java";
	}

	public String getNom() {
		return "John";
	}

}
