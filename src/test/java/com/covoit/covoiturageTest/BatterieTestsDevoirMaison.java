package com.covoit.covoiturageTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.covoit.covoiturage.Covoiturage;
import com.covoit.covoiturage.Personne;
import com.covoit.covoiturage.Voiture;

public class BatterieTestsDevoirMaison {

	/* Attention, n'utilisez que des assertEquals ! */

	@Test
	public void testVoiture() throws Exception {
		Voiture v1 = new Voiture(1, "Ardon", 5);
		Voiture v2 = new Voiture(2, "Sandillon", 3);
		Voiture v3 = new Voiture(3, "Orleans", 7);
		Voiture v4 = new Voiture(4, "Truc", 4);
		assertEquals(5, v1.getCapacite());
		assertEquals("Ardon", v1.getVille());
		assertEquals(1, v1.getId());

		assertEquals(7, v3.getCapacite());
		assertEquals("Orleans", v3.getVille());
		assertEquals(3, v3.getId());
	}

	@Test
	public void testPersonne() throws Exception {
		Personne p1 = new Personne(1, "John", "Sandillon", true);
		Personne p2 = new Personne(2, "Jules", "Orleans", true);

		assertEquals(1, p1.getId());
		assertEquals(2, p2.getId());

		assertEquals("John", p1.getNom());
		assertEquals("Jules", p2.getNom());

		assertEquals("Sandillon", p1.getVille());
		assertEquals("Orleans", p2.getVille());
	}

	@Test
	public void testConstructeurCovoiturage() throws Exception {
		ArrayList<Personne> personnes = new ArrayList<>();
		personnes.add(new Personne(1, "John", "Sandillon", true));
		personnes.add(new Personne(2, "Jules", "Orleans", true));
		ArrayList<Voiture> voitures = new ArrayList<>();
		voitures.add(new Voiture(1, "Ardon", 5));
		voitures.add(new Voiture(2, "Sandillon", 3));
		Covoiturage c1 = new Covoiturage(voitures, personnes);
	}

