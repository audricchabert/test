/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Evenements;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionNourrices;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleOuvriere;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

/**
 * @author user
 *
 */
public class SalleOuvriereTest {

	@Test
	public void testAjouterFourmi() {
		SalleOuvriere testOuvriere = new SalleOuvriere();
		assertTrue(testOuvriere.ajouterFourmi());
		assertEquals(testOuvriere.getNbCourantFourmi(), 1);
	}
	
	@Test
	public void testAjouterFourmi2() {
		SalleOuvriere testOuvriere = new SalleOuvriere();
		assertTrue(testOuvriere.ajouterFourmi(3));
		assertEquals(testOuvriere.getNbCourantFourmi(), 3);
		assertFalse(testOuvriere.ajouterFourmi(-2));
	}
	
	@Test
	public void testSupprimerFourmi() {
		SalleOuvriere testOuvriere = new SalleOuvriere();
		assertFalse(testOuvriere.supprimerFourmi());
		testOuvriere.ajouterFourmi(3);
		testOuvriere.supprimerFourmi();
		assertEquals(testOuvriere.getNbCourantFourmi(), 2);
	}
	
	@Test
	public void testSupprimerFourmi2() {
		SalleOuvriere testOuvriere = new SalleOuvriere();
		assertFalse(testOuvriere.supprimerFourmi(-2));
		assertFalse(testOuvriere.supprimerFourmi(3));
		testOuvriere.ajouterFourmi(5);
		testOuvriere.supprimerFourmi(2);
		assertEquals(testOuvriere.getNbCourantFourmi(), 3);
	}
	
	@Test
	public void testNaissanceOuvriere() {
		SalleOuvriere testOuvriere = new SalleOuvriere();
		SalleNourrice sn = new SalleNourrice();
		
		// On set l'evenement
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_DEPLACEMENT);
		
		sn.ajouterFourmi(3);
		
		testOuvriere.naissanceOuvrieres(2, sn);
		
		assertEquals(1, testOuvriere.getNbCourantFourmi());
		assertEquals(1, sn.getNbCourantFourmi());
		
		
		// Lance une ExceptionNourrice
		try {
			testOuvriere.naissanceOuvrieres(2, sn);
			fail("ExceptionNourrices non levee.");
		}
		catch (ExceptionNourrices en) {
		}
		
		try {
		// Lance une IllegalArgumentException
		testOuvriere.naissanceOuvrieres(0, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
			// Do Nothing
		}
		
		try {
		// Lance une IllegalArgumentException
		testOuvriere.naissanceOuvrieres(1, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
			// Do Nothing
		}

		try {
		// Lance une IllegalArgumentException
		testOuvriere.naissanceOuvrieres(5, sn);
		fail("IllegalArgumentException non levee.");
		}
		catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCreerOuvriere() {
		SalleOuvriere testOuvriere = new SalleOuvriere();
		
		testOuvriere.creerOuvriere(Constantes.EVEN_OUVRIERES, 2);
		// 2 nourrices => 1 ouvriere + 1 (evenement)
		assertEquals(2, testOuvriere.getNbCourantFourmi());
	}
	
	@Test
	public void testCreerOuvriere2() {
		SalleOuvriere testOuvriere2 = new SalleOuvriere();
		
		// Ne fais rien quand larves inferieures a 1.
		testOuvriere2.creerOuvriere(Constantes.EVEN_LARVE, 0);
		assertEquals(0, testOuvriere2.getNbCourantFourmi());
		
		testOuvriere2.creerOuvriere(Constantes.EVEN_OUVRIERES, 4);
		// 4 nourrices => 2 ouvrieres + 1 (evenement)
		assertEquals(3, testOuvriere2.getNbCourantFourmi());
	}

}
