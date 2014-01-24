package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Evenements;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionNourrices;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.PlateauIndividuel;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleAtelier;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleLarve;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleOuvriere;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleSoldat;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;
import fr.unice.polytech.si3.tse.ttan.utils.Fonctions;

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
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_NIVEAU);

		assertTrue(gs.naissanceLarves(1));

		SalleLarve sl = gs.getSalleLarve();

		// On s'attend à 2 (1 de base + 1 grâce a la naissance)
		assertEquals(2, sl.getNbCourantFourmi());
	}

	@Test
	public void testNaissanceSoldats(){
		PlateauIndividuel gs = new PlateauIndividuel();
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_NIVEAU);

		assertTrue(gs.naissanceSoldats(2));

		SalleSoldat sl = gs.getSalleSoldat();

		assertEquals(1, sl.getNbCourantFourmi()); // 2 => 1 soldat
	}


	@Test
	public void testNaissanceOuvrieres(){
		PlateauIndividuel gs = new PlateauIndividuel();
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_NIVEAU);

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

		gs.getSalleNourrice().supprimerFourmi(2);
		try {
			gs.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE);
		}
		catch (ExceptionNourrices en) {
			// Do nothing
		}
		
		gs.getSalleNourrice().ajouterFourmi(2);
		assertFalse(gs.placerNourriceAtelier(8));
		assertFalse(gs.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE));
	}
	
	@Test
	public void testGenererRessourceFourmiliere() {
		PlateauIndividuel pi = new PlateauIndividuel();
		assertTrue(pi.genereRessourceFourmiliere());
	}
	
	@Test
	public void testAmeliorerFourmiliere() {
		PlateauIndividuel pi = new PlateauIndividuel();
		assertFalse(pi.ameliorerFourmiliere());
	}
	
	@Test
	public void testDecallerEvenement() {
		PlateauIndividuel pi = new PlateauIndividuel();
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_PHEROMONE);
		assertTrue(pi.decallerEvenement(1, Constantes.GAUCHE));
	}
	
	@Test
	public void testPlacerOuvriereFourmiliere() {
		PlateauIndividuel pi = new PlateauIndividuel();
		assertTrue(pi.placerOuvriereFourmiliere(0));
	}

	@Test
	public void testGetSalleStock() {
		PlateauIndividuel pi = new PlateauIndividuel();
		assertNotNull(pi.getSalleStock());
	}

	@Test
	public void testGetFourmiliere() {
		PlateauIndividuel pi = new PlateauIndividuel();
		assertNotNull(pi.getFourmiliere());
	}

	@Test
	public void testGetNourrices() {
		PlateauIndividuel pi = new PlateauIndividuel();
		assertNotNull(pi.getNourrices());
	}

	@Test
	public void testGetOuvrieres() {
		PlateauIndividuel pi = new PlateauIndividuel();
		assertNotNull(pi.getOuvrieres());
	}

	@Test
	public void testGetLarves() {
		PlateauIndividuel pi = new PlateauIndividuel();
		assertNotNull(pi.getLarves());
	}
}
