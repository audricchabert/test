package salles;

import utils.Constantes;

/**
 * Modélisation de la salle des ouvrière pour le plateau individuel
 * 
 * @author mazen
 */

public class SalleAtelier extends Salle{

	/*
	 * Dans la salle des ouvrieres, l'utilisateur peut choisir de placer ses ouvriere sur 4 cases possibles.
	 * Chacune permettant à la fin d'un tur d'effectuer une action précise. On a choisit de modéliser ces 
	 * choix par un tableau de 4 boolean, ou chaque case correspondrait à l'événement choisis.
	 * true si une ouvrière est placé sur cette evenement, false sinon. 
	 */
	boolean[] evenements;
	
	public SalleAtelier() {
		super();
		
		// Initialisation des évenements à false
		this.evenements = new boolean[4];
		this.evenements[Constantes.AMELIORER_FOURMILIERE] = false;
		this.evenements[Constantes.CREER_NOURRICE] = false;
		this.evenements[Constantes.NOUVELLE_GALERIE] = false;
		this.evenements[Constantes.OBJECTIF] = false;
	}
	
	/*
	 * Ajoute une nourrice a l'atelier, le place sur le bloc evenement voulu
	 * renvoit true si c'est bon, false si un probleme est survenu
	 */
	
	public boolean ajouteNourrice(int indiceEvenement){
		
		if(indiceEvenement >= 0 && indiceEvenement <= 3){ // L'indice doit correspondre au tableau
			
			if(! evenements[indiceEvenement]){ // Il ne faut pas qu'il y ait déja une nourrice
				evenements[indiceEvenement] = true;
				return true;
			}else{
				System.out.println("Il y a déja une nourrice sur cette évènement");
				return false;
			}
			
		}else{
			return false;
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
	
}
