package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import salles.SalleAtelier;
import utils.Constantes;
import utils.Fonctions;

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
	
}
