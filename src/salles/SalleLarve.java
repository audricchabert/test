/**
 * 
 */
package salles;

import utils.Constantes;
/**
 * @author Antoine Lavail
 *
 */
public class SalleLarve extends Salle {
	
	/**
	 * Prise en compte de l'�v�nement "Larve+2"
	 * 
	 */
	public void creerLarve(String evenementActuel, int nbLarves) {
		if (nbLarves > 0) {
			if (nbLarves == 1)
				ajouterFourmi(1);
			if (nbLarves == 2)
				ajouterFourmi(3);
			if (nbLarves == 3)
				ajouterFourmi(5);
			if (evenementActuel.equals(Constantes.EVEN_LARVE))
				ajouterFourmi(2);
		}
	}
}
