package fr.unice.polytech.si3.tse.ttan.vues;

//import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Evenements;
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

	public void lancer() {
		// On va simuler 1 tour de plateau !
		
		/* NOS STRING */
		//String chaineLarve = " larve / ";
		//String chaineNourrice = " nourrices / ";
		//String chaineOuvrieres = " ouvrieres";
		
		// On cree notre joueur
		Joueur j1 = new Joueur("Joueur 1"); 
		PlateauIndividuel plateau = j1.getPlateauIndividuel();
		
		
		//System.out.println("Debut du tour");
		
		//System.out.println(j1.getPseudo() + " -> " + plateau.getLarves() + chaineLarve  +plateau.getNourrices() + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
		
		// PHASE EVENEMENT
		
		//System.out.println("\nPhase evenements !");
		//System.out.println("Evenement actuel : " + Evenements.getInstance().getEvenementCourant());
		//System.out.println(j1.getPseudo()+ " decalle l'evenement de 1 vers la droite");
		plateau.decallerEvenement(1, Constantes.DROITE);
		//System.out.println("Le nouvel evenement est : " + Evenements.getInstance().getEvenementCourant());
		//System.out.println(j1.getPseudo() + " =====> " + plateau.getLarves()  + chaineLarve + plateau.getNourrices()  + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
		
		// PHASE NAISSANCE
		//System.out.println("\nPhase naissance !");
		//System.out.println(j1.getPseudo()+" place une nourrice dans l'atelier sur l'evenement 'AMELIORER FOURMILIERE'");
		plateau.placerNourriceAtelier(Constantes.AMELIORER_FOURMILIERE);
		//System.out.println(j1.getPseudo() + " > " + plateau.getLarves()  + chaineLarve + plateau.getNourrices()  + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
		//System.out.println(j1.getPseudo()+" cree une ouvriere");
		
		// Creer 1 ouvriere en utilisant 2 nourrices
		plateau.naissanceOuvrieres(2); 
		//System.out.println(j1.getPseudo() + " ===> " + plateau.getLarves()  + chaineLarve + plateau.getNourrices()  + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
		
		// OUVRIERES
		//System.out.println("\nPhase "+chaineOuvrieres+" !");
		//System.out.println(j1.getPseudo()+" place une ouvriere sur le niveau 0 de la fourmillere");
		plateau.placerOuvriereFourmiliere(0);
		//System.out.println(j1.getPseudo()+" recupere 1 larve ");
		plateau.genereRessourceFourmiliere();
		//System.out.println(j1.getPseudo() + " ==> " + plateau.getLarves()  + chaineLarve + plateau.getNourrices()  + chaineNourrice + plateau.getOuvrieres()  + chaineOuvrieres);
	
		// AMELIORER 
		//System.out.println("\nAmeliorer fourmiliere");
		plateau.ameliorerFourmiliere();
		
		
	
	}
	
}
