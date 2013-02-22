package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Constantes;
import plateauIndividuel.Fourmiliere;

public class FourmiliereTest 
{
	/**
	 * Test des constructeurs de fourmiliere
	 */
	@Test
	public void testConstructeurs()
	{
		boolean[] niveauFourmiliereAttenduUn={false,false,false,true};
		boolean[] niveauFourmiliereAttenduDeux={false,false,false,false};
		int niveauMaximumCourantAttendu=2;
		Fourmiliere un = new Fourmiliere(niveauFourmiliereAttenduUn,niveauMaximumCourantAttendu);
		Fourmiliere deux = new Fourmiliere();
		
		assertEquals(un.getNiveauMaximumCourant(), niveauMaximumCourantAttendu);
		assertEquals(un.getNiveauxFourmiliere(),niveauFourmiliereAttenduUn);
		
		assertEquals(deux.getNiveauMaximumCourant(),1);
		assertEquals(deux.getNiveauxFourmiliere(),niveauFourmiliereAttenduDeux);
		
	}
	
	/**
	 * Test des accesseurs en lecture et en écriture
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
}
