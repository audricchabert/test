package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import plateauIndividuel.Fourmiliere;
import plateauIndividuel.GestionSalles;
import salles.SalleAtelier;
import salles.SalleLarve;
import salles.SalleOuvriere;
import salles.SalleSoldat;
import utils.Constantes;
import utils.Fonctions;

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
		
		// On s'attend à 2 (1 de base + 1 grâce a la naissance)
		assertEquals(2, sl.getNbCourantFourmi());
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
		
		assertTrue(gs.naissanceOuvrieres(2)); // 2 nourrices => 1 ouvriere
		
		SalleOuvriere sl = gs.getSalleOuvriere();
		
		// 2 ouvrieres de base + 1 créé => 3
		assertEquals(3, sl.getNbCourantFourmi()); 
	}
	
	@Test
	public void testDecallerEvenement(){
		GestionSalles gs = new GestionSalles();
		gs.getSalleLarve().ajouterFourmi(); // On ajoute 1 larve pour réaliser le test
		
		// DROITE
		assertTrue(gs.decallerEvenement(1, Constantes.DROITE));
		
		assertEquals(Constantes.LISTE_EVENEMENTS[1], Constantes.LISTE_EVENEMENTS[gs.getIndiceEvnt()] );
		
		// GAUCHE
		assertTrue(gs.decallerEvenement(1, Constantes.GAUCHE));
		
		assertEquals(Constantes.LISTE_EVENEMENTS[0], Constantes.LISTE_EVENEMENTS[gs.getIndiceEvnt()] );
	}
	
	@Test
	public void testGenereRessourceFourmiliere(){
		GestionSalles gs = new GestionSalles();
		int[] tabExpected1 = {1,0,0,0}; // Juste le niveau 0

		assertTrue(gs.placerOuvriereFourmiliere(0)); // Placer une ouvriere au premier etage
		assertTrue(gs.genereRessourceFourmiliere()); // Générer les ressources
		
		Fourmiliere f = gs.getFourmiliere();
		
		// Les ressource généré doivent être nulles vu qu'il n'y a aucun fourmi
		assertArrayEquals(tabExpected1, f.genererRessources());
	}
	
	@Test
	public void testPlacerNourriceAtelier(){
		GestionSalles gs = new GestionSalles();
		boolean[] tabExpected1 = {false, false, false, false};
		tabExpected1[Constantes.AMELIORER_FOURMILIERE] = true; 
		
		assertTrue(gs.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE));
		SalleAtelier sa = gs.getSalleAtelier();
		
		// On vérifie qu'on a les meme evenements qui valent true
		assertTrue(Fonctions.arrayBoolEquals(sa.getEvenements(), tabExpected1));
	}
	
	@Test
	public void testPlacerOuvriereFourmiliere(){
		GestionSalles gs = new GestionSalles();
		boolean[] tabVoulu = {true, false, false, false}; // Une fourmi dans le premier
		
		assertTrue(gs.placerOuvriereFourmiliere(0));
		
		// On devrait avoir une fourmi dans le premier étage seulement
		assertTrue(Fonctions.arrayBoolEquals(gs.getFourmiliere().getNiveauxFourmiliere(), tabVoulu));
	}
	
	@Test
	public void testAmeliorerFourmiliere(){
		GestionSalles gs = new GestionSalles();
		Fourmiliere f = gs.getFourmiliere(); // Initialement niveau 0
		gs.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE); // Il faut d'abord placer une ouvriere sur l'event
		
		assertTrue(gs.ameliorerFourmiliere()); // Améliorer la fourmilière
		
		assertEquals(1, f.getNiveauMaximumCourant()); // Devrait être l'étage 1
		
		// Ensuite, on vérifie que la nourrice a été enlevé de l'atelier
		assertFalse(gs.getSalleAtelier().getEvenements()[Constantes.AMELIORER_FOURMILIERE]);
	}
}
