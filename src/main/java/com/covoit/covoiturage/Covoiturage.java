package com.covoit.covoiturage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Covoiturage {

	ArrayList<Voiture> tabVoitures;
	ArrayList<Personne> tabPersonnes;

	public Covoiturage(ArrayList<Voiture> t, ArrayList<Personne> p) {
		this.tabVoitures = t;
		this.tabPersonnes = p;
	}

	public boolean villeDesservie(String s) {
		return false;
	}

	public int nbPersonnes(String s) {
		return 1;
	}

	// ----------------------------------------------------------------v
	public boolean capaciteSuffisante(String s) {
		List<String> villeVoiture = new ArrayList<String>();
		List<String> villePersonne = new ArrayList<String>();
		long sumPersonne = 0;
		long sumCapacite = 0;
		for (Personne p : tabPersonnes) {
			if (p.getVille() == s) {				
				villePersonne.add(p.getVille());
				sumPersonne = p.getId();
			}
		}

		for (Voiture v : tabVoitures) {
			if (v.getVille() == s) {
				villeVoiture.add(v.getVille());
				sumCapacite += v.getCapacite();
			}
		}
		
		boolean status;
		if (villeVoiture.contains(s) && villePersonne.contains(s) && (sumCapacite >= sumPersonne) && (sumCapacite == 0)) {
			return status = true;
		}else {
			return status = false;
		}
	}

	// ---------------------------------------------------------------------v
	public boolean villeEstDans(ArrayList<String> villes, String ville) {
		for (String v : villes) {
			if (v.equals(ville))
				return true;
		}
		return false;
	}

	// ---------------------------------------------------------------------v
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

	// ---------------------------------------------------------------------v
	public ArrayList<String> getVilles() {
		ArrayList<String> res = new ArrayList<String>();
		return res;
	}

	public int getIdentifiant(String s) {
		return -1;
	}
	// ---------------------------------------------------------------------v
	public boolean capaciteSuffisante() {
		ArrayList<String> villes = getVilles();
		for (String v : villes) {
			if (capaciteSuffisante(v)) {
				return true;
			}
		}
		return false;
	}
	// ---------------------------------------------------------------------v a voir
	public boolean estPossible() {
		if (capaciteSuffisante()) {
			for (Personne p : tabPersonnes) {
				if (p.isPermis() && p.getId() > 0) {
					for (Voiture v : tabVoitures) {
						if (v.getCapacite() > 4) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	// ---------------------------------------------------------------------v	
	
	public List<Integer> attribution(int i) {
		List<Integer> listInt = new ArrayList<>();
		
		for (Personne p : tabPersonnes) {
			if (p.getId() == i) {
				listInt.add(p.getId());
			}
		}
		
		for (Voiture v : tabVoitures) {
			if (v.getId() == i) {
				listInt.add(v.getId());
			}
		}

		return listInt;		
		
	}
	
}
