package salles;

public class Salle {
	
	private byte nbCourantFourmi;
	
	public Salle(){
		this.nbCourantFourmi = 0;
	}
	
	public boolean ajouterFourmi(){
		return ajouterFourmi(1);
	}
	
	public boolean ajouterFourmi(int i) {
		
		if(i > 0) {
			
			this.nbCourantFourmi += i;
			return true;
		}
		else
			return false;
	}
	
	public boolean supprimerFourmi() {
		return supprimerFourmi(1);
	}
	
	public boolean supprimerFourmi(int i) {
		
		if (i > 0) {
			
			this.nbCourantFourmi -= i;
			return true;
		}
		else
			return false;
	}

	public byte getNbCourantFourmi() {
		return nbCourantFourmi;
	}

	public void setNbCourantFourmi(byte nbCourantFourmi) {
		this.nbCourantFourmi = nbCourantFourmi;
	}
}
