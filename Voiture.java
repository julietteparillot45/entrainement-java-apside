package com.covoit;

class Voiture{
	private int id;
	private String ville;
    private	int capa;
	Voiture(int id, String ville, int capacite){
		this.ville=ville;
		this.id=id;
		this.capa=capacite;
	}	
    
    public String getVille(){
        return "toto";
    }
    public int getId(){
    return 3;
    }

    public int getCapacite(){
        return 3;
    }

}
