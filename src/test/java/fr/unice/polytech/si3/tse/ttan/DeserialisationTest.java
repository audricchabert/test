package fr.unice.polytech.si3.tse.ttan;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.unice.polytech.si3.tse.ttan.jardin.Deserialisation;
import fr.unice.polytech.si3.tse.ttan.jardin.Tuile;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;


public class DeserialisationTest {
	
	@Test
	public void testDeserialisation(){
		String nom = "Hello space";
		
		Deserialisation des = new Deserialisation(nom);
		
		// Tester le nom
		assertTrue(des.getNom().equals(nom));
		
		// Tester le plateau (qui est vide mais qui doit être d'une taille donnée
		Tuile[][] plateau = des.getPlateau();
		assertEquals(plateau.length, Constantes.TAILLE_MATRICE);
		assertEquals(plateau[0].length, Constantes.TAILLE_MATRICE);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testCreationPlateau(){
		
		/* Test si le plateau s'initialise bien */
		String path = "plateau.xml";
		Deserialisation des = new Deserialisation(path);
		
		Tuile[][] plateau = des.creationPlateau();
		
		assertNotNull(plateau);
		
		/* Teste les bugs */
		
		String path2 = "nexistepas.xml";
		Deserialisation des2 = new Deserialisation(path2);
		assertNull(des2.creationPlateau());
		
	}
	
}
