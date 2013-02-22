package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Fonctions;
import plateauIndividuel.Fourmiliere;

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
	public void testGenererRessources(){
		Fourmiliere f = new Fourmiliere();
		
		
		// Niveau 0
		int[] niveau1 = {1,0,0,0}; // 1 larve
		boolean[] niv1 =  {true, false, false, false};
		f.setNiveauxFourmiliere(niv1);
		assertArrayEquals(niveau1, f.genererRessources());
		
		// Niveau 1
		int[] niveau2 = {1,1,0,0}; // 1 larve et 1 nourriture
		boolean[] niv2 =  {true, true, false, false};
		f.setNiveauxFourmiliere(niv2);
		assertArrayEquals(niveau2, f.genererRessources());
		
		// Nivau 2
		int[] niveau3 = {1,1,1,1}; // 1 de chaque 
		boolean[] niv3 =  {true, true, true, false};
		f.setNiveauxFourmiliere(niv3);
		assertArrayEquals(niveau3, f.genererRessources());
	}
}
