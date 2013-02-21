/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import salles.Salle;

/**
 * @author user
 *
 */
public class SalleTest {

	/**
	 * Test method for {@link salles.Salle#Salle()}.
	 */
	@Test
	public void testSalle() {
		Salle test = new Salle();
		assertEquals(0, test.getNbCourantFourmi());
	}

	/**
	 * Test method for {@link salles.Salle#ajouterFourmi(int)}.
	 */
	@Test
	public void testAjouterFourmiInt() {
		Salle test = new Salle();
		assertFalse(test.ajouterFourmi(-1));
		assertTrue(test.ajouterFourmi(2));
		assertEquals(2, test.getNbCourantFourmi());
	}

	/**
	 * Test method for {@link salles.Salle#supprimerFourmi(int)}.
	 */
	@Test
	public void testSupprimerFourmiInt() {
		Salle test = new Salle();
		assertFalse(test.ajouterFourmi(-1));
		assertTrue(test.ajouterFourmi(2));
		assertTrue(test.supprimerFourmi(1));
		assertEquals(1, test.getNbCourantFourmi());
	}

}
