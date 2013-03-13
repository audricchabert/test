/**
 * 
 */
package salles;

import utils.Constantes;
import fourmis.Soldat;

/**
 * @author Antoine Lavail
 *
 */
public class SalleSoldat extends Salle {
	
	@Override
	public boolean ajouterFourmi() {
		this.getListeFourmis().add(new Soldat());
		return true;
	}

	@Override
	public boolean ajouterFourmi(int nombre) {
		if (nombre > 0) {
			for (int i = 0; i < nombre; i++)
				this.getListeFourmis().add(new Soldat());
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
	 * Prise en compte de l'événement "Soldat+1"
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
