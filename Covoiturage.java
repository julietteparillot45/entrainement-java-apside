package com.covoit;

import java.util.ArrayList;
class Covoiturage{
	ArrayList<Voiture> tabVoitures;
	ArrayList<Personne> tabPersonnes;
	Covoiturage( ArrayList<Voiture> t,ArrayList<Personne> p ){
		tabVoitures=t;
		tabPersonnes=p;
	}	
	boolean villeDesservie(String s){
		return false;
	}
	int nbPersonnes(String s){
		return 1;
	}
	boolean capaciteSuffisante(String s){
		return true;
	}
	ArrayList<String> getVilles(){
                ArrayList<String> res = new ArrayList<String>();
		return res;
	}
        int getIdentifiant(String s){
            return -1;
        }
        boolean capaciteSuffisante(){return false;}
        boolean estPossible(){return false;}
}
