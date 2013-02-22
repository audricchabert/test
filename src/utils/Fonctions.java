package utils;

/**
 * Fonctions globales utiles au projet
 * 
 * liste: 
 * - arrayBoolEquals => Test si 2 tableaux boolean sont équivalents
 * 
 * @author mazen
 */

public class Fonctions {
	
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
}
