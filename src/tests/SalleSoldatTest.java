package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import plateauIndividuel.Evenements;
import salles.SalleSoldat;
import utils.Constantes;

public class SalleSoldatTest {

	@Test
	public void testCreerSoldat() {
		SalleSoldat testSoldat = new SalleSoldat();
		testSoldat.ajouterFourmi(3);
		testSoldat.creerSoldat(Constantes.EVEN_SOLDAT);
		assertEquals(5, testSoldat.getNbCourantFourmi());
	}
	
	@Test
	public void testCreerSoldat2() {
		SalleSoldat testSoldat2 = new SalleSoldat();
		testSoldat2.ajouterFourmi(3);
		Evenements.getInstance().modifierEvenement(Constantes.EVEN_SOLDAT, new Boolean(true));
		testSoldat2.creerSoldat(Constantes.EVEN_SOLDAT);
		assertEquals(6, testSoldat2.getNbCourantFourmi());
	}

}
