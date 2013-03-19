package jardin;

/**
 * Cette abstraite classe modélise les cubes de ressources. Les types seront précisées dans ses sous-classes
 * @author achabert
 *
 */

public class Ressource
{
	private String identifiant;
	
	public Ressource( String unIdentifiant)
		{
			this.identifiant=unIdentifiant;
		}
	public Ressource()
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
