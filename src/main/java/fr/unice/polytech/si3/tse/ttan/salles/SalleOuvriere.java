/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan.salles;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Evenements;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;
import fr.unice.polytech.si3.tse.ttan.fourmis.Ouvriere;

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
	 * Pour les naissance, il faudra aller chercher dans la salle des nourrice
	 * s'il y en a, si tel est le cas, on retire la nourrice et on cree les
	 * fourmis voulus
	 */
	public boolean naissanceOuvrieres(int nbNourriceUtilisee, SalleNourrice sn) {
		if ((nbNourriceUtilisee <= 1) || (nbNourriceUtilisee > 4)) {
			System.out.println("Erreur lors de la création d'ouvrieres: nb supérieur à 1 et inférieur à 5 seulement");
			return false;
		}

		if (sn.getNbCourantFourmi() < nbNourriceUtilisee) {
			System.out.println("Erreur lors de la création d'ouvrieres: pas assez de nourrices");
			return false;
		} 
		else {
			// On retire nbNourrice modulo 2 car l'utilisateur peut choisir
			// d'utiliser 3 nourrice (on ne lui en enleverra que 2)
			sn.supprimerFourmi(nbNourriceUtilisee - (nbNourriceUtilisee % 2));
			creerOuvriere(Evenements.getInstance().getEvenementCourant(), 2);
			return true;
		}
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
