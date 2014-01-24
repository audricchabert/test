package fr.unice.polytech.si3.tse.ttan.vues;

import java.io.PrintStream;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Evenements;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.PlateauIndividuel;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Joueur;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

/**
 * Vue console, gerera l'affichage des donnees/ interaction client
 * 
 * @author mazen
 */

public class Console {
	
	public Console(){
		
		this.lancer();
	}

	private void lancer() {
		// On va simuler 1 tour de plateau !
		
		/* NOS STRING */
		String chaineLarve = " larve / ";
		String chaineNourrice = " nourrices / ";
		String chaineOuvrieres = " ouvrieres";
		
		// Out
		PrintStream out=System.out;
		
		// On cree notre joueur
		Joueur j1 = new Joueur("Joueur 1"); 
		PlateauIndividuel plateau = j1.getPlateauIndividuel();
		
		
		out.println("Debut du tour");
		
		out.println(j1.getPseudo() + " -> " + plateau.getLarves() + chaineLarve  +plateau.getNourrices() + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
		
		// PHASE EVENEMENT
		
		out.println("\nPhase evenements !");
		out.println("Evenement actuel : " + Evenements.getInstance().getEvenementCourant());
		out.println(j1.getPseudo()+ " decalle l'evenement de 1 vers la droite");
		plateau.decallerEvenement(1, Constantes.DROITE);
		out.println("Le nouvel evenement est : " + Evenements.getInstance().getEvenementCourant());
		out.println(j1.getPseudo() + " =====> " + plateau.getLarves()  + chaineLarve + plateau.getNourrices()  + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
		
		// PHASE NAISSANCE
		out.println("\nPhase naissance !");
		out.println(j1.getPseudo()+" place une nourrice dans l'atelier sur l'evenement 'AMELIORER FOURMILIERE'");
		plateau.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE);
		out.println(j1.getPseudo() + " > " + plateau.getLarves()  + chaineLarve + plateau.getNourrices()  + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
		out.println(j1.getPseudo()+" cree une ouvriere");
		
		// Creer 1 ouvriere en utilisant 2 nourrices
		plateau.naissanceOuvrieres(2); 
		out.println(j1.getPseudo() + " ===> " + plateau.getLarves()  + chaineLarve + plateau.getNourrices()  + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
		
		// OUVRIERES
		out.println("\nPhase "+chaineOuvrieres+" !");
		out.println(j1.getPseudo()+" place une ouvriere sur le niveau 0 de la fourmillere");
		plateau.placerOuvriereFourmiliere(0);
		out.println(j1.getPseudo()+" recupere 1 larve ");
		plateau.genereRessourceFourmiliere();
		out.println(j1.getPseudo() + " ==> " + plateau.getLarves()  + chaineLarve + plateau.getNourrices()  + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
	
		// AMELIORER 
		out.println("\nAmeliorer fourmiliere");
		plateau.ameliorerFourmiliere();
		
		
	
	}
	
}
