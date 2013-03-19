package fr.unice.polytech.si3.tse.ttan.plateauIndividuel;

/**
 * Cette classe instancie toutes les d�pendances n�cessaires pour le lancemenet d'un plateau indidivuel.
 * La classe effectue le lien entre l'IA et les �l�ments du plateau individuel 
 * (fourmis, salles, fourmiliere, gestion d'evenements...).
 * 
 * Apres instanciation de cette classe, on peut acceder a l'ensemble des elements du plateau. De plus,
 * la classe permet d'avoir un plateau dans son etat initial (3 nourrices, 2 ouvrieres, 1 larve).
 * 
 * 
 * @author mazen, lavail
 */

import fr.unice.polytech.si3.tse.ttan.salles.SalleAtelier;
import fr.unice.polytech.si3.tse.ttan.salles.SalleLarve;
import fr.unice.polytech.si3.tse.ttan.salles.SalleNourrice;
import fr.unice.polytech.si3.tse.ttan.salles.SalleOuvriere;
import fr.unice.polytech.si3.tse.ttan.salles.SalleSoldat;
import fr.unice.polytech.si3.tse.ttan.salles.SalleStock;
import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

public class PlateauIndividuel {

	/* LES SALLES */
	private SalleAtelier salleAtelier;
	private SalleLarve salleLarve;
	private SalleNourrice salleNourrice;
	private SalleOuvriere salleOuvriere;
	private SalleSoldat salleSoldat;
	private SalleStock salleStock;

	/* LA FOURMILIERE */
	private Fourmiliere fourmiliere;

	public PlateauIndividuel() {

		// Initialisation des salles du plateau
		this.salleAtelier = new SalleAtelier();
		this.salleLarve = new SalleLarve();
		this.salleNourrice = new SalleNourrice();
		this.salleOuvriere = new SalleOuvriere();
		this.salleSoldat = new SalleSoldat();
		this.salleStock = new SalleStock();
		this.fourmiliere = new Fourmiliere();

		// Ajouter 3 nourrices, 2 ouvrieres, 1 larves
		this.salleNourrice.ajouterFourmi(3);
		this.salleOuvriere.ajouterFourmi(2);
		this.salleLarve.ajouterFourmi(1);

		// Evenement choisi al�atoirement
		int random = (int) (Math.random() * 9);
		if (random == 8)
			random--;
		Evenements.getInstance().setEvenementActif(
				Constantes.LISTE_EVENEMENTS[random]);

	}

	/* Gestion des naissances */

	public boolean naissanceLarves(int nbNourriceUtilisee) {
		return salleLarve.naissanceLarves(nbNourriceUtilisee, salleNourrice);
	}

	public boolean naissanceOuvrieres(int nbNourriceUtilisee) {
		return salleOuvriere.naissanceOuvrieres(nbNourriceUtilisee, salleNourrice);
	}
	
	public boolean naissanceSoldats(int nbNourriceUtilisee) {
		return salleSoldat.naissanceSoldats(nbNourriceUtilisee, salleNourrice);
	}

	/**
	 * Placer une nourrice dans un atelier necessite de preciser sur quel
	 * evenement on souhaite placer la nourrice.
	 */
	public boolean placerNourriceAtelier(int indiceEvenement) {
		
		if (salleNourrice.getNbCourantFourmi() < 1) {
			System.out.println("Pas assez de nourrices.");
		}
		if (salleAtelier.ajouteNourrice(indiceEvenement)) {
			salleNourrice.supprimerFourmi();
			return true;
		} else {
			System.out.println("Un probleme est survenu");
			return false;
		}
	}

	/* FOURMILIERE */

	public boolean genereRessourceFourmiliere() {
		return fourmiliere.genererRessources(salleLarve, salleStock);
	}

	public boolean ameliorerFourmiliere() {
		return fourmiliere.ameliorerFourmiliere(salleAtelier);
	}

	public boolean placerOuvriereFourmiliere(int etage) {
		return fourmiliere.placerOuvriere(etage, salleOuvriere);
	}

	/* EVENEMENTS */

	public boolean decallerEvenement(int nombreDeDecallage, char cote) {
		return Evenements.getInstance().decallerEvenement(nombreDeDecallage, cote, salleLarve);
	}

	/* GETTERS */

	public SalleAtelier getSalleAtelier() {return salleAtelier;}

	public SalleLarve getSalleLarve() {return salleLarve;}

	public SalleNourrice getSalleNourrice() {return salleNourrice;}

	public SalleOuvriere getSalleOuvriere() {return salleOuvriere;}

	public SalleSoldat getSalleSoldat() {return salleSoldat;}

	public SalleStock getSalleStock() {return salleStock;}

	public Fourmiliere getFourmiliere() {return fourmiliere;}

	public int getNourrices() {return this.salleNourrice.getNbCourantFourmi();}

	public int getOuvrieres() {return this.salleOuvriere.getNbCourantFourmi();}

	public int getLarves() {return this.salleLarve.getNbCourantFourmi();}
}
