package plateauIndividuel;

/**
 * Cette classe modelisera le joueur
 * 
 * @author mazen
 */

public class Joueur {
	
	PlateauIndividuel plateauIndividuel;
	String pseudo;
	
	public Joueur(String pseudo){
		this.plateauIndividuel = new PlateauIndividuel();
		this.pseudo = pseudo;
	}

	public PlateauIndividuel getPlateauIndividuel() {
		return plateauIndividuel;
	}

	public String getPseudo() {
		return pseudo;
	}
	
}
