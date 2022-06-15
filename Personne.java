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
        return this.id;
    }

    public String getVille(){
        return this.ville;
    }
    public String getNom(){
    return this.nom;
    }
    public boolean getPermis(){
        return this.permis;
    }
}
