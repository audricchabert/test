/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
		
		testOuvriere.creerOuvriere(Constantes.EVEN_OUVRIERES, 2);
		// 2 nourrices => 1 ouvriere + 1 (evenement)
		assertEquals(2, testOuvriere.getNbCourantFourmi());
	}
	
	@Test
	public void testCreerOuvriere2() {
		SalleOuvriere testOuvriere2 = new SalleOuvriere();
		
		testOuvriere2.creerOuvriere(Constantes.EVEN_OUVRIERES, 4);
		// 4 nourrices => 2 ouvrieres + 1 (evenement)
		assertEquals(3, testOuvriere2.getNbCourantFourmi());
	}

}
