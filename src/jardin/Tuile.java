package jardin;


	/**
	 * La tuile représente une des cases du jardin. Elles contiennent un type, peuvent recevoir des phéromones 
	 * et sont utilisées pour déterminer les déplacements des fourmis à l'éxterieur de leur fourmilière
	 * @author achabert
	 *
	 */

public class Tuile
{
	/**
	 * Attributs de la classe, l'abscisse et l'ordonnée seront utilisés pour localiser la tuile dans le jardin
	 * ainsi que pour décider de l'adjacences de deux cases.
	 * Le type décrit toutes les possibilités de cases, et servira pour les déplacements,
	 * les déplacements et la récolte de ressources
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
	 * Accesseurs en écriture
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
