package fr.unice.polytech.si3.tse.ttan.utils;

/**
 * Constantes du projet
 * 
 * Une classe qui ne contient que des constructeurs private
 * doit être défini final
 * 
 * @author mazen
 */

public final class Constantes {
	
	/**
	 * Les evenements
	 */
	public static final String EVEN_NIVEAU = "Niveau+1";
	public static final String EVEN_PV = "PV+1";
	public static final String EVEN_LARVE = "Larve+2";
	public static final String EVEN_RECOLTE = "Recolte+3";
	public static final String EVEN_DEPLACEMENT = "Deplacement+3";
	public static final String EVEN_SOLDAT = "Soldat+1";
	public static final String EVEN_PHEROMONE = "Pheromone+1";
	public static final String EVEN_OUVRIERES = "Ouvriere+1";
	
	/**
	 * Les types de ressources
	 */
	public static final String RESS_LARVE = "Larve";
	public static final String RESS_TERRE = "Terre";
	public static final String RESS_NOURRITURE = "Nourriture";
	public static final String RESS_PIERRE = "Pierre";
	/* Salle ouvrière */
	
	
	/**
	 * EVENEMENTS
	 */
	
	public static final int NOMBRE_EVENEMENTS = 8;
	public static final String[] LISTE_EVENEMENTS = {EVEN_NIVEAU, EVEN_PV, EVEN_LARVE, EVEN_RECOLTE, EVEN_DEPLACEMENT, EVEN_SOLDAT, EVEN_PHEROMONE, EVEN_OUVRIERES};
	
	// Indices pour evenements
	public static final int NOUVELLE_GALERIE = 0;
	public static final int AMELIORER_FOURMILIERE = 1;
	public static final int CREER_NOURRICE = 2;
	public static final int OBJECTIF = 3;
	
	//Mouvements
	public static final char DROITE = 'd';
	public static final char GAUCHE = 'g';
	
	/**
	 * Nombre maximum de fourmis m�me temps dans une salle
	 * Classe : salle.java
	 */
	public static final int NB_FOURMILIERE_PAR_SALLE_MAX = 30;
	
	
	/**
	 * Les constantes de la classe fourmiliere
	 */
	public static final int NIVEAU_FOURMILIERE_MAX = 4;

	/**
	 *  On doit définir le constructeur en mode private car 
	 *  cette classe ne contient que des variable constantes
	 *  et ne doit pas être instancié
	 */
	
	private Constantes(){};
}
