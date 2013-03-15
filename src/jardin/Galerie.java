package jardin;

	/**
	 * La galerie représente un point de sortie d'une fourmilière. La galerie modélise le jeton. 
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