	@Test
	public void testVilleDesservieCovoiturage() throws Exception {
		Personne p1 = new Personne(1, "John", "Sandillon", true);
		Personne p2 = new Personne(2, "Jules", "Orleans", true);
		Personne p3 = new Personne(3, "Jules", "Jouy-le-potier", true);
		Voiture v1 = new Voiture(1, "Ardon", 5);
		Voiture v2 = new Voiture(2, "Sandillon", 3);
		Voiture v3 = new Voiture(3, "Machin - chose", 3);
		Covoiturage c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2, p3 })));
		assertEquals(true, c1.villeDesservie("Ardon"));
		assertEquals(true, c1.villeDesservie("Machin - chose"));
		assertEquals(false, c1.villeDesservie("Jouy"));
		assertEquals(false, c1.villeDesservie("Jouy-le-potier"));
	}

	@Test
	public void testNbPersonnesCovoiturage() throws Exception {
		Personne p1 = new Personne(1, "John", "Sandillon", true);
		Personne p2 = new Personne(2, "Jules", "Orleans", true);
		Personne p3 = new Personne(3, "Jules", "Jouy-le-potier", true);
		Personne p4 = new Personne(4, "John", "Orleans", true);
		Voiture v1 = new Voiture(1, "Ardon", 5);
		Voiture v2 = new Voiture(2, "Sandillon", 3);
		Voiture v3 = new Voiture(3, "Machin - chose", 3);
		Covoiturage c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2, p3, p4 })));
		assertEquals(2, c1.nbPersonnes("Orleans"));
		assertEquals(1, c1.nbPersonnes("Sandillon"));
	}

	@Test
	public void testCapaciteSuffisante() throws Exception {
		Personne p1 = new Personne(1, "John", "Sandillon", true);
		Personne p2 = new Personne(2, "Jules", "Orleans", true);
		Personne p3 = new Personne(3, "Jules", "Jouy-le-potier", true);
		Personne p4 = new Personne(4, "John", "Orleans", true);
		Voiture v1 = new Voiture(1, "Ardon", 5);
		Voiture v2 = new Voiture(2, "Sandillon", 3);
		Voiture v3 = new Voiture(3, "Machin - chose", 3);
		Covoiturage c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2, p3, p4 })));
		assertEquals(false, c1.capaciteSuffisante("Orleans"));
		assertEquals(true, c1.capaciteSuffisante("Sandillon"));
		assertEquals(true, c1.capaciteSuffisante("Nulle part"));
		assertEquals(true, c1.capaciteSuffisante("Ardon"));
		assertEquals(false, c1.capaciteSuffisante("Jouy-le-potier"));
	}

	@Test
	public void testGetVilles2() throws Exception {
		Personne p1 = new Personne(1, "John", "Sandillon", true);
		Personne p2 = new Personne(2, "Jules", "Orleans", true);
		Personne p3 = new Personne(3, "Jules", "Jouy-le-potier", true);
		Personne p4 = new Personne(4, "John", "Orleans", true);
		Voiture v1 = new Voiture(1, "Ardon", 5);
		Voiture v2 = new Voiture(2, "Sandillon", 3);
		Voiture v3 = new Voiture(3, "Machin - chose", 3);
		Covoiturage c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2, p3, p4 })));
		HashSet<String> s1 = new HashSet<String>();
		for (String s : c1.getVilles2()) {
			s1.add(s);
		}
		HashSet<String> s2 = new HashSet<String>();
		for (String s : new String[] { "Sandillon", "Orleans", "Jouy-le-potier", "Ardon", "Machin - chose" })
			s2.add(s);

		assertEquals(s2, s1);

		Covoiturage c2 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1 })));
		HashSet<String> s3 = new HashSet<String>();
		for (String s : c2.getVilles2()) {
			s3.add(s);
		}
		HashSet<String> s4 = new HashSet<String>();
		for (String s : new String[] { "Sandillon", "Ardon" })
			s4.add(s);

		assertEquals(s4, s3);

	}

	@Test
	public void testCapaciteSuffisanteG() throws Exception {
		Personne p1 = new Personne(1, "John", "Sandillon", true);
		Personne p2 = new Personne(2, "Jules", "Orleans", true);
		Personne p3 = new Personne(3, "Jules", "Jouy-le-potier", true);
		Personne p4 = new Personne(4, "John", "Orleans", true);
		Voiture v1 = new Voiture(1, "Ardon", 5);
		Voiture v2 = new Voiture(2, "Sandillon", 3);
		Voiture v3 = new Voiture(3, "Orleans", 1);
		Covoiturage c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2, p3, p4 })));
		Covoiturage c2 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1 })));
		assertEquals(false, c1.capaciteSuffisante());
		c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2, p4 })));
		assertEquals(false, c1.capaciteSuffisante());
		c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2 })));
		assertEquals(true, c1.capaciteSuffisante());
	}

	@Test
	public void testEstPossible() throws Exception {
		Personne p1 = new Personne(1, "John", "Orleans", false);
		Personne p2 = new Personne(2, "Jules", "Orleans", false);
		Personne p3 = new Personne(3, "Jules", "Orleans", true);
		Personne p4 = new Personne(4, "John", "Orleans", true);
		Voiture v1 = new Voiture(1, "Orleans", 1);
		Voiture v2 = new Voiture(2, "Orleans", 2);
		Voiture v3 = new Voiture(3, "Orleans", 2);
		Voiture v4 = new Voiture(3, "Orleans", 3);
		Covoiturage c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p3 })));
		assertEquals(true, c1.estPossible());
		c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1 })));
		assertEquals(false, c1.estPossible(), "Les conducteurs doivent avoir le permis");
		c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1, v2, v3 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2, p3, p4 })));
		assertEquals(true, c1.estPossible(), "Avez vous pensé à choisir les voitures les plus grandes en premier ?");
		c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v4, v1 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p2, p3, p4 })));
		assertEquals(true, c1.estPossible());
	}

	@Test
	public void testGetIdentifiant() throws Exception {
		Personne p1 = new Personne(1, "John", "Orleans", false);
		Personne p2 = new Personne(2, "Jules", "Orleans", false);
		Personne p3 = new Personne(3, "Jules", "Orleans", true);
		Personne p4 = new Personne(4, "Jean", "Orleans", true);
		Voiture v1 = new Voiture(1, "Orleans", 1);
		Covoiturage c1 = new Covoiturage(new ArrayList<>(Arrays.asList(new Voiture[] { v1 })),
				new ArrayList<>(Arrays.asList(new Personne[] { p1, p2, p3, p4 })));
		assertEquals(1, c1.getIdentifiant("John"));
		assertEquals(4, c1.getIdentifiant("Jean"));
		assertEquals(true, c1.getIdentifiant("Jules") == 2 || c1.getIdentifiant("Jules") == 3,
				"Problème getIdentifiant: devait renvoyer 2 ou 3");
		assertEquals(-1, c1.getIdentifiant("Toto"));

	}
}
