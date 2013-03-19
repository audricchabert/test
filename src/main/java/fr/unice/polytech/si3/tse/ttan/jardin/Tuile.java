package fr.unice.polytech.si3.tse.ttan.jardin;

	/**
	 * La tuile repr�sente une des cases du jardin. Elles contiennent un type, peuvent recevoir des ph�romones 
	 * et sont utilis�es pour d�terminer les d�placements des fourmis � l'�xterieur de leur fourmili�re
	 * @author achabert
	 *
	 */

public class Tuile
{
	/**
	 * Attributs de la classe, l'abscisse et l'ordonn�e seront utilis�s pour localiser la tuile dans le jardin
	 * ainsi que pour d�cider de l'adjacences de deux cases.
	 * Le type d�crit toutes les possibilit�s de cases, et servira pour les d�placements,
	 * les d�placements et la r�colte de ressources
	 */
	private int abscisse, ordonnee;
	private String type;
	private Evenement evenement;
	
	
	/**
	 * Constructeur generique
	 * @param abscisse
	 * @param ordonnee
	 * @param type
	 * @param evenement
	 */
	public Tuile( int abscisse, int ordonnee, String type, Evenement evenement)
		{
			this.type = type;
			this.abscisse = abscisse;
			this.ordonnee = ordonnee;
			this.evenement = evenement;
		}
	/**
	 * Accesseurs en �criture
	 * @return Evenement
	 */
	public Evenement getEvenement()
		{
			return evenement;
		}
	
	/**
	 * Accesseur en ecriture
	 * @param Evenement
	 */
	public void setEvenement(Evenement evenement)
		{
			this.evenement = evenement;
		}
	
	/**
	 * Accesseur en lecture
	 * retourne l'abscisse de la case
	 * @return Abscisse
	 */
	public int getAbscisse()
		{
			return abscisse;
		}
	/**
	 * Accesseur en ecriture
	 * redefinit l'abscisse
	 * @param abscisse
	 */
	public void setAbscisse(int abscisse)
		{
			this.abscisse = abscisse;
		}

	/**
	 * Accesseur en lecture
	 * retourne l'ordonnee de la case
	 * @return Ordonnee
	 */
	public int getOrdonnee()
		{
			return ordonnee;
		}
	
	/**
	 * Accesseur en ecriture
	 * redefinit l'ordonnee
	 *@param ordonnee
	 */
	public void setOrdonnee(int ordonnee)
		{
			this.ordonnee = ordonnee;
		}
	
	/**
	 * Accesseur en lecture
	 * retourne le type de la case
	 * @return type
	 */
	public String getType()
		{
			return type;
		}
	
	/**
	 * Accesseur en ecriture
	 * redefinit le type de case
	 * @param type
	 */
	public void setType( String type)
		{
			this.type= type;
		}
}
