package plateauIndividuel;

/**
 * Cette classe modélisera le joueur
 * 
 * @author mazen
 */

public class Joueur {
	
	GestionSalles gs;
	String pseudo;
	
	public Joueur(String pseudo){
		this.gs = new GestionSalles();
		this.pseudo = pseudo;
	}

	public GestionSalles getGs() {
		return gs;
	}

	public String getPseudo() {
		return pseudo;
	}
	
}
