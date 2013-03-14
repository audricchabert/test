package jardin;

	/**
	 * La galerie représente un point de sortie d'une fourmilière. La galerie modélise le jeton. 
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
