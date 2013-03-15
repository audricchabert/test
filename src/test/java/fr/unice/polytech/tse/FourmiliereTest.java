package fr.unice.polytech.tse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import plateauIndividuel.Evenements;
import plateauIndividuel.Fourmiliere;
import salles.SalleAtelier;
import salles.SalleLarve;
import salles.SalleOuvriere;
import salles.SalleStock;
import utils.Constantes;
import utils.Fonctions;

public class FourmiliereTest 
{
	/**
	 * Test des constructeurs de fourmiliere
	 */
	@Test
	public void testConstructeurs()
	{
		boolean[] niveauFourmiliereAttenduUn={true,true,true,true};
		boolean[] niveauFourmiliereAttenduDeux={false,false,false,false};
		int niveauMaximumCourantAttendu=2;
		Fourmiliere un = new Fourmiliere(niveauFourmiliereAttenduUn,niveauMaximumCourantAttendu);
		Fourmiliere deux = new Fourmiliere();
		
		assertEquals(un.getNiveauMaximumCourant(), niveauMaximumCourantAttendu);
		assertEquals(un.getNiveauxFourmiliere(),niveauFourmiliereAttenduUn);
		
		assertEquals(deux.getNiveauMaximumCourant(), 0); // Niveau 0 de base
		assertTrue( Fonctions.arrayBoolEquals(deux.getNiveauxFourmiliere(),niveauFourmiliereAttenduDeux));
		
	}
	
	/**
	 * Test des accesseurs en lecture et en �criture
	 */
	@Test
	public void testAccesseursNiveauMaximumCourant()
	{
		boolean[] niveauxFourmiliere={false,false,false,false};
		int niveauMaximumCourantAttendu=3;
		Fourmiliere fourmiliereTest = new Fourmiliere(niveauxFourmiliere,niveauMaximumCourantAttendu);
		
		assertEquals(niveauMaximumCourantAttendu,fourmiliereTest.getNiveauMaximumCourant());
	}
	
	@Test
	public void testAccesseursNiveauxFourmiliere()
	{
		boolean[] niveauxFourmiliere={true,true,true,false};
		int niveauMaximumCourantAttendu=3;
		Fourmiliere fourmiliereTest = new Fourmiliere(niveauxFourmiliere,niveauMaximumCourantAttendu);
		
		assertEquals(niveauxFourmiliere,fourmiliereTest.getNiveauxFourmiliere());
	}
	
	@Test
	public void testGenererRessources() {
		
		Evenements.getInstance().setEvenementActif(Constantes.EVEN_PV);
		
		boolean[] fourmisDansNiveauxFourmiliere = {true, true, true, true};
		
		Fourmiliere f = new Fourmiliere(fourmisDansNiveauxFourmiliere, 2);
		SalleStock ss = new SalleStock();
		SalleLarve sl = new SalleLarve();
		
		sl.ajouterFourmi(3);
		ss.ajouterRessource(Constantes.RESS_NOURRITURE, 4);
		ss.ajouterRessource(Constantes.RESS_PIERRE, 1);
		ss.ajouterRessource(Constantes.RESS_TERRE, 2);

		f.genererRessources(sl, ss);
		
		assertEquals(5, ss.getNbNourriture());
		assertEquals(2, ss.getNbPierre());
		assertEquals(3, ss.getNbTerre());
		assertEquals(4, sl.getNbCourantFourmi());	
	}
	
	@Test
	public void testAmeliorerFourmiliere() {
		
		// Initialement niveau 0
		Fourmiliere f = new Fourmiliere();
		SalleAtelier sa = new SalleAtelier();
		
		// Il faut d'abord placer une ouvriere sur l'event
		sa.ajouteNourrice(Constantes.AMELIORER_FOURMILIERE);
		
		f.ameliorerFourmiliere(sa);
		
		// Devrait etre l'etage 1
		assertEquals(1, f.getNiveauMaximumCourant());
		
		// Ensuite, on verifie que la nourrice a ete enleve de l'atelier
		assertFalse(sa.getEvenements()[Constantes.AMELIORER_FOURMILIERE]);
	}
	
	@Test
	public void testPlacerOuvriereFourmiliere() {
		
		Fourmiliere f = new Fourmiliere();
		SalleOuvriere so = new SalleOuvriere();
		so.ajouterFourmi(3);
		
		// Une fourmi dans le premier
		boolean[] tabVoulu = {true, false, false, false};
		
		assertTrue(f.placerOuvriere(0, so));
		
		// On devrait avoir une fourmi dans le premier etage seulement
		assertTrue(Fonctions.arrayBoolEquals(f.getNiveauxFourmiliere(), tabVoulu));
	}
}
