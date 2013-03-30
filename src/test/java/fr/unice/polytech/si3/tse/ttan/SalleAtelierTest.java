package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionNourrices;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleAtelier;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;
import fr.unice.polytech.si3.tse.ttan.utils.Fonctions;

public class SalleAtelierTest {
	
	@Test
	public void ajouteNourriceTest() {
		
		// Resultat attendu
		boolean[] tabExpected = {false, false, false, false};
		tabExpected[Constantes.AMELIORER_FOURMILIERE] = true;
		
		// Resultat 
		SalleAtelier s = new SalleAtelier();
		s.ajouteNourrice(Constantes.AMELIORER_FOURMILIERE);
		
		assertTrue(Fonctions.arrayBoolEquals(tabExpected, s.getEvenements()));
		
		tabExpected[Constantes.NOUVELLE_GALERIE] = true;
		s.ajouteNourrice(Constantes.NOUVELLE_GALERIE);
		assertTrue(Fonctions.arrayBoolEquals(tabExpected, s.getEvenements()));
		
		tabExpected[Constantes.CREER_NOURRICE] = true;
		s.ajouteNourrice(Constantes.CREER_NOURRICE);
		assertTrue(Fonctions.arrayBoolEquals(tabExpected, s.getEvenements()));
		
		tabExpected[Constantes.OBJECTIF] = true;
		s.ajouteNourrice(Constantes.OBJECTIF);
		assertTrue(Fonctions.arrayBoolEquals(tabExpected, s.getEvenements()));
		
		try {
			// provoque un IllegalArgumentException
			s.ajouteNourrice(8);
			fail("ExceptionNourrice non recue");
		}
		catch (IllegalArgumentException iae) {
			// Do nothing
		}
		
		try {
			// Provoque une ExceptionNourrice
			s.ajouteNourrice(Constantes.AMELIORER_FOURMILIERE);
			fail("ExceptionNourrice non recue");
		}
		catch (ExceptionNourrices en) {
			// Do nothing
		}
	}

	@Test
	public void viderTest() {
		
		// Resultat attendu
		boolean tabExpected[] = {false, false, false, false};
		
		// Res 
		SalleAtelier s = new SalleAtelier();
		s.ajouteNourrice(Constantes.AMELIORER_FOURMILIERE);
		s.vider();
		
		assertTrue(Fonctions.arrayBoolEquals(tabExpected, s.getEvenements()));
	}
	
	@Test
	public void testajouterFourmi() {
		SalleAtelier testAtelier = new SalleAtelier();
		assertFalse(testAtelier.ajouterFourmi());
	}
	
	@Test
	public void testajouterFourmiInt() {
		SalleAtelier testAtelier = new SalleAtelier();
		assertFalse(testAtelier.ajouterFourmi(5));
	}
	
	@Test
	public void testSupprimerFourmi() {
		SalleAtelier testAtelier = new SalleAtelier();
		assertFalse(testAtelier.supprimerFourmi());
	}
	
	@Test
	public void testSupprimerFourmiInt() {
		SalleAtelier testAtelier = new SalleAtelier();
		assertFalse(testAtelier.supprimerFourmi(5));
	}
	
}
