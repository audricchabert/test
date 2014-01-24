/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan.plateauIndividuel;

import fr.unice.polytech.si3.tse.ttan.fourmis.Soldat;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

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
			for (int i = 0; i < nombre; i++) {
				this.getListeFourmis().add(new Soldat());
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean supprimerFourmi() {
		if (this.getListeFourmis().isEmpty()) {
			return false;
		}
		else {
			int taille = this.getListeFourmis().size() - 1;
			this.getListeFourmis().remove(taille);
		}
		return true;
	}

	@Override
	public boolean supprimerFourmi(int nombre) {
		if (nombre > 0) {
			if (this.getListeFourmis().isEmpty()) {
				return false;
			}
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
	 * Pour les naissance, il faudra aller chercher dans la salle des nourrice
	 * s'il y en a, si tel est le cas, on retire la nourrice et on cree les
	 * fourmis voulus
	 */
	public boolean naissanceSoldats(int nbNourriceUtilisee, SalleNourrice sn) {
		if ((nbNourriceUtilisee <= 1) || (nbNourriceUtilisee > 3)) {
			throw new IllegalArgumentException(Constantes.EX_HORSRANGE);
		}

		if (sn.getNbCourantFourmi() < nbNourriceUtilisee) {
			throw new ExceptionNourrices(Constantes.EX_MANQUENOURRICE);
		} 
		else {
			sn.supprimerFourmi(nbNourriceUtilisee);
			creerSoldat(Evenements.getInstance().getEvenementCourant(), nbNourriceUtilisee);
			return true;
		}
	}

	/**
	 * Prise en compte de l'�v�nement "Soldat+1"
	 * 
	 */
	public void creerSoldat(String evenementActuel, int nbLarves) {
		if (nbLarves > 1) {
			if (nbLarves == 2) {
				ajouterFourmi(1);
			}
			if (nbLarves == 3) {
				ajouterFourmi(2);
			}
			if (evenementActuel.equals(Constantes.EVEN_SOLDAT)) {
				ajouterFourmi(1);
			}
		}
	}
}
