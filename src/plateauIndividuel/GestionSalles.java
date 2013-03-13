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
	
	private Fourmiliere fourmiliere;
	
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
		this.fourmiliere = new Fourmiliere();
		
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
	
	/*
	 * Placer une nourrice dans un atelier nécessite de préciser sur quel évenement
	 * on souhaite placer la nourrice. 
	 */
	
	public boolean placerNourriceAtelier(int indiceEvenement){
		int nbNourrices = salleNourrice.getNbCourantFourmi();
		
		if(indiceEvenement < 0 || indiceEvenement > 3){
			System.out.println("Indice inconnu");
			return false;
		}
		
		if(nbNourrices  < 1){
			System.out.println("Pas assez de nourrices!");
			return false;
		}else{
			
			if(this.salleAtelier.ajouteNourrice(indiceEvenement)){
				salleNourrice.supprimerFourmi();
				return true;
			}else{
				System.out.println("Un probleme est survenu");
				return false;
			}
		}
	}
	
	
	/* FOURMILIERE */
	
	/*
	 * La fonction genereRessourceFourmilliere va demander à la fourmilliere combien de ressource peuvent être 
	 * généré par rapport au nombre actuel de fourmi présent dans les niveaux. Fourmilliere renverra un tableau
	 * avec le nombre de ressources générées. Le tableau sera de la forme larve/nourriture/terre/pierre
	 * 
	 * il faudra gérer le choix du joueur pour le niveau 3. Il pourra on recuperer de la pierre, ou de la terre
	 */
	
	public boolean genereRessourceFourmiliere(){
		
		int tabRess[] = this.fourmiliere.genererRessources();
		
		int larve = tabRess[0]; // Ressources
		int nourriture = tabRess[1];
		int terre = tabRess[2];
		int pierre = tabRess[3];
		
		this.salleLarve.creerLarve(Constantes.LISTE_EVENEMENTS[this.indiceEvnt], larve);
		this.salleStock.ajouterRessource(Constantes.RESS_NOURRITURE, nourriture);
		this.salleStock.ajouterRessource(Constantes.RESS_TERRE, terre);
		this.salleStock.ajouterRessource(Constantes.RESS_PIERRE, pierre);
		
		return true;
	}
	
	/*
	 * Augmenter le niveau nécessite, selon s'il a posé une nourrice sur l'évenement de l'atelier
	 * ou non, il pourra améliorer la foumiliere
	 */
	
	public boolean ameliorerFourmiliere(){
		int niveauFourmActuel = this.fourmiliere.getNiveauMaximumCourant();
		
		if(niveauFourmActuel == 3){ // Rien ne sert d'aller plus haut
			return false;
		}
		
		if(this.salleAtelier.getEvenements()[Constantes.AMELIORER_FOURMILIERE]){ // Il doit y avoir une nourrice sur l'évenement
			this.fourmiliere.setNiveauMaximumCourant(niveauFourmActuel+1); // n met le niveau suivant a true
			// Puis retirer la nourrice de l'atelier
			this.salleAtelier.getEvenements()[Constantes.AMELIORER_FOURMILIERE] = false;
			return true;
		}else{
			return false; // Impossible, pas de nourrice sur l'évenement
		}
	}
	
	/*
	 * Placer une ouvrière sur un étage de la fourmilliere
	 */
	
	public boolean placerOuvriereFourmiliere(int etage){
		int niveauFourmActuel = this.fourmiliere.niveauMaximumCourant;
		if(etage<0 || etage>3){
			System.out.println("Hors range");
			return false;
		}
		
		if(etage > niveauFourmActuel){ // Vérifier qu'on à accés à cet étage
			System.out.println("La fourmiliere n'a pas ce niveau");
			return false;
		}else if(this.fourmiliere.getNiveauxFourmiliere()[etage]){ // Vérifier qu'il n'y a pas déja une fourmi dans cet étage
			System.out.println("Cet étage de la fourmilière est déja occupé");
			return false;
		}else if(this.salleOuvriere.getNbCourantFourmi() < 1){ // Vérifier qu'on à assez d'ouvrières
			System.out.println("Pas assez d'ouvrières");
			return false;
		}else{ // C'est bon
			salleOuvriere.supprimerFourmi();
			this.fourmiliere.getNiveauxFourmiliere()[etage] = true;
			
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
			System.out.println("Probleme evenements: superieur a 0 requis");
			return false;
		}
		
		// Verification nombre de larves
		int nbLarves = this.salleLarve.getNbCourantFourmi();
		
		if( (nbLarves - nbDecal) < 0){
			System.out.println("Probleme evenements : pas assez de larves");
			return false;
		}
		
		// Modification evenement
		if(cote == Constantes.GAUCHE){
			
			if( (this.indiceEvnt - nbDecal) < 0){ 
				System.out.println("Decallage vers la gauche impossible!");
				return false;
			}else{
				this.salleLarve.supprimerFourmi(nbDecal);
				this.indiceEvnt -= nbDecal;
				return true;
			}
			
		}else if(cote == Constantes.DROITE){
			
			if( (this.indiceEvnt + nbDecal) >= Constantes.NOMBRE_EVENEMENTS){ 
				System.out.println("Decallage vers la droite impossible!");
				return false;
			}else{
				this.salleLarve.supprimerFourmi(nbDecal);
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
	
	public Fourmiliere getFourmiliere(){
		return fourmiliere;
	}
	
	public int getNourrices(){
		return this.salleNourrice.getNbCourantFourmi();
	}
	
	public int getOuvrieres(){
		return this.salleOuvriere.getNbCourantFourmi();
	}
	
	public int getLarves(){
		return this.salleLarve.getNbCourantFourmi();
	}
	
	public String getEvenementActuel(){
		return Constantes.LISTE_EVENEMENTS[this.indiceEvnt];
	}
}
