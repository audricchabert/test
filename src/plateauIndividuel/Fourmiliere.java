package plateauIndividuel;

import utils.Constantes;

/**
 * La classe fourmiliere representera les niveaux de la fourmili�re
 * @author achabert
 *
 */

public class Fourmiliere 
{
	/**
	 * Les attributs de la fourmili�re,
	 * on doit representer le niveau maximal de la fourmiliere accessible au joueur,
	 * et le nombre d'ouvri�res travaillant dans chaque niveau.
	 * Puisque seul une ouvri�re peut travailler dans un niveau,
	 * nous avons choisi d'utiliser des booleens.
	 */
	public boolean[] niveauxFourmiliere = new boolean[Constantes.NIVEAU_FOURMILIERE_MAX];
	public int niveauMaximumCourant;
	
	/**
	 * Constructeurs
	 */
	
	/**
	 * Constructeur � deux param�tres
	 * @param niveauxFourmiliere
	 * @param niveauMaximumCourant
	 */
	public Fourmiliere(boolean niveauxFourmiliere[], int niveauMaximumCourant)
	{
		this.niveauxFourmiliere=niveauxFourmiliere;
		this.niveauMaximumCourant = niveauMaximumCourant;
	}
	
	/**
	 * Constructeur sans param�tres
	 */
	public Fourmiliere()
	{
		this(new boolean[Constantes.NIVEAU_FOURMILIERE_MAX],1);
	}
	
	/**
	 * Accesseurs en lecture
	 */
	
	/**
	 * Accesseur en lecture du niveauMaximumCourant
	 * @return niveauMaximumCourant
	 */
	public int getNiveauMaximumCourant()
	{
		return niveauMaximumCourant;
	}
	/**
	 * Accesseur en lecture du tableau de niveaux
	 * @return niveauxFourmiliere
	 */
	public boolean[] getNiveauxFourmiliere()
	{
		return niveauxFourmiliere;
	}
	
	/**
	 * Accesseurs en �criture
	 */
	
	/**
	 * Accesseur en �criture du niveauMaximumCourant
	 * @param entier
	 */
	public void setNiveauMaximumCourant(int nouveauNiveauMaximumCourant)
	{
		this.niveauMaximumCourant = nouveauNiveauMaximumCourant;
	}
	
	/**
	 * Accesseur en �criture du tableau de niveaux
	 */
	public void setNiveauxFourmiliere(boolean[] nouveauNiveauxFourmiliere)
	{
		this.niveauxFourmiliere = nouveauNiveauxFourmiliere;
	}
}
