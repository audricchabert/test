package jardin;


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
