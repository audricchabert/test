package fr.unice.polytech.si3.tse.ttan.jardin;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import fr.unice.polytech.si3.tse.ttan.utils.Constantes;
import fr.unice.polytech.si3.tse.ttan.utils.Fonctions;

public class PlateauGeneral {
	
	private Tuile[][] matrice;
	
	/**
	 * Prend le chemin du xml modélisant le plateau général, 
	 * appelle la fonction pour le parser et stocke la matrice
	 */
	
	public PlateauGeneral(String path){
		Deserialisation des = new Deserialisation(path);
		this.matrice = des.creationPlateau();
	}
	
	/**
	 * Pour placer une phéromone, il faudra préciser le nombre de phéromone que 
	 * contient le groupe de phéromone à placer. Ainsi que des coordonnées de chaque phéromone.
	 * 
	 * Il faut que toute les phéromones soient reliés entre elles une à une
	 * 
	 * Les coordonées des phéromones seront représenté par un ArrayList contenant les doublons 
	 * de coordonée (x => 1ere case du tableau, y => 2em case du tableau)
	 * 
	 * @param taillePheromone
	 * @return
	 */
	
	public boolean placerPheromones(int taillePheromone, List<int[]> listeCoordonees){
		
		int taille = listeCoordonees.size();
		PrintStream err = System.err;
		
		/* TESTS */
		if(taillePheromone != taille){
			err.println("Probleme => Tailles ne concordent pas");
			return false;
		}else if(taille < Constantes.MIN_TAILLE_PHEROMONE || taille >Constantes.MAX_TAILLE_PHEROMONE){
			err.println("Probleme => Phéromones trop grandes ou trop petites");
			return false;
		}else if(!Fonctions.verifieGroupePheromone(listeCoordonees)){
			err.println("Probleme => Les phéromones ne sont pas adjacentes");
			return false;
		}
		
		/* Placer les phéromones */
		
		return true;
	}

	public Tuile[][] getMatrice() {
		return matrice.clone();
	}

	public void setMatrice(Tuile[][] matrice) {
		
		this.matrice = Arrays.copyOf(matrice, matrice.length);
		
	}
}