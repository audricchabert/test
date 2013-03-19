package jardin;

	/**
	 * Cette classe abstraite regroupe tous les éléments composant le jardin, qui fera partie du plateau extérieur.
	 * @author achabert
	 *
	 */

public abstract class Element
{
	//attributs à changer
	String identifiant;
	
	public Element( String unIdentifiant)
		{
			this.identifiant=unIdentifiant;
		}
	
	public Element()
		{
			this("");
		}
	
	public String getIdentifiant()
		{
			return identifiant;
		}
	
	public void setIdentifiant( String unIdentifiant)
		{
			this.identifiant=unIdentifiant;
		}
}
