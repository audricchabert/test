package fr.unice.polytech.si3.tse.ttan.plateauIndividuel;

/**
 * Cette classe modelisera le joueur
 * 
 * @author mazen
 */

public class Joueur {
	
	private PlateauIndividuel plateauIndividuel;
	private String pseudo;
	
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
