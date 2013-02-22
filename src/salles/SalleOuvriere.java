/**
 * 
 */
package salles;

import utils.Constantes;

/**
 * @author Antoine Lavail
 *
 */
public class SalleOuvriere extends Salle {

	
	/**
	 * Prise en compte de l'�v�nement "Ouvriere+1"
	 * 
	 */
	public void creerOuvriere(String evenementActuel, int nbLarves) {
		if (nbLarves > 1) {
			if (nbLarves == 2)
				ajouterFourmi(1);
			if (nbLarves == 4)
				ajouterFourmi(2);
			if (evenementActuel.equals(Constantes.EVEN_OUVRIERES))
				ajouterFourmi(1);
		}
	}
}
