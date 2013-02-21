/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import plateauIndividuel.Evenements;
import salles.SalleOuvriere;
import utils.Constantes;

/**
 * @author user
 *
 */
public class SalleOuvriereTest {

	@Test
	public void testCreerOuvriere() {
		SalleOuvriere testOuvriere = new SalleOuvriere();
		testOuvriere.ajouterFourmi(2);
		testOuvriere.creerOuvriere();
		assertEquals(3, testOuvriere.getNbCourantFourmi());
	}
	
	@Test
	public void testCreerOuvriere2() {
		SalleOuvriere testOuvriere2 = new SalleOuvriere();
		testOuvriere2.ajouterFourmi(2);
		Evenements.getInstance().modifierEvenement(Constantes.EVEN_OUVRIERES, new Boolean(true));
		testOuvriere2.creerOuvriere();
		assertEquals(4, testOuvriere2.getNbCourantFourmi());
	}

}
