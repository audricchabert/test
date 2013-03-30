package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.utils.Fonctions;

public class FonctionTest {

	@Test
	public void testArrayBoolEquals(){
		boolean array1[] = {false, false, false};
		boolean array2[] = {true, false, false};
		
		// Les deux array ne sont pas égaux, on s'attend à avoir false
		assertFalse(Fonctions.arrayBoolEquals(array1, array2));
		
		boolean array3[] = {false, false, false};
		// Les 2 array sont égaux, on attend truee
		assertTrue(Fonctions.arrayBoolEquals(array1, array3));
		
		boolean array4[] = {false, false, false, false};
		// Les 2 array n'ont pas la meme taille, on attend false
		assertFalse(Fonctions.arrayBoolEquals(array1, array4));
	}
	
	@Test
	public void testVerifieGroupePheromone(){
		List<int[]> listePheromone = new ArrayList<int[]>();
		
		int[] phe1 = {0,0};
		int[] phe2 = {0,1};
		int[] phe3 = {1,0};
		int[] phe4 = {1,1};
		listePheromone.add(phe1);
		listePheromone.add(phe2);
		listePheromone.add(phe3);
		listePheromone.add(phe4);
		
		// Toute les pheromones sont adjacente, on attent true
		assertTrue(Fonctions.verifieGroupePheromone(listePheromone));
		
		// On change le Y de la phéromone2 pour la décaller, on attend false
		phe2[1] = 2;
		assertFalse(Fonctions.verifieGroupePheromone(listePheromone));
		
		phe2[1] = 0;
		
		// On change le X, on attend false
		phe3[0] = 2;
		assertFalse(Fonctions.verifieGroupePheromone(listePheromone));
	}
	
}
