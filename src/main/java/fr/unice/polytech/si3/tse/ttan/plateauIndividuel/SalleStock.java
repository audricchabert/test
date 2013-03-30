/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan.plateauIndividuel;

import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

/**
 * @author Antoine Lavail
 * 
 * Cette classe ne stocke aucune fourmi.
 *
 */
public class SalleStock extends Salle {

	private byte nbPierre;
	private byte nbNourriture;
	private byte nbTerre;

	/**
	 * @return the nbPierre
	 */
	public byte getNbPierre() {
		return nbPierre;
	}

	/**
	 * @return the nbNourriture
	 */
	public byte getNbNourriture() {
		return nbNourriture;
	}

	/**
	 * @return the nbTerre
	 */
	public byte getNbTerre() {
		return nbTerre;
	}

	public boolean ajouterRessource(String typeRessource, int nombre) {
		if (nombre > 0) {
			if(typeRessource.equals(Constantes.RESS_NOURRITURE)) {
				nbNourriture += nombre;
				return true;
			}
			if(typeRessource.equals(Constantes.RESS_PIERRE)) {
				nbPierre += nombre;
				return true;
			}
			if(typeRessource.equals(Constantes.RESS_TERRE)) {
				nbTerre += nombre;
				return true;
			}
		}
		return false;
	}

	public boolean supprimerRessource(String typeRessource, int nombre) {
		if (nombre > 0) {
			if(typeRessource.equals(Constantes.RESS_NOURRITURE)) {
				if (nbNourriture - nombre < 0) {
					return false;
				}
				nbNourriture -= nombre;
				return true;
			}
			if(typeRessource.equals(Constantes.RESS_PIERRE)) {
				if (nbPierre - nombre < 0) {
					return false;
				}
				nbPierre -= nombre;
				return true;
			}
			if(typeRessource.equals(Constantes.RESS_TERRE)) {
				if (nbTerre - nombre < 0) {
					return false;
				}
				nbTerre -= nombre;
				return true;
			}
		}
		return false;

	}

	/**
	 * La salle stock ne stocke pas de fourmis
	 */
	@Override
	public boolean ajouterFourmi() {
		// Ne rien faire
		return false;
	}

	@Override
	public boolean ajouterFourmi(int i) {
		// Ne rien faire
		return false;
	}

	@Override
	public boolean supprimerFourmi() {
		// Ne rien faire
		return false;
	}

	@Override
	public boolean supprimerFourmi(int i) {
		// Ne rien faire
		return false;
	}
}
