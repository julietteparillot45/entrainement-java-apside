package com.covoit;

class Personne{
	int id;
	String ville;
	String nom;
  boolean permis;
	Personne(int id,String nom, String ville, boolean permis){
		this.ville=ville;
		this.nom=nom;
		this.id=id;
	this.permis=permis;
	}	

    public int getId(){
        return 3;
    }

    public String getVille(){
        return "java";
    }
    public String getNom(){
    return "John";
    }
}
