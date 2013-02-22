package plateauIndividuel;

/**
 * Modélisation de la gestion des salles.
 * Dans cette classe, on fera le lien entre joueur et plateau individuel, cela nous permet 
 * d'éviter d'avoir un code trop volumineu.
 * 
 * Ici, on gérera les interactions entre les salles, les suppression/ajouts de fourmis etc..
 * 
 * @author mazen
 */

import salles.SalleAtelier;
import salles.SalleLarve;
import salles.SalleNourrice;
import salles.SalleOuvriere;
import salles.SalleSoldat;
import salles.SalleStock;
import utils.Constantes;

public class GestionSalles {

	/* LES SALLES */
	private SalleAtelier salleAtelier;
	private SalleLarve salleLarve;
	private SalleNourrice salleNourrice;
	private SalleOuvriere salleOuvriere;
	private SalleSoldat salleSoldat;
	private SalleStock salleStock;
	
	/* EVENEMENT */
	private int indiceEvnt;
	
	public GestionSalles(){
		
		// Initialisation des salles du plateau
		this.salleAtelier = new SalleAtelier();
		this.salleLarve = new SalleLarve();
		this.salleNourrice = new SalleNourrice();
		this.salleOuvriere = new SalleOuvriere();
		this.salleSoldat = new SalleSoldat();
		this.salleStock = new SalleStock();
		
		// Ajouter 3 nourrices, 2 ouvrieres, 1 larves
		this.salleNourrice.ajouterFourmi(3);
		this.salleOuvriere.ajouterFourmi(2);
		this.salleLarve.ajouterFourmi(1);
		
		//Evenement
		this.indiceEvnt = 0; // On commence au premier évenement	
		
	}
	
	/* Gestion des naissances */
	
	/*
	 * Pour les naissance, il faudra aller chercher dans la salle des nourrice s'il y en a, si tel est le cas,
	 * on retirre la nourrice et on crée les fourmis voulus
	 */
	
	public boolean naissanceLarves(int nbNourriceUtilisee){
		
		// CAS OU LE PARAMETRE EST HORS RANGE
		if( (nbNourriceUtilisee <= 0) || (nbNourriceUtilisee > 3) ){
			System.out.println("Erreur lors de la création de larves: nb supérieur à O et inférieur à 4 seulement");
			return false;
		}
		
		int nbNourrices = salleNourrice.getNbCourantFourmi();
		
		if(nbNourrices < nbNourriceUtilisee){
			System.out.println("Erreur lors de la création de larves: pas assez de nourrices");
			return false;
		}else{
			salleNourrice.supprimerFourmi(nbNourriceUtilisee);
			
			salleLarve.creerLarve(Constantes.LISTE_EVENEMENTS[this.indiceEvnt], nbNourriceUtilisee);
			
			return true;
		}
		
	}
	
	public boolean naissanceSoldats(int nbNourriceUtilisee){
		if( (nbNourriceUtilisee <= 1) || (nbNourriceUtilisee > 3) ){
			System.out.println("Erreur lors de la création de soldats: nb supérieur à 1 et inférieur à 4 seulement");
			return false;
		}
		
		int nbNourrices = salleNourrice.getNbCourantFourmi();
		
		if(nbNourrices < nbNourriceUtilisee){
			System.out.println("Erreur lors de la création de soldats: pas assez de nourrices");
			return false;
		}else{
			salleNourrice.supprimerFourmi(nbNourriceUtilisee);
			
			salleSoldat.creerSoldat(Constantes.LISTE_EVENEMENTS[this.indiceEvnt], nbNourriceUtilisee);
			
			return true;
		}
	}
	
	public boolean naissanceOuvrieres(int nbNourriceUtilisee){
		if( (nbNourriceUtilisee <= 1) || (nbNourriceUtilisee > 4) ){
			System.out.println("Erreur lors de la création d'ouvrieres: nb supérieur à 1 et inférieur à 5 seulement");
			return false;
		}
		
		int nbNourrices = salleNourrice.getNbCourantFourmi();
		
		if(nbNourrices < nbNourriceUtilisee){
			System.out.println("Erreur lors de la création d'ouvrieres: pas assez de nourrices");
			return false;
		}else{
			// On retire nbNourrice modulo 2 car l'utilisateur peut choisir d'utiliser 3 nourrice (on ne lui en enleverra que 2)
			salleNourrice.supprimerFourmi(nbNourriceUtilisee - (nbNourriceUtilisee%2) );
			
			salleOuvriere.creerOuvriere(Constantes.LISTE_EVENEMENTS[this.indiceEvnt], nbNourriceUtilisee - (nbNourriceUtilisee%2));
			
			return true;
		}
	}
	
	
	/* EVENEMENTS */
	
	/*
	* La fonction decallerEvenement prendra en paramètre un caractère 
	* qui correspondra au mouvement voulu et un nombre correspondant au nombre de decallage.
	*  On pourra avoir 2 mouvements "Droite" ou "Gauche". 
	* Chaque déplacement entrainant un changement d'événement 
	*/
	
	public boolean decallerEvenement(int nbDecal, char cote){
		
		if(nbDecal <= 0){
			System.out.println("Probleme evenements: supérieur à 0 requis");
			return false;
		}
		
		// Vérification nombre de nourrices
		int nbNourrices = this.salleNourrice.getNbCourantFourmi();
		
		if( (nbNourrices - nbDecal) < 0){
			System.out.println("Probleme evenements: pas assez de nourrices");
			return false;
		}
		
		// Modification evenement
		if(cote == Constantes.GAUCHE){
			
			if( (this.indiceEvnt - nbDecal) < 0){ 
				return false;
			}else{
				this.salleNourrice.supprimerFourmi(nbDecal);
				this.indiceEvnt -= nbDecal;
				return true;
			}
			
		}else if(cote == Constantes.DROITE){
			
			if( (this.indiceEvnt + nbDecal) >= Constantes.NOMBRE_EVENEMENTS){ 
				return false;
			}else{
				this.salleNourrice.supprimerFourmi(nbDecal);
				this.indiceEvnt += nbDecal;
				return true;
			}
			
		}else{ // Probleme
			System.out.println("PROBLEME AVEC LES EVENEMENTS");
			return false;
		}
	}
	
	/* GETTERS / SETTERS */
	public int getIndiceEvnt(){
		return this.indiceEvnt;
	}
	
	public void setIndiceEvnt(int newI){
		this.indiceEvnt = newI;
	}

	public SalleAtelier getSalleAtelier() {
		return salleAtelier;
	}

	public SalleLarve getSalleLarve() {
		return salleLarve;
	}

	public SalleNourrice getSalleNourrice() {
		return salleNourrice;
	}

	public SalleOuvriere getSalleOuvriere() {
		return salleOuvriere;
	}

	public SalleSoldat getSalleSoldat() {
		return salleSoldat;
	}

	public SalleStock getSalleStock() {
		return salleStock;
	}

}
