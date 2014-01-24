package fr.unice.polytech.si3.tse.ttan.jardin;

	/**
	 * En cours de partie un joueur peut poser des tuiles pheromones sur les cases du jardin.
	 * Cette classe pheromone repr�sente une des cases formant une ph�romone.
	 * Elle d�rive de la classe Evenement, classe qui representera l'evenement courant d'une case(ou tuile) du jardin
	 * Un identifiant permet de les grouper, de plus, elles contiennent l'eventuelle ressource affectee.
	 * @author achabert
	 * 
	 */

public class Pheromone extends Evenement
{	
	
	private int identifiantPheromone;
	private Ressource ressource;
	
	/**
	 * Constructeur generique
	 * @param unIdentifiantTuile
	 * @param uneAbscisse
	 * @param uneOrdonnee
	 */
	public Pheromone(int identifiant)
		{
			this.identifiantPheromone = identifiant;
		}
	
	/**
	 * Accesseur en lecture
	 * sur l'identifiant de la pheromone
	 * @return identifiantPheromone
	 */
	public int getIdentifiantPheromone()
		{
			return identifiantPheromone;
		}
	
	/**
	 * Accesseur en lecture
	 * sur la ressource
	 * null decrit l'absence de ressource sur la pheromone
	 * @return
	 */
	public Ressource getRessource()
		{
			return ressource;
		}
	
	/**
	 * Accesseur en ecriture
	 * sur la ressource
	 * null decrit l'absence de ressource sur la pheromone.
	 * @param ressource
	 */
	public void setRessource( Ressource ressource)
		{
			this.ressource=ressource;
		}
	
	/**
	 * Si le joueur decide de recolter commme ressource de tuile pheromone cette case pheromone
	 * la fonction renvoit la ressource, et "supprime" celle-ci de la case
	 * @return Ressource
	 */
	public Ressource recolterRessource()
		{
			return this.ressource;
		}

}
