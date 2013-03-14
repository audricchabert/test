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

	public Tuile( int abscisse, int ordonnee, String type, Evenement evenement)
		{
			this.type = type;
			this.abscisse = abscisse;
			this.ordonnee = ordonnee;
			this.evenement = evenement;
		}

	public Evenement getEvenement()
		{
			return evenement;
		}

	public void setEvenement(Evenement evenement)
		{
			this.evenement = evenement;
		}

	public int getAbscisse()
		{
			return abscisse;
		}

	public void setAbscisse(int abscisse)
		{
			this.abscisse = abscisse;
		}

	public int getOrdonnee()
		{
			return ordonnee;
		}

	public void setOrdonnee(int ordonnee)
		{
			this.ordonnee = ordonnee;
		}
	
	public String getType()
		{
			return type;
		}
	
	public void setType( String type)
		{
			this.type= type;
		}
}
