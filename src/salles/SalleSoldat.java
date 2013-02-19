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
public class SalleSoldat extends Salle {

	
	/**
	 * Prise en compte de l'évènement "Soldat+1"
	 * 
	 */
	public void creerSoldat() {
		if (this.getNbCourantFourmi() > 1) {
			if (this.getNbCourantFourmi() == 2)
				ajouterFourmi(1);
			if (this.getNbCourantFourmi() == 3)
				ajouterFourmi(2);
			if (Evenements.getInstance().getListeEvenements().get(Constantes.EVEN_SOLDAT))
				ajouterFourmi(1);
		}
	}
}
