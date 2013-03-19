package fr.unice.polytech.si3.tse.ttan.salles;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Evenements;
import fr.unice.polytech.si3.tse.ttan.fourmis.Larve;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

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
				for (int i = 0; i < nombre; i++) {
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
	public boolean naissanceLarves(int nbNourriceUtilisee, SalleNourrice sn) {
		
		// CAS OU LE PARAMETRE EST HORS RANGE
		if ((nbNourriceUtilisee <= 0) || (nbNourriceUtilisee > 3)) {
			System.out.println("Erreur lors de la creation de larves: nb superieur à O et inferieur à 4 seulement");
			return false;
		}

		if (sn.getNbCourantFourmi() < nbNourriceUtilisee) {
			System.out.println("Erreur lors de la creation de larves: pas assez de nourrices");
			return false;
		} else {
			sn.supprimerFourmi(nbNourriceUtilisee);
			creerLarve(Evenements.getInstance().getEvenementCourant(), nbNourriceUtilisee);
			return true;
		}
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
