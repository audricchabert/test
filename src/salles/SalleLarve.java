/**
 * 
 */
package salles;

import plateauIndividuel.Evenements;
import utils.Constantes;
/**
 * @author Antoine Lavail
 *
 */
public class SalleLarve extends Salle {
	
	/**
	 * Prise en compte de l'évènement "Larve+2"
	 * 
	 */
	public void creerLarve() {
		if (this.getNbCourantFourmi() > 0) {
			if (Evenements.getInstance().getListeEvenements().get(Constantes.EVEN_LARVE))
				ajouterFourmi(2);
			if (this.getNbCourantFourmi() == 1)
				ajouterFourmi(1);
			if (this.getNbCourantFourmi() == 2)
				ajouterFourmi(3);
			if (this.getNbCourantFourmi() == 3)
				ajouterFourmi(5);
		}
	}
}
