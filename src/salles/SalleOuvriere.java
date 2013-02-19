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
public class SalleOuvriere extends Salle {

	
	/**
	 * Prise en compte de l'�v�nement "Ouvriere+1"
	 * 
	 */
	public void creerOuvriere() {
		if (this.getNbCourantFourmi() > 1) {
			if (this.getNbCourantFourmi() == 2)
				ajouterFourmi(1);
			if (this.getNbCourantFourmi() == 4)
				ajouterFourmi(2);
			if (Evenements.getInstance().getListeEvenements().get(Constantes.EVEN_OUVRIERES))
				ajouterFourmi(1);
		}
	}
}
