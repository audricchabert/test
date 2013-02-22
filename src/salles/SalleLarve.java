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
	public void creerLarve(String evenementActuel) {
		if (this.getNbCourantFourmi() > 0) {
			if (this.getNbCourantFourmi() == 1)
				ajouterFourmi(1);
			if (this.getNbCourantFourmi() == 2)
				ajouterFourmi(3);
			if (this.getNbCourantFourmi() == 3)
				ajouterFourmi(5);
			if (evenementActuel.equals(Constantes.EVEN_LARVE))
				ajouterFourmi(2);
		}
	}
}
