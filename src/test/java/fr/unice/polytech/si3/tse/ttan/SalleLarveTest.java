package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.salles.SalleLarve;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

public class SalleLarveTest {

	@Test
	public void testCreerLarve() {
		SalleLarve testLarve = new SalleLarve();
		testLarve.creerLarve(Constantes.EVEN_LARVE, 1);
		assertEquals(3, testLarve.getNbCourantFourmi());
	}
	
	@Test
	public void testCreerLarve2() {
		SalleLarve testLarve2 = new SalleLarve();
		
		testLarve2.creerLarve(Constantes.EVEN_LARVE, 2);
		assertEquals(5, testLarve2.getNbCourantFourmi());
	}

}
