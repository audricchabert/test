package vues;

import plateauIndividuel.Evenements;
import plateauIndividuel.PlateauIndividuel;
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
		// On va simuler 1 tour de plateau !
		System.out.println("Debut du tour");
		
		Joueur j1 = new Joueur("Joueur 1"); // On cree notre joueur
		PlateauIndividuel plateau = j1.getPlateauIndividuel();
		
		System.out.println(j1.getPseudo() + " => " + plateau.getLarves() + " larve / "+plateau.getNourrices() + " nourrices / "+ plateau.getOuvrieres()  + " ouvrieres");
		
		// PHASE EVENEMENT
		System.out.println("\nPhase evenements !");
		System.out.println("Evenement actuel : " + Evenements.getInstance().getEvenementCourant());
		System.out.println(j1.getPseudo()+ " decalle l'evenement de 1 vers la droite");
		plateau.decallerEvenement(1, Constantes.DROITE);
		System.out.println("Le nouvel evenement est : " + Evenements.getInstance().getEvenementCourant());
		System.out.println(j1.getPseudo() + " => " + plateau.getLarves()  + " larve / " + plateau.getNourrices()  + " nourrices / " + plateau.getOuvrieres()  + " ouvrieres");
		
		// PHASE NAISSANCE
		System.out.println("\nPhase naissance !");
		System.out.println(j1.getPseudo()+" place une nourrice dans l'atelier sur l'evenement 'AMELIORER FOURMILIERE'");
		plateau.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE);
		System.out.println(j1.getPseudo() + " => " + plateau.getLarves()  + " larve / " + plateau.getNourrices()  + " nourrices / " + plateau.getOuvrieres()  + " ouvrieres");
		System.out.println(j1.getPseudo()+" cree une ouvriere");
		plateau.naissanceOuvrieres(2); // Creer 1 ouvriere en utilisant 2 nourrices
		System.out.println(j1.getPseudo() + " => " + plateau.getLarves()  + " larve / " + plateau.getNourrices()  + " nourrices / " + plateau.getOuvrieres()  + " ouvrieres");
		
		// OUVRIERES
		System.out.println("\nPhase ouvrieres !");
		System.out.println(j1.getPseudo()+" place une ouvriere sur le niveau 0 de la fourmillere");
		plateau.placerOuvriereFourmiliere(0);
		System.out.println(j1.getPseudo()+" recupere 1 larve ");
		plateau.genereRessourceFourmiliere();
		System.out.println(j1.getPseudo() + " => " + plateau.getLarves()  + " larve / " + plateau.getNourrices()  + " nourrices / " + plateau.getOuvrieres()  + " ouvrieres");
	
		// AMELIORER 
		System.out.println("\nAmeliorer fourmiliere");
		plateau.ameliorerFourmiliere();
	}
	
}
