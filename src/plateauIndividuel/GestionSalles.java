package plateauIndividuel;

import salles.SalleAtelier;
import salles.SalleLarve;
import salles.SalleNourrice;
import salles.SalleOuvriere;
import salles.SalleSoldat;
import salles.SalleStock;

public class GestionSalles {

	/* LES SALLES */
	SalleAtelier salleAtelier;
	SalleLarve salleLarve;
	SalleNourrice salleNourrice;
	SalleOuvriere salleOuvriere;
	SalleSoldat salleSoldat;
	SalleStock salleStock;
	Evenements evenements;
	
	
	public GestionSalles(){
		
		// Initialisation des salles du plateau
		this.salleAtelier = new SalleAtelier();
		this.salleLarve = new SalleLarve();
		this.salleNourrice = new SalleNourrice();
		this.salleSoldat = new SalleSoldat();
		this.salleStock = new SalleStock();
		
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
			
			// Pour les salle de larve, il faudra "ajouter les fourmi" puis appeler creerLarve
			salleLarve.ajouterFourmi(nbNourriceUtilisee);
			salleLarve.creerLarve();
			
			return true;
		}
		
	}
	
	public boolean naissanceSoldats(int nbNourriceUtilisee){
		if( (nbNourriceUtilisee <= 1) || (nbNourriceUtilisee > 3) ){
			System.out.println("Erreur lors de la création de fourmis: nb supérieur à 1 et inférieur à 4 seulement");
			return false;
		}
		
		int nbNourrices = salleNourrice.getNbCourantFourmi();
		
		if(nbNourrices < nbNourriceUtilisee){
			System.out.println("Erreur lors de la création de fourmis: pas assez de nourrices");
			return false;
		}else{
			salleNourrice.supprimerFourmi(nbNourriceUtilisee);
			
			salleSoldat.ajouterFourmi(nbNourriceUtilisee);
			salleSoldat.creerSoldat();
			
			return true;
		}
	}
	
	public boolean naissanceOuvrieres(int nbNourriceUtilisee){
		if( (nbNourriceUtilisee <= 1) || (nbNourriceUtilisee > 3) ){
			System.out.println("Erreur lors de la création de fourmis: nb supérieur à 1 et inférieur à 5 seulement");
			return false;
		}
		
		int nbNourrices = salleNourrice.getNbCourantFourmi();
		
		if(nbNourrices < nbNourriceUtilisee){
			System.out.println("Erreur lors de la création de fourmis: pas assez de nourrices");
			return false;
		}else{
			// On retire nbNourrice modulo 2 car l'utilisateur peut choisir d'utiliser 3 nourrice (on ne lui en enleverra que 2)
			salleNourrice.supprimerFourmi(nbNourriceUtilisee - (nbNourriceUtilisee%2) );
			
			salleSoldat.ajouterFourmi(nbNourriceUtilisee - (nbNourriceUtilisee%2) );
			salleSoldat.creerSoldat();
			
			return true;
		}
	}
	
	
	
}
