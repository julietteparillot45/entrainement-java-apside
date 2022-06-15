package com.covoit;

class Voiture implements Comparable<Voiture>{
	private int id;
	private String ville;
    private	int capa;

	Voiture(int id, String ville, int capacite){
		this.ville=ville;
		this.id=id;
		this.capa=capacite;
	}
    
    public String getVille(){
        return this.ville;
    }
    
    public int getId(){
        return this.id;
    }

    public int getCapacite(){
        return this.capa;
    }

    @Override
    public int compareTo(Voiture o) {
        return o.getCapacite()-this.getCapacite();
    }

}
