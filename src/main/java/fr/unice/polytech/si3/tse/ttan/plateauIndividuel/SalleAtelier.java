package fr.unice.polytech.si3.tse.ttan.plateauIndividuel;

import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

/**
 * Modélisation de la salle des ouvrière pour le plateau individuel
 * 
 * @author mazen
 */

public class SalleAtelier extends Salle {

	
	private static final int NB_EVEN_ATELIER = 4;
	/*
	 * Dans la salle des ouvrieres, l'utilisateur peut choisir de placer ses ouvriere sur 4 cases possibles.
	 * Chacune permettant à la fin d'un tur d'effectuer une action précise. On a choisit de modéliser ces 
	 * choix par un tableau de 4 boolean, ou chaque case correspondrait à l'événement choisis.
	 * true si une ouvrière est placé sur cette evenement, false sinon. 
	 */
	private boolean[] evenements;
	
	public SalleAtelier() {
		super();
		
		// Initialisation des évenements à false
		this.evenements = new boolean[NB_EVEN_ATELIER];
		this.evenements[Constantes.AMELIORER_FOURMILIERE] = false;
		this.evenements[Constantes.CREER_NOURRICE] = false;
		this.evenements[Constantes.NOUVELLE_GALERIE] = false;
		this.evenements[Constantes.OBJECTIF] = false;
	}
	
	/*
	 * Ajoute une nourrice a l'atelier, le place sur le bloc evenement voulu
	 * renvoit true si c'est bon, false si un probleme est survenu
	 */
	
	public boolean ajouteNourrice(int indiceEvenement) {
		
		// L'indice doit correspondre au tableau
		if(indiceEvenement >= 0 && indiceEvenement <= 3) {
			
			// Il ne faut pas qu'il y ait deja une nourrice
			if(!evenements[indiceEvenement]) { 
				evenements[indiceEvenement] = true;
				return true;
			}
			else {
				throw new ExceptionNourrices(Constantes.EX_DUPNOURRICE);
			}
			
		}
		else {
			throw new IllegalArgumentException("Indice Inconnu");
		}
	}
	
	/*
	 * Retourne la liste des objectifs en cours
	 */
	
	public boolean[] getEvenements(){
		return this.evenements;
	}
	
	/*
	 * Vide le tableau des evenements
	 * ce qui signifie qu'on ré-initialise tout a false
	 */
	
	public void vider(){
		for(int i=0; i<evenements.length; i++){
			evenements[i] = false;
		}
	}

	/**
	 * La salle atelier ne stocke pas de fourmis
	 */
	@Override
	public boolean ajouterFourmi() {
		return false;
	}

	@Override
	public boolean ajouterFourmi(int nombre) {
		return false;
	}

	@Override
	public boolean supprimerFourmi() {
		return false;
	}

	@Override
	public boolean supprimerFourmi(int nombre) {
		return false;
	}
	
}
