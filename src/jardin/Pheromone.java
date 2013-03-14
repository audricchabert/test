package jardin;

	/**
	 * Cette classe pheromone représente une des cases formant une phéromone
	 * Un identifiant permet de les grouper
	 * @author achabert
	 *
	 */

public class Pheromone
{
	public static int compteurIdentifiantPheromone=0;
	private int identifiantPheromone, abscisse, ordonnee;
	
	public Pheromone(int unIdentifiantTuile[], int uneAbscisse, int uneOrdonnee)
		{
			this.identifiantPheromone=compteurIdentifiantPheromone;
			compteurIdentifiantPheromone=compteurIdentifiantPheromone+1;
			this.abscisse=uneAbscisse;
			this.ordonnee=uneOrdonnee;
		}
	
	public int getIdentifiantPheromone()
		{
			return identifiantPheromone;
		}
	
	public int getAbscisse()
		{
			return abscisse;
		}
	
	public int getOrdonne()
		{
			return ordonnee;
		}
	
	public void setAbscisse( int uneAbscisse)
		{
			this.abscisse=uneAbscisse;
		}
	
	public void setOrdonee( int uneOrdonne)
		{
			this.ordonnee=uneOrdonne;
		}
}
