/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Joueur;

/**
 * @author user
 *
 */
public class JoueurTest {

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Joueur#Joueur(java.lang.String)}.
	 */
	@Test
	public void testJoueur() {
		Joueur j = new Joueur("PseudoTest");
		assertEquals(j.getClass().getName(), Joueur.class.getName());
	}

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Joueur#getPlateauIndividuel()}.
	 */
	@Test
	public void testGetPlateauIndividuel() {
		Joueur j = new Joueur("PseudoTest");
		assertNotNull(j.getPlateauIndividuel());
	}

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Joueur#getPseudo()}.
	 */
	@Test
	public void testGetPseudo() {
		Joueur j = new Joueur("PseudoTest");
		assertEquals(j.getPseudo(), "PseudoTest");
	}

}
