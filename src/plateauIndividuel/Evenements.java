/**
 * Cette classe impl�mente le pattern Singleton.
 */
package plateauIndividuel;

import java.util.LinkedHashMap;
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

	public boolean modifierEvenement(String evenement, boolean valeur) {
		if (listeEvenements.containsKey(evenement)) {
			listeEvenements.put(evenement, valeur);
			return true;
		}
		return false;
	}
}
