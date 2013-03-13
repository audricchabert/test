/**
 * 
 */
package salles;

import utils.Constantes;
import fourmis.Ouvriere;

/**
 * @author Antoine Lavail
 *
 */
public class SalleOuvriere extends Salle {


	@Override
	public boolean ajouterFourmi() {
		this.getListeFourmis().add(new Ouvriere());
		return true;
	}

	@Override
	public boolean ajouterFourmi(int nombre) {
		if (nombre > 0) {
			for (int i = 0; i < nombre; i++)
				this.getListeFourmis().add(new Ouvriere());
			return true;
		}
		return false;
	}

	@Override
	public boolean supprimerFourmi() {
		if (this.getListeFourmis().isEmpty())
			return false;
		else {
			int taille = this.getListeFourmis().size() - 1;
			this.getListeFourmis().remove(taille);
		}
		return true;
	}

	@Override
	public boolean supprimerFourmi(int nombre) {
		if (nombre > 0) {
			if (this.getListeFourmis().isEmpty())
				return false;
			else {
				int taille = 0;
				for(int i = 0; i < nombre; i++) {
					taille = this.getListeFourmis().size() - 1;
					this.getListeFourmis().remove(taille);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Prise en compte de l'evenement "Ouvriere+1"
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
