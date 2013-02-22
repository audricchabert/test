/**
 * 
 */
package tests;

import static org.junit.Assert.*;
import utils.Constantes;

import java.util.LinkedHashMap;

import org.junit.Test;

import plateauIndividuel.Evenements;

/**
 * @author Antoine Lavail
 *
 */
public class EvenementsTest {

	/**
	 * Test method for {@link plateauIndividuel.Evenements#getListeEvenements()}.
	 */
	@Test
	public void testGetListeEvenemenets() {
		LinkedHashMap<String, Boolean> tmp = Evenements.getInstance().getListeEvenements();
		assertEquals(tmp.containsKey(Constantes.EVEN_LARVE), Evenements.getInstance().getListeEvenements().containsKey(Constantes.EVEN_LARVE));
	}

	/**
	 * Test method for {@link plateauIndividuel.Evenements#modifierEvenement(java.lang.String, boolean)}.
	 */
	@Test
	public void testModifierEvenement() {
		assertFalse(Evenements.getInstance().getListeEvenements().get(Constantes.EVEN_PV));
		Evenements.getInstance().modifierEvenement(Constantes.EVEN_PV, new Boolean(true));
		assertTrue(Evenements.getInstance().getListeEvenements().get(Constantes.EVEN_PV));
		
	}

}
