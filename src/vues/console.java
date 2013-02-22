package vues;

import plateauIndividuel.GestionSalles;
import plateauIndividuel.Joueur;
import utils.Constantes;

/**
 * Vue console, gérera l'affichage des données/ interaction client
 * 
 * @author mazen
 */

public class console {
	
	public console(){
		
		this.run();
	}

	public void run() {
		// On va simuler 1 tour de plateau! 
		System.out.println("Début du tour");
		
		Joueur j1 = new Joueur("Joueur 1"); // On crée notre joueur
		GestionSalles gs = j1.getGs();
		
		System.out.println(j1.getPseudo() + " => "+ gs.getLarves() +" larves / "+gs.getNourrices()+" nourrices / "+gs.getOuvrieres()+" ouvrières");
		
		// PHASE EVENEMENT
		System.out.println("\nPhase évènements!");
		System.out.println(j1.getPseudo()+ " décalle l'évènement de 1 vers la droite");
		gs.decallerEvenement(1, Constantes.DROITE);
		System.out.println("Le nouvel evenement est: "+gs.getEvenementActuel());
		System.out.println(j1.getPseudo() + " => "+ gs.getLarves() +" larves / "+gs.getNourrices()+" nourrices / "+gs.getOuvrieres()+" ouvrières");
		
		// PHASE NAISSANCE
		System.out.println("\nPhase naissance!");
		System.out.println(j1.getPseudo()+" place une nourrice dans l'atelier sur l'évenement 'AMELIORER FOURMILIERE'");
		gs.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE);
		System.out.println(j1.getPseudo()+" crée une ouvrière");
		gs.naissanceOuvrieres(2); // Créer 1 ouvriere en utilisant 2 nourrices
		System.out.println(j1.getPseudo() + " => "+ gs.getLarves() +" larves / "+gs.getNourrices()+" nourrices / "+gs.getOuvrieres()+" ouvrières");
		
		// OUVRIERES
		System.out.println("\nPhases ouvrières!");
		System.out.println(j1.getPseudo()+" place une ouvrière sur le niveau 0 de la fourmillère");
		gs.placerOuvriereFourmiliere(0);
		System.out.println(j1.getPseudo()+" récupère 1 larve ");
		gs.genereRessourceFourmiliere();
		System.out.println(j1.getPseudo() + " => "+ gs.getLarves() +" larves / "+gs.getNourrices()+" nourrices / "+gs.getOuvrieres()+" ouvrières");
	
		// AMELIORER 
		System.out.println("\nAméliorer fourmilière");
		System.out.println("Améliorer le rendu ");
		gs.ameliorerFourmiliere();
	}
	
}
