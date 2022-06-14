package com.covoit.covoiturage;

import java.util.ArrayList;
import java.util.HashSet;

public class Covoiturage {

	ArrayList<Voiture> tabVoitures;
	ArrayList<Personne> tabPersonnes;

	public Covoiturage(ArrayList<Voiture> t, ArrayList<Personne> p) {
		tabVoitures = t;
		tabPersonnes = p;
	}

	public boolean villeDesservie(String s) {
		return false;
	}

	public int nbPersonnes(String s) {
		return 1;
	}

	// ----------------------------------------------------------------
	public boolean capaciteSuffisante(String s) {

		if (tabVoitures.contains(s) && tabPersonnes.contains(s)) {
			long sumPersonne = tabPersonnes.size();
			long sumCapacite = 0;
			for (Voiture voiture : tabVoitures) {
				sumCapacite += voiture.getCapacite();
			}
			if (sumCapacite <= sumPersonne) {
				return true;
			}
		}
		return false;
	}

	// ---------------------------------------------------------------------
	public boolean villeEstDans(ArrayList<String> villes, String ville) {
		for (String v : villes) {
			if (v.equals(ville))
				return true;
		}
		return false;
	}

	// ---------------------------------------------------------------------
	public HashSet<String> getVilles2() {
		HashSet<String> villesPersonne = new HashSet<String>();
		for (Personne villeP : tabPersonnes) {
			villesPersonne.add(villeP.getVille());
		}
		for (Voiture villeV : tabVoitures) {
			villesPersonne.add(villeV.getVille());
		}

		return villesPersonne;
	}

	// ---------------------------------------------------------------------
	public ArrayList<String> getVilles() {
		ArrayList<String> res = new ArrayList<String>();
		return res;
	}

	public int getIdentifiant(String s) {
		return -1;
	}

	public boolean capaciteSuffisante() {
		return false;
	}

	public boolean estPossible() {
		return false;
	}
}
