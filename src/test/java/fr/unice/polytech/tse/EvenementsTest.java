/**
 * 
 */
package fr.unice.polytech.tse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.junit.Test;

import plateauIndividuel.Evenements;
import salles.SalleLarve;
import utils.Constantes;

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
	 * Test method for {@link plateauIndividuel.Evenements#setEvenementActif(java.lang.String, boolean)}.
	 */
	@Test
	public void testSetEvenementActif() {
		assertFalse(Evenements.getInstance().getListeEvenements().get(Constantes.EVEN_PV));
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_PV);
		assertTrue(Evenements.getInstance().getListeEvenements().get(Constantes.EVEN_PV));
		
	}
	
	/**
	 * Test method for {@link plateauIndividuel.Evenements#getEvenementCourant()}.
	 */
	@Test
	public void testGetEvenementCourant() {
		assertEquals(Constantes.EVEN_PV, Evenements.getInstance().getEvenementCourant());
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_LARVE);
		assertEquals(Constantes.EVEN_LARVE, Evenements.getInstance().getEvenementCourant());
		
	}
	
	@Test
	public void testDecallerEvenement() {
		
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_RECOLTE);
		
		SalleLarve sl = new SalleLarve();
		
		// On ajoute 1 larve pour realiser le test
		sl.ajouterFourmi();
		
		// DROITE
		assertTrue(Evenements.getInstance().decallerEvenement(1, Constantes.DROITE, sl));
		assertEquals(Constantes.EVEN_DEPLACEMENT, Evenements.getInstance().getEvenementCourant());
		assertEquals(0, sl.getNbCourantFourmi());
		
		sl.ajouterFourmi(3);
		
		// DROITE + 2
		assertTrue(Evenements.getInstance().decallerEvenement(2, Constantes.DROITE, sl));
		assertEquals(Constantes.EVEN_PHEROMONE, Evenements.getInstance().getEvenementCourant());
		assertEquals(1, sl.getNbCourantFourmi());
		
		sl.ajouterFourmi(2);
		
		// GAUCHE
		assertTrue(Evenements.getInstance().decallerEvenement(1, Constantes.GAUCHE, sl));
		assertEquals(Constantes.EVEN_SOLDAT, Evenements.getInstance().getEvenementCourant());
		assertEquals(2, sl.getNbCourantFourmi());
		
		// Retourne une erreur
		assertFalse(Evenements.getInstance().decallerEvenement(3, Constantes.GAUCHE, sl));
	}
	

}
