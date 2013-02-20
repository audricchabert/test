package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import plateauIndividuel.Evenements;
import salles.SalleLarve;
import utils.Constantes;

public class SalleLarveTest {

	@Test
	public void testCreerLarve() {
		SalleLarve testLarve = new SalleLarve();
		testLarve.ajouterFourmi(2);
		testLarve.creerLarve();
		assertEquals(5, testLarve.getNbCourantFourmi());
	}
	
	@Test
	public void testCreerLarve2() {
		SalleLarve testLarve2 = new SalleLarve();
		testLarve2.ajouterFourmi(2);
		Evenements.getInstance().modifierEvenement(Constantes.EVEN_LARVE, new Boolean(true));
		testLarve2.creerLarve();
		assertEquals(7, testLarve2.getNbCourantFourmi());
	}

}
