package fr.unice.polytech.si3.tse.ttan.plateauIndividuel;

import fr.unice.polytech.si3.tse.ttan.salles.SalleAtelier;
import fr.unice.polytech.si3.tse.ttan.salles.SalleLarve;
import fr.unice.polytech.si3.tse.ttan.salles.SalleOuvriere;
import fr.unice.polytech.si3.tse.ttan.salles.SalleStock;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

/**
 * La classe fourmiliere representera les niveaux de la fourmiliere
 * @author achabert
 *
 */

public class Fourmiliere 
{
	/**
	 * Les attributs de la fourmiliere,
	 * on doit representer le niveau maximal de la fourmiliere accessible au joueur,
	 * et le nombre d'ouvrieres travaillant dans chaque niveau.
	 * Puisque seul une ouvriere peut travailler dans un niveau,
	 * nous avons choisi d'utiliser des booleens.
	 */
	public boolean[] niveauxFourmiliere = new boolean[Constantes.NIVEAU_FOURMILIERE_MAX];
	public int niveauMaximumCourant;

	/**
	 * Constructeurs
	 */

	/**
	 * Constructeur a deux parametres
	 * @param niveauxFourmiliere
	 * @param niveauMaximumCourant
	 */
	public Fourmiliere(boolean niveauxFourmiliere[], int niveauMaximumCourant) {
		this.niveauxFourmiliere=niveauxFourmiliere;
		this.niveauMaximumCourant = niveauMaximumCourant;
	}

	/**
	 * Constructeur sans parametres
	 */
	public Fourmiliere() {
		this(new boolean[Constantes.NIVEAU_FOURMILIERE_MAX] , 0); // Niveau 0 au début
	}

	/**
	 * Accesseurs en lecture
	 */

	/**
	 * Accesseur en lecture du niveauMaximumCourant
	 * @return niveauMaximumCourant
	 */
	public int getNiveauMaximumCourant() {
		return niveauMaximumCourant;
	}
	/**
	 * Accesseur en lecture du tableau de niveaux
	 * @return niveauxFourmiliere
	 */
	public boolean[] getNiveauxFourmiliere() {
		return niveauxFourmiliere;
	}

	/**
	 * Accesseurs en ecriture
	 */

	/**
	 * Accesseur en ecriture du niveauMaximumCourant
	 * @param entier
	 */
	public void setNiveauMaximumCourant(int nouveauNiveauMaximumCourant) {
		this.niveauMaximumCourant = nouveauNiveauMaximumCourant;
	}

	/**
	 * Accesseur en ecriture du tableau de niveaux
	 */
	public void setNiveauxFourmiliere(boolean[] nouveauNiveauxFourmiliere) {
		this.niveauxFourmiliere = nouveauNiveauxFourmiliere;
	}
	
	/**
	 * Augmenter le niveau necessite, selon s'il a pose une nourrice sur l'evenement de l'atelier ou non, 
	 * il pourra ameliorer la foumiliere.
	 */
	
	public boolean ameliorerFourmiliere(SalleAtelier sa) {
		
		if(getNiveauMaximumCourant() == 3){ // Rien ne sert d'aller plus haut
			return false;
		}
		
		// Il doit y avoir une nourrice sur l'evenement
		if(sa.getEvenements()[Constantes.AMELIORER_FOURMILIERE]) {
			
			// On active le niveau suivant
			setNiveauMaximumCourant(getNiveauMaximumCourant() + 1);
			
			// Puis retirer la nourrice de l'atelier
			sa.getEvenements()[Constantes.AMELIORER_FOURMILIERE] = false;
			return true;
		}
		else
			// Impossible, pas de nourrice sur l'evenement
			return false;
	}

	/**
	 * La m�thode genererRessources va generer les ressources de la fourmiliere, en fonction 
	 * du nombre de fourmis associees dans la construction de la fourmiliere.
	 * 
	 * Il faudra gerer le choix du joueur pour le niveau 3.
	 * On pourra recuperer de la pierre ou de la terre.
	 */
	
	public boolean genererRessources(SalleLarve sl, SalleStock ss) {
		// Test si il y a une fourmi au niveau 0. Si oui, on cree une larve.
		if (niveauxFourmiliere[0]) {
			sl.creerLarve(Evenements.getInstance().getEvenementCourant(), 1);
		}
		// Test s'il y a une fourmi au niveau 1. Si oui, on ajoute une ressource nourriture.
		if (niveauxFourmiliere[1])
		ss.ajouterRessource(Constantes.RESS_NOURRITURE, 1);

		// Test s'il y a une fourmi au niveau 2. Si oui, on ajoute une ressource de terre et de pierre.
		if (niveauxFourmiliere[2]) {
			ss.ajouterRessource(Constantes.RESS_TERRE, 1);
			ss.ajouterRessource(Constantes.RESS_PIERRE, 1);
		}
		return true;
	}
	
	/**
	 * Placer une ouvriere sur un etage de la fourmilliere
	 * @param etage: l'etage sur lequel on veut placer l'ouvriere
	 */
	public boolean placerOuvriere(int etage, SalleOuvriere so) {
		
		if (etage < 0 || etage > 3){
			System.out.println("Hors range");
			return false;
		}
		
		// Verifier qu'on a acces a cet etage
		if (etage > niveauMaximumCourant) {
			System.out.println("La fourmiliere n'a pas ce niveau");
			return false;
			
		}
		// Verifier qu'il n'y a pas deja une fourmi dans cet etage
		if (niveauxFourmiliere[etage]) {
			System.out.println("Cet etage de la fourmiliere est deja occupe");
			return false;
		}
		// Verifier qu'on a assez d'ouvrieres
		if (so.getNbCourantFourmi() < 1) {
			System.out.println("Pas assez d'ouvrieres");
			return false;
		}
		// C'est bon
		else {
			so.supprimerFourmi();
			niveauxFourmiliere[etage] = true;
			return true;
		}
	}

}
