package salles;

import fourmis.Larve;
import utils.Constantes;
/**
 * @author Antoine Lavail
 *
 */
public class SalleLarve extends Salle {
	
	@Override
	public boolean ajouterFourmi() {
		this.getListeFourmis().add(new Larve());
		return true;
	}

	@Override
	public boolean ajouterFourmi(int nombre) {
		if (nombre > 0) {
			for (int i = 0; i < nombre; i++)
				this.getListeFourmis().add(new Larve());
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
	 * Prise en compte de l'evenement "Larve+2"
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
