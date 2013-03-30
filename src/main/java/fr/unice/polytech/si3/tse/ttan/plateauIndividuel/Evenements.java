/**
 * Cette classe impl�mente le pattern Singleton.
 */
package fr.unice.polytech.si3.tse.ttan.plateauIndividuel;

import java.util.LinkedHashMap;
import java.util.Map;

import fr.unice.polytech.si3.tse.ttan.utils.Constantes;
/**
 * @author Antoine Lavail
 *
 */
public final class Evenements {
 
	private Map<String, Boolean> listeEvenements;

	/**
	 *  Constructeur par defaut
	 */
	private Evenements() {
		listeEvenements = new LinkedHashMap<String, Boolean>(Constantes.NB_EVENEMENTS);
		listeEvenements.put(Constantes.EVEN_NIVEAU, Boolean.FALSE);
		listeEvenements.put(Constantes.EVEN_PV, Boolean.FALSE);
		listeEvenements.put(Constantes.EVEN_LARVE, Boolean.FALSE);
		listeEvenements.put(Constantes.EVEN_RECOLTE, Boolean.FALSE);
		listeEvenements.put(Constantes.EVEN_DEPLACEMENT, Boolean.FALSE);
		listeEvenements.put(Constantes.EVEN_SOLDAT, Boolean.FALSE);
		listeEvenements.put(Constantes.EVEN_PHEROMONE, Boolean.FALSE);
		listeEvenements.put(Constantes.EVEN_OUVRIERES, Boolean.FALSE);
	}

	public Map<String, Boolean> getListeEvenements() {
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
				listeEvenements.put(getEvenementCourant(), Boolean.FALSE);
				listeEvenements.put(evenement, Boolean.TRUE);
				return true;
			}
			else {
				listeEvenements.put(evenement,Boolean.TRUE);
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

		if(nombreDeDecallage <= 0) {
			throw new IllegalArgumentException(Constantes.EX_HORSRANGE);
		}
		
		// Verification du nombre de larves
		if( (sl.getNbCourantFourmi() - nombreDeDecallage) < 0) {
			throw new ExceptionLarves(Constantes.EX_MANQUELARVE);
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
			if (listeEvenements.get(mapKey)) {
				return mapKey;
			}
		}
		return null;
	}
}
