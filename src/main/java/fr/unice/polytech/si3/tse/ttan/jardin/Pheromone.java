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
	/**
	 * Attributs de la classe Pheromone.
	 * Un compteur statique servira a garder un compte des pheromones mises en jeu.
	 * Ce compte servira aussi pour donner un identifiant a la tuile(l'ensemble de case) pheromone cible.
	 * L'identifiant ainsi que la ressource de la case pheromone sont declares ci dessous.
	 */
	public static int compteurIdentifiantPheromone=0;
	private int identifiantPheromone;
	private Ressource ressource;
	
	/**
	 * Constructeur generique
	 * @param unIdentifiantTuile
	 * @param uneAbscisse
	 * @param uneOrdonnee
	 */
	public Pheromone(int unIdentifiantTuile[], int uneAbscisse, int uneOrdonnee)
		{
			this.identifiantPheromone=compteurIdentifiantPheromone;
			compteurIdentifiantPheromone=compteurIdentifiantPheromone+1;
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
			Ressource ressource=this.ressource;
			this.ressource=null;
			return ressource;
		}
}
