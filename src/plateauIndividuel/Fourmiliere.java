package plateauIndividuel;

import utils.Constantes;

/**
 * La classe fourmiliere representera les niveaux de la fourmilière
 * @author achabert
 *
 */

public class Fourmiliere 
{
	/**
	 * Les attributs de la fourmilière,
	 * on doit representer le niveau maximal de la fourmiliere accessible au joueur,
	 * et le nombre d'ouvrières travaillant dans chaque niveau.
	 * Puisque seul une ouvrière peut travailler dans un niveau,
	 * nous avons choisi d'utiliser des booleens.
	 */
	public boolean[] niveauxFourmiliere = new boolean[Constantes.NIVEAU_FOURMILIERE_MAX];
	public int niveauMaximumCourant;
	
	/**
	 * Constructeurs
	 */
	
	/**
	 * Constructeur à deux paramètres
	 * @param niveauxFourmiliere
	 * @param niveauMaximumCourant
	 */
	public Fourmiliere(boolean niveauxFourmiliere[], int niveauMaximumCourant)
	{
		this.niveauxFourmiliere=niveauxFourmiliere;
		this.niveauMaximumCourant = niveauMaximumCourant;
	}
	
	/**
	 * Constructeur sans paramètres
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
	 * Accesseurs en écriture
	 */
	
	/**
	 * Accesseur en écriture du niveauMaximumCourant
	 * @param entier
	 */
	public void setNiveauMaximumCourant(int nouveauNiveauMaximumCourant)
	{
		this.niveauMaximumCourant = nouveauNiveauMaximumCourant;
	}
	
	/**
	 * Accesseur en écriture du tableau de niveaux
	 */
	public void setNiveauxFourmiliere(boolean[] nouveauNiveauxFourmiliere)
	{
		this.niveauxFourmiliere = nouveauNiveauxFourmiliere;
	}
}
