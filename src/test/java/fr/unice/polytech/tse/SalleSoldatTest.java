package fr.unice.polytech.tse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import salles.SalleSoldat;
import utils.Constantes;

public class SalleSoldatTest {

	@Test
	public void testCreerSoldat() {
		SalleSoldat testSoldat = new SalleSoldat();
		
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
