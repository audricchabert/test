package salles;

import java.util.ArrayList;
import java.util.List;

import utils.Constantes;

import fourmis.Fourmi;

/**
 * Modélisation d'une salle. Abstraite.
 * @author AntoineLavail
 *
 */
public abstract class Salle {
	
	// Le nombre de fourmis dans la salle
	private List<Fourmi> nbCourantFourmi = new ArrayList<Fourmi>(Constantes.NB_FOURMILIERE_PAR_SALLE_MAX);
	
	public Salle() {
	}
	
	// Ajouter une fourmi dans la salle
	abstract public boolean ajouterFourmi();
	
	// Ajouter le "nombre" de fourmis à la salle.
	abstract public boolean ajouterFourmi(int nombre);
		
	// Supprimer une fourmi à la salle.
	abstract public boolean supprimerFourmi();
	
	// Supprimer le "nombre" de fourmis à la salle.
	abstract public boolean supprimerFourmi(int nombre);

	/**
	 * Recuperer le nombre courant de fourmi dans une salle.
	 * @return nbCourantFourmi
	 */
	public int getNbCourantFourmi() {
		return nbCourantFourmi.size();
	}
	
	/**
	 * Getter : nbCourantFourmi
	 * @return nbCourantFourmi
	 */
	public List<Fourmi> getListeFourmis() {
		return nbCourantFourmi;
	}

	/**
	 * Setter
	 * @param nbCourantFourmi:Nombre de fourmi à mettre dans la salle.
	 */
	public void setNbCourantFourmi(List<Fourmi> nbCourantFourmi) {
		this.nbCourantFourmi = nbCourantFourmi;
	}
}
