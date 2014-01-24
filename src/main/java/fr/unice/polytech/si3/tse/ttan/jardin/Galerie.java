package fr.unice.polytech.si3.tse.ttan.jardin;

	/**
	 * La galerie repr�sente un point de sortie d'une fourmili�re. La galerie mod�lise le jeton. 
	 * Le nom du joueur possedant cette sortie est stocke dans cet evenement.
	 * @author achabert
	 *
	 */

public class Galerie extends Evenement
{
	private String identifiantJoueur;
	
	public Galerie( String unIdentifiantJoueur)
		{
			this.identifiantJoueur=unIdentifiantJoueur;
		}
	
	public Galerie ()
		{
			this("");
		}
	
	public String getIdentifiantJoueur()
		{
			return identifiantJoueur;
		}
	
	public void setIdentifiantJoueur( String unIdentifiantJoueur)
		{
			this.identifiantJoueur=unIdentifiantJoueur;
		}
}
