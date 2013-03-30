package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleSoldat;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

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
