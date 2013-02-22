/**
 * 
 */
package salles;

import utils.Constantes;

/**
 * @author Antoine Lavail
 *
 */
public class SalleSoldat extends Salle {

	
	/**
	 * Prise en compte de l'�v�nement "Soldat+1"
	 * 
	 */
	public void creerSoldat(String evenementActuel, int nbLarves) {
		if (nbLarves > 1) {
			if (nbLarves == 2)
				ajouterFourmi(1);
			if (nbLarves == 3)
				ajouterFourmi(2);
			if (evenementActuel.equals(Constantes.EVEN_SOLDAT))
				ajouterFourmi(1);
		}
	}
}
