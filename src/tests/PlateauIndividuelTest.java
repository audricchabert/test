package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import plateauIndividuel.PlateauIndividuel;
import salles.SalleAtelier;
import salles.SalleLarve;
import salles.SalleOuvriere;
import salles.SalleSoldat;
import utils.Constantes;
import utils.Fonctions;

/**
 * 
 * @author mazen
 */


public class PlateauIndividuelTest {
	
	@SuppressWarnings("unused")
	@Test
	public void testGestionSalle(){
		PlateauIndividuel gs = new PlateauIndividuel();
	}
	
	@Test
	public void testNaissanceLarves(){
		PlateauIndividuel gs = new PlateauIndividuel();
		
		assertTrue(gs.naissanceLarves(1));
		
		SalleLarve sl = gs.getSalleLarve();
		
		// On s'attend à 2 (1 de base + 1 grâce a la naissance)
		assertEquals(2, sl.getNbCourantFourmi());
	}
	
	@Test
	public void testNaissanceSoldats(){
		PlateauIndividuel gs = new PlateauIndividuel();
		
		assertTrue(gs.naissanceSoldats(2));
		
		SalleSoldat sl = gs.getSalleSoldat();
		
		assertEquals(1, sl.getNbCourantFourmi()); // 2 => 1 soldat
	}
	
	
	@Test
	public void testNaissanceOuvrieres(){
		PlateauIndividuel gs = new PlateauIndividuel();
		
		assertTrue(gs.naissanceOuvrieres(2)); // 2 nourrices => 1 ouvriere
		
		SalleOuvriere sl = gs.getSalleOuvriere();
		
		// 2 ouvrieres de base + 1 créé => 3
		assertEquals(3, sl.getNbCourantFourmi()); 
	}
	
	@Test
	public void testPlacerNourriceAtelier(){
		PlateauIndividuel gs = new PlateauIndividuel();
		boolean[] tabExpected1 = {false, false, false, false};
		tabExpected1[Constantes.AMELIORER_FOURMILIERE] = true; 
		
		assertTrue(gs.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE));
		SalleAtelier sa = gs.getSalleAtelier();
		
		// On vérifie qu'on a les meme evenements qui valent true
		assertTrue(Fonctions.arrayBoolEquals(sa.getEvenements(), tabExpected1));
	}
}
