package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import salles.SalleStock;
import utils.Constantes;

public class SalleStockTest {

	@Test
	public void testAjouterRessource() {
		SalleStock testStock = new SalleStock();
		assertEquals(0, testStock.getNbNourriture());
		assertEquals(0, testStock.getNbPierre());
		assertEquals(0, testStock.getNbTerre());
		
		assertFalse(testStock.ajouterRessource("FALSE", 3));
		assertFalse(testStock.ajouterRessource(Constantes.RESS_NOURRITURE, -4));
		
		testStock.ajouterRessource(Constantes.RESS_NOURRITURE, 3);
		testStock.ajouterRessource(Constantes.RESS_PIERRE, 6);
		testStock.ajouterRessource(Constantes.RESS_TERRE, 1);
		
		assertEquals(3, testStock.getNbNourriture());
		assertEquals(6, testStock.getNbPierre());
		assertEquals(1, testStock.getNbTerre());
	}

	@Test
	public void testSupprimerRessource() {		
		SalleStock testStock2 = new SalleStock();
		
		testStock2.ajouterRessource(Constantes.RESS_NOURRITURE, 3);
		testStock2.ajouterRessource(Constantes.RESS_PIERRE, 6);
		testStock2.ajouterRessource(Constantes.RESS_TERRE, 1);
		
		assertFalse(testStock2.supprimerRessource("FALSE", 1));
		assertFalse(testStock2.supprimerRessource(Constantes.RESS_NOURRITURE, -8));
		
		testStock2.supprimerRessource(Constantes.RESS_NOURRITURE, 2);
		testStock2.supprimerRessource(Constantes.RESS_PIERRE, 3);
		testStock2.supprimerRessource(Constantes.RESS_TERRE, 1);
		
		assertEquals(1, testStock2.getNbNourriture());
		assertEquals(3, testStock2.getNbPierre());
		assertEquals(0, testStock2.getNbTerre());
		
		assertFalse(testStock2.supprimerRessource(Constantes.RESS_PIERRE, 5));
	}

}
