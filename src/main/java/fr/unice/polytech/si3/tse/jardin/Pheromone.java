package jardin;

	/**
	 * Cette classe pheromone représente une des cases formant une phéromone
	 * Un identifiant permet de les grouper
	 * @author achabert
	 *
	 */

public class Pheromone extends Evenement
{
	public static int compteurIdentifiantPheromone=0;
	private int identifiantPheromone;
	private Ressource ressource;
	
	public Pheromone(int unIdentifiantTuile[], int uneAbscisse, int uneOrdonnee)
		{
			this.identifiantPheromone=compteurIdentifiantPheromone;
			compteurIdentifiantPheromone=compteurIdentifiantPheromone+1;
		}
	
	public int getIdentifiantPheromone()
		{
			return identifiantPheromone;
		}
	
	public Ressource getRessource()
		{
			return ressource;
		}
	
	public void setRessource( Ressource ressource)
		{
			this.ressource=ressource;
		}
	
	public Ressource recolterRessource()
		{
			Ressource ressource=this.ressource;
			this.ressource=null;
			return ressource;
		}
}
