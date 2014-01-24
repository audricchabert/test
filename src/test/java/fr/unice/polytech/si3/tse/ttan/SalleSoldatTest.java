package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Evenements;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionNourrices;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleSoldat;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

public class SalleSoldatTest {

	@Test
	public void testAjouterFourmi() {
		SalleSoldat testSoldat = new SalleSoldat();
		assertTrue(testSoldat.ajouterFourmi());
		assertEquals(testSoldat.getNbCourantFourmi(), 1);
	}
	
	@Test
	public void testAjouterFourmi2() {
		SalleSoldat testSoldat = new SalleSoldat();
		assertTrue(testSoldat.ajouterFourmi(3));
		assertEquals(testSoldat.getNbCourantFourmi(), 3);
		assertFalse(testSoldat.ajouterFourmi(-2));
	}
	
	@Test
	public void testSupprimerFourmi() {
		SalleSoldat testSoldat = new SalleSoldat();
		assertFalse(testSoldat.supprimerFourmi());
		testSoldat.ajouterFourmi(3);
		testSoldat.supprimerFourmi();
		assertEquals(testSoldat.getNbCourantFourmi(), 2);
	}
	
	@Test
	public void testSupprimerFourmi2() {
		SalleSoldat testSoldat = new SalleSoldat();
		assertFalse(testSoldat.supprimerFourmi(-2));
		assertFalse(testSoldat.supprimerFourmi(3));
		testSoldat.ajouterFourmi(5);
		testSoldat.supprimerFourmi(2);
		assertEquals(testSoldat.getNbCourantFourmi(), 3);
	}
	
	@Test
	public void testNaissanceSoldats() {
		SalleSoldat testSoldat = new SalleSoldat();
		SalleNourrice sn = new SalleNourrice();
		
		// On set l'evenement
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_DEPLACEMENT);
		
		sn.ajouterFourmi(3);
		
		testSoldat.naissanceSoldats(2, sn);
		
		assertEquals(1, testSoldat.getNbCourantFourmi());
		assertEquals(1, sn.getNbCourantFourmi());
		
		
		// Lance une ExceptionNourrice
		try {
			testSoldat.naissanceSoldats(2, sn);
			fail("ExceptionNourrices non levee.");
		}
		catch (ExceptionNourrices en) {
			// Do nothing
		}
		
		try {
		// Lance une IllegalArgumentException
			testSoldat.naissanceSoldats(0, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
			// Do Nothing
		}
		
		try {
		// Lance une IllegalArgumentException
			testSoldat.naissanceSoldats(1, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
			// Do Nothing
		}

		try {
		// Lance une IllegalArgumentException
			testSoldat.naissanceSoldats(5, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCreerSoldat() {
		SalleSoldat testSoldat = new SalleSoldat();
		
		// Ne fais rien quand larves inferieures a 1.
		testSoldat.creerSoldat(Constantes.EVEN_LARVE, 0);
		assertEquals(0, testSoldat.getNbCourantFourmi());
		
		testSoldat.creerSoldat(Constantes.EVEN_SOLDAT, 3);
		assertEquals(3, testSoldat.getNbCourantFourmi());
	}
	
	@Test
	public void testCreerSoldat2() {
		SalleSoldat testSoldat2 = new SalleSoldat();
		
		testSoldat2.creerSoldat(Constantes.EVEN_SOLDAT, 2);
		assertEquals(2, testSoldat2.getNbCourantFourmi());
	}

}
