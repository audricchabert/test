package vues;

import plateauIndividuel.GestionSalles;
import plateauIndividuel.Joueur;
import utils.Constantes;

/**
 * Vue console, gerera l'affichage des donnees/ interaction client
 * 
 * @author mazen
 */

public class console {
	
	public console(){
		
		this.run();
	}

	public void run() {
		// On va simuler 1 tour de plateau! 
		System.out.println("Debut du tour");
		
		Joueur j1 = new Joueur("Joueur 1"); // On cree notre joueur
		GestionSalles gs = j1.getGs();
		
		System.out.println(j1.getPseudo() + " => " + gs.getLarves() + " larve / "+gs.getNourrices() + " nourrices / "+ gs.getOuvrieres()  + " ouvrieres");
		
		// PHASE EVENEMENT
		System.out.println("\nPhase evenements!");
		System.out.println("Evenement actuel : " + gs.getEvenementActuel());
		System.out.println(j1.getPseudo()+ " decalle l'evenement de 1 vers la droite");
		gs.decallerEvenement(1, Constantes.DROITE);
		System.out.println("Le nouvel evenement est : " + gs.getEvenementActuel());
		System.out.println(j1.getPseudo() + " => " + gs.getLarves()  + " larve / " + gs.getNourrices()  + " nourrices / " + gs.getOuvrieres()  + " ouvrieres");
		
		// PHASE NAISSANCE
		System.out.println("\nPhase naissance!");
		System.out.println(j1.getPseudo()+" place une nourrice dans l'atelier sur l'evenement 'AMELIORER FOURMILIERE'");
		gs.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE);
		System.out.println(j1.getPseudo() + " => " + gs.getLarves()  + " larve / " + gs.getNourrices()  + " nourrices / " + gs.getOuvrieres()  + " ouvrieres");
		System.out.println(j1.getPseudo()+" cree une ouvriere");
		gs.naissanceOuvrieres(2); // Creer 1 ouvriere en utilisant 2 nourrices
		System.out.println(j1.getPseudo() + " => " + gs.getLarves()  + " larve / " + gs.getNourrices()  + " nourrices / " + gs.getOuvrieres()  + " ouvrieres");
		
		// OUVRIERES
		System.out.println("\nPhase ouvrieres!");
		System.out.println(j1.getPseudo()+" place une ouvriere sur le niveau 0 de la fourmillere");
		gs.placerOuvriereFourmiliere(0);
		System.out.println(j1.getPseudo()+" recupere 1 larve ");
		gs.genereRessourceFourmiliere();
		System.out.println(j1.getPseudo() + " => " + gs.getLarves()  + " larve / " + gs.getNourrices()  + " nourrices / " + gs.getOuvrieres()  + " ouvrieres");
	
		// AMELIORER 
		System.out.println("\nAmeliorer fourmiliere");
		gs.ameliorerFourmiliere();
	}
	
}
