package fr.unice.polytech.si3.tse.ttan.utils;

import java.util.List;

/**
 * Fonctions globales utiles au projet
 * 
 * liste: 
 * - arrayBoolEquals => Test si 2 tableaux boolean sont équivalents
 * 
 * @author mazen
 */

public final class Fonctions {
	
	/**
	 * Test si 2 array sont équivalents, 2 array sont équivalents s'ils ont la meme taille
	 * et si tout leur éléments sont egaux 1 à 1
	 * -> O(n)
	 * 
	 * @param tab1
	 * @param tab2
	 * @return boolean
	 * @author mazen
	 */
	
	public static boolean arrayBoolEquals(boolean[] tab1, boolean tab2[]){
		
		
		if(tab1.length != tab2.length){
			return false;
		}
		
		for(int i=0; i<tab1.length; i++){
			if(tab1[i] != tab2[i]){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Prend un groupe de phéromone et vérifie qu'ils sont valide.
	 * Un groupe de phéromones est considéré comme valide si toute les phéromone
	 * sous-jacentes sont réliées entres elle une à une.
	 * -> O(n(n+1)/2) => O(n²)
	 * 
	 * @param groupePheromone
	 * @return boolean
	 * @author mazen
	 */
	
	/* IL faut utiliser le type List et non ArrayList 
	 * "Avoid using implementation types like 'ArrayList'; use the interface instead"
	 * Aucune idée pourquoi..
	 */
	public static boolean verifieGroupePheromone(List<int[]> groupePheromone){
		
		int taille = groupePheromone.size();
		boolean isValide = true;
		
		for(int i=0; i<taille-1; i++){
			int[] compare1 = groupePheromone.get(i);
			int x1 = compare1[0];
			int y1 = compare1[1];
			
			for(int j=i+1; j<taille; j++){
				int[] compare2 = groupePheromone.get(j);
				int x2 = compare2[0];
				int y2 = compare2[1];
				
				/* Vérifier que les abcisses soient adjacent*/
				if(! ((x1 == x2) || (x1 == x2-1) || (x1 == x2+1)) ){
					isValide = false;
					break;
				}
				
				/* Vérifier ordonnées */
				if(! ((y1 == y2) || (y1 == y2-1) || (y1 == y2+1)) ){
					isValide = false;
					break;
				}
			}
		}
		
		return isValide;
	}
	
	private Fonctions(){};
}
