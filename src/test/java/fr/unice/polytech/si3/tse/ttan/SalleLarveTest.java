package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Evenements;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionNourrices;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleLarve;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

public class SalleLarveTest {
	
	@Test
	public void testAjouterFourmi() {
		SalleLarve testLarve = new SalleLarve();
		assertTrue(testLarve.ajouterFourmi());
		assertEquals(testLarve.getNbCourantFourmi(), 1);
	}
	
	@Test
	public void testAjouterFourmi2() {
		SalleLarve testLarve = new SalleLarve();
		assertTrue(testLarve.ajouterFourmi(3));
		assertEquals(testLarve.getNbCourantFourmi(), 3);
		assertFalse(testLarve.ajouterFourmi(-2));
	}
	
	@Test
	public void testSupprimerFourmi() {
		SalleLarve testLarve = new SalleLarve();
		assertFalse(testLarve.supprimerFourmi());
		testLarve.ajouterFourmi(3);
		testLarve.supprimerFourmi();
		assertEquals(testLarve.getNbCourantFourmi(), 2);
	}
	
	@Test
	public void testSupprimerFourmi2() {
		SalleLarve testLarve = new SalleLarve();
		assertFalse(testLarve.supprimerFourmi(-2));
		assertFalse(testLarve.supprimerFourmi(3));
		testLarve.ajouterFourmi(5);
		testLarve.supprimerFourmi(2);
		assertEquals(testLarve.getNbCourantFourmi(), 3);
	}
	
	@Test
	public void testNaissanceLarves() {
		SalleLarve testLarve = new SalleLarve();
		SalleNourrice sn = new SalleNourrice();
		
		// On set l'evenement
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_DEPLACEMENT);
		
		sn.ajouterFourmi(3);
		
		testLarve.naissanceLarves(2, sn);
		
		assertEquals(3, testLarve.getNbCourantFourmi());
		assertEquals(1, sn.getNbCourantFourmi());
		
		
		// Lance une ExceptionNourrices
		try {
			testLarve.naissanceLarves(2, sn);
			fail("ExceptionNourrices non levee.");
		}
		catch (ExceptionNourrices en) {
			// Do nothing
		}
		
		try {
		// Lance une IllegalArgumentException
			testLarve.naissanceLarves(-1, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
			// Do Nothing
		}
		
		try {
		// Lance une IllegalArgumentException
			testLarve.naissanceLarves(0, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
			// Do Nothing
		}

		try {
		// Lance une IllegalArgumentException
			testLarve.naissanceLarves(5, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testCreerLarve() {
		SalleLarve testLarve = new SalleLarve();
		testLarve.creerLarve(Constantes.EVEN_LARVE, 1);
		assertEquals(3, testLarve.getNbCourantFourmi());
		
		testLarve.creerLarve(Constantes.EVEN_DEPLACEMENT, 3);
		assertEquals(8, testLarve.getNbCourantFourmi());
	}
	
	@Test
	public void testCreerLarve2() {
		SalleLarve testLarve2 = new SalleLarve();
		
		testLarve2.creerLarve(Constantes.EVEN_LARVE, 2);
		assertEquals(5, testLarve2.getNbCourantFourmi());
		
		// Test si inferieur a zero
		testLarve2.creerLarve(Constantes.EVEN_PHEROMONE, -2);
		assertEquals(5, testLarve2.getNbCourantFourmi());
	}

}
