package com.covoit;

import java.util.ArrayList;
import java.util.Collections;
class Covoiturage{
	ArrayList<Voiture> tabVoitures;
	ArrayList<Personne> tabPersonnes;
	Covoiturage( ArrayList<Voiture> t,ArrayList<Personne> p ){
		tabVoitures=t;
		tabPersonnes=p;
	}	
	boolean villeDesservie(String ville){
		for (Voiture v : tabVoitures) {
			if (v.getVille().equals(ville))
			return true;
		}
		return false;
	}
	int nbPersonnes(String ville){
		int nbpers=0;
		for (Personne p : tabPersonnes){
			if (p.getVille().equals(ville)){
				nbpers++;
			}
		}
		return nbpers;
	}

	// une méthode ``capaciteSuffisante`` prenant en paramètre une ville et renvoyant vrai si il y a assez de place dans les voitures de cette ville pour toutes les personnes qui y habitent et faux sinon ;
	boolean capaciteSuffisante(String ville){

		int nbPersRestantes=this.nbPersonnes(ville);
		for (Voiture v : this.tabVoitures){
			if (v.getVille().equals(ville))
				nbPersRestantes-=v.getCapacite();
		}
		if (nbPersRestantes>0)
			return false;
			
		return true;
	}

	//une méthode ``getVilles`` renvoyant *l'ensemble* des villes représentées (l'ensemble de toutes les villes de résidence des personnes et des voitures);
	ArrayList<String> getVilles(){
        ArrayList<String> res = new ArrayList<String>();

		for (Personne p : tabPersonnes){
			if (!res.contains(p.getVille())){
				res.add(p.getVille());
			}
		}
		for (Voiture v : tabVoitures){
			if (!res.contains(v.getVille())){
				res.add(v.getVille());
			}
		}

		return res;
	}

	// Une méthode qui renvoie l'identifiant de la personne et -1 si elle n'existe pas
    int getIdentifiant(String s){
		for (Personne p : this.tabPersonnes){
			if (p.getNom().equals(s))
				return p.getId();
		}
        return -1;
    }

	//une méthode ``capaciteSuffisante`` prenant en paramètre une ville et renvoyant vrai si il y a assez de place dans les voitures de cette ville pour toutes les personnes qui y habitent et faux sinon ;
    boolean capaciteSuffisante(){
		ArrayList<String> lesVilles = this.getVilles();
		for (String ville : lesVilles){
			if (!capaciteSuffisante(ville))
			return false;
		}

		return true;
	}

	int nbChauffeurs(String ville){
		int res=0;
		for (Personne p : tabPersonnes){
			if (p.getVille().equals(ville) && p.getPermis())
			res++;
		}
		return res;
	}
	int nbVoitures(String ville){
		int res=0;
		for (Voiture v : tabVoitures){
			if (v.getVille().equals(ville))
			res++;
		}
		return res;
	}

	// une méthode ``estPossible`` renvoyant vrai si non seulement la capacité est suffisante mais si en plus il y a assez de personnes en capacité de conduire (*Attention : pensez à prendre en priorité les voitures de grande capacité de façon à minimiser le nombre de chauffeurs*),
    boolean estPossible(){
		ArrayList<String> lesVilles = this.getVilles();
		for (String ville : lesVilles){
			int nbpers=this.nbPersonnes(ville);
			int nbpermis=this.nbPermis(ville);
			for (Voiture v : voituresTriees()){
				if (nbpermis<=0)
					return false;
				nbpermis--;
				System.out.println(v.getCapacite());
				nbpers-=v.getCapacite();
				if (nbpers<=0)
					break;
			}
			if (nbpers>0)
				return false;
		}
		return true;
	}

	private int nbPermis(String ville) {
		int res=0;
		for (Personne p : tabPersonnes) {
			if (p.getVille().equals(ville) && p.getPermis())
			res++;
		}
		return res;
	}
	// Renvoie la liste des voitures triée par capacité
	private ArrayList<Voiture> voituresTriees() {
		ArrayList<Voiture> listTriee = new ArrayList<>(tabVoitures);
		Collections.sort(listTriee);
		return listTriee;
	}

	// une méthode ``attribution`` qui renvoie une liste de nombres entiers : à la position **i** de la liste se trouve le numéro de la voiture qui conduira la personne d'identifiant **i**.
}
