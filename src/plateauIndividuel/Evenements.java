/**
 * Cette classe impl�mente le pattern Singleton.
 */
package plateauIndividuel;

import java.util.LinkedHashMap;

import salles.SalleLarve;
import utils.Constantes;

/**
 * @author Antoine Lavail
 *
 */
public class Evenements {

	private LinkedHashMap<String, Boolean> listeEvenements;

	/**
	 *  Constructeur par defaut
	 */
	private Evenements() {
		listeEvenements = new LinkedHashMap<String, Boolean>(7);
		listeEvenements.put(Constantes.EVEN_NIVEAU, new Boolean(false));
		listeEvenements.put(Constantes.EVEN_PV, new Boolean(false));
		listeEvenements.put(Constantes.EVEN_LARVE, new Boolean(false));
		listeEvenements.put(Constantes.EVEN_RECOLTE, new Boolean(false));
		listeEvenements.put(Constantes.EVEN_DEPLACEMENT, new Boolean(false));
		listeEvenements.put(Constantes.EVEN_SOLDAT, new Boolean(false));
		listeEvenements.put(Constantes.EVEN_PHEROMONE, new Boolean(false));
		listeEvenements.put(Constantes.EVEN_OUVRIERES, new Boolean(false));
	}

	public LinkedHashMap<String, Boolean> getListeEvenements() {
		return listeEvenements;
	}

	private static class EvenementsHolder
	{
		private final static Evenements instance = new Evenements();
	}

	public static Evenements getInstance() {
		return EvenementsHolder.instance;
	}

	/**
	 * Methode permettant de modifier un evenement (passer de EVEN_LARVE a EVEN_PV par exemple).
	 * @param evenement: le nouvel evenement
	 * @return: true si tout s'est bien passe. False sinon.
	 */
	public boolean setEvenementActif(String evenement) {

		if (listeEvenements.containsKey(evenement)) {
			if (getEvenementCourant() != null) {
				listeEvenements.put(getEvenementCourant(), false);
				listeEvenements.put(evenement, new Boolean(true));
				return true;
			}
			else {
				listeEvenements.put(evenement, new Boolean(true));
				return true;
			}
		}
		return false;
	}

	/**
	 * La fonction decallerEvenement prendra en parametre un caractere 
	 * qui correspondra au mouvement voulu et un nombre correspondant au nombre de decallage.
	 *  On pourra avoir 2 mouvements "Droite" ou "Gauche". 
	 * Chaque deplacement entrainant un changement d'evenement 
	 */
	public boolean decallerEvenement(int nombreDeDecallage, char cote, SalleLarve sl) {

		if(nombreDeDecallage <= 0){
			System.out.println("Probleme evenements: superieur a 0 requis");
			return false;
		}
		
		// Verification du nombre de larves
		if( (sl.getNbCourantFourmi() - nombreDeDecallage) < 0){
			System.out.println("Probleme evenements : pas assez de larves");
			return false;
		}
		
		// Modification Evenement
		int indexEvenementCourant = 0;
		for (int i = 0; i < Constantes.LISTE_EVENEMENTS.length; i++) {
			if (getEvenementCourant().equals(Constantes.LISTE_EVENEMENTS[i])) {
				indexEvenementCourant = i;
			}
		}
		if (cote == Constantes.DROITE) {
			sl.supprimerFourmi(nombreDeDecallage);
			setEvenementActif(Constantes.LISTE_EVENEMENTS[indexEvenementCourant + nombreDeDecallage]);
			return true;
		}
		if (cote == Constantes.GAUCHE) {
			sl.supprimerFourmi(nombreDeDecallage);
			setEvenementActif(Constantes.LISTE_EVENEMENTS[indexEvenementCourant - nombreDeDecallage]);
			return true;
		}
		return false;
	}

	/**
	 * Recupere l'evenement courant dans la partie.
	 * @return le string correspondant a l'evenement active. Null si aucun evenement (bug)
	 */
	public String getEvenementCourant() {
		for (String mapKey : listeEvenements.keySet()) {
			if (listeEvenements.get(mapKey))
				return mapKey;
		}
		return null;
	}
}
