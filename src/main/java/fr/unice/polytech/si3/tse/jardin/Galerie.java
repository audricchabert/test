package jardin;

	/**
	 * La galerie repr�sente un point de sortie d'une fourmili�re. La galerie mod�lise le jeton. 
	 * @author achabert
	 *
	 */

public class Galerie
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
