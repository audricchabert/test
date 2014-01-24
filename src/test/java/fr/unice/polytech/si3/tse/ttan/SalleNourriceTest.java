/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice;

/**
 * @author alavail
 *
 */
public class SalleNourriceTest {

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice#ajouterFourmi()}.
	 */
	@Test
	public void testAjouterFourmi() {
		SalleNourrice testNourrice = new SalleNourrice();
		assertTrue(testNourrice.ajouterFourmi());
		assertEquals(testNourrice.getNbCourantFourmi(), 1);
	}

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice#ajouterFourmi(int)}.
	 */
	@Test
	public void testAjouterFourmiInt() {
		SalleNourrice testNourrice = new SalleNourrice();
		assertTrue(testNourrice.ajouterFourmi(3));
		assertEquals(testNourrice.getNbCourantFourmi(), 3);
		assertFalse(testNourrice.ajouterFourmi(-2));
	}

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice#supprimerFourmi()}.
	 */
	@Test
	public void testSupprimerFourmi() {
		SalleNourrice testNourrice = new SalleNourrice();
		assertFalse(testNourrice.supprimerFourmi());
		testNourrice.ajouterFourmi(3);
		testNourrice.supprimerFourmi();
		assertEquals(testNourrice.getNbCourantFourmi(), 2);
	}

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice#supprimerFourmi(int)}.
	 */
	@Test
	public void testSupprimerFourmiInt() {
		SalleNourrice testNourrice = new SalleNourrice();
		assertFalse(testNourrice.supprimerFourmi(-2));
		assertFalse(testNourrice.supprimerFourmi(3));
		testNourrice.ajouterFourmi(5);
		testNourrice.supprimerFourmi(2);
		assertEquals(testNourrice.getNbCourantFourmi(), 3);
	}

}
