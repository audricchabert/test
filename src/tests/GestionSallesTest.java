package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import plateauIndividuel.GestionSalles;
import salles.SalleLarve;
import salles.SalleOuvriere;
import salles.SalleSoldat;
import utils.Constantes;

/**
 * 
 * @author mazen
 */


public class GestionSallesTest {
	
	@Test
	public void testGestionSalle(){
		GestionSalles gs = new GestionSalles();
		
		assertEquals(0, gs.getIndiceEvnt());
	}
	
	@Test
	public void testNaissanceLarves(){
		GestionSalles gs = new GestionSalles();
		
		assertTrue(gs.naissanceLarves(1));
		
		SalleLarve sl = gs.getSalleLarve();
		
		assertEquals(1, sl.getNbCourantFourmi());
	}
	
	@Test
	public void testNaissanceSoldats(){
		GestionSalles gs = new GestionSalles();
		
		assertTrue(gs.naissanceSoldats(2));
		
		SalleSoldat sl = gs.getSalleSoldat();
		
		assertEquals(1, sl.getNbCourantFourmi()); // 2 => 1 soldat
	}
	
	
	@Test
	public void testNaissanceOuvrieres(){
		GestionSalles gs = new GestionSalles();
		
		assertTrue(gs.naissanceOuvrieres(2));
		
		SalleOuvriere sl = gs.getSalleOuvriere();
		
		assertEquals(1, sl.getNbCourantFourmi()); // 2 => 1 soldat
	}
	
	@Test
	public void testDecallerEvenement(){
		GestionSalles gs = new GestionSalles();
		
		// DROITE
		assertTrue(gs.decallerEvenement(1, Constantes.DROITE));
		
		assertEquals(Constantes.LISTE_EVENEMENTS[1], Constantes.LISTE_EVENEMENTS[gs.getIndiceEvnt()] );
		
		// GAUCHE
		assertTrue(gs.decallerEvenement(1, Constantes.GAUCHE));
		
		assertEquals(Constantes.LISTE_EVENEMENTS[0], Constantes.LISTE_EVENEMENTS[gs.getIndiceEvnt()] );
	}
	
}
