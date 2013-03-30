package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
