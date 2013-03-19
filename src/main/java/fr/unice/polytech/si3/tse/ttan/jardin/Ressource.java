package fr.unice.polytech.si3.tse.ttan.jardin;

/**
 * Cette abstraite classe mod�lise les cubes de ressources. Les types seront pr�cis�es dans ses sous-classes
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
