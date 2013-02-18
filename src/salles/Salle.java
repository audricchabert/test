package salles;

public class Salle {
	
	private byte nbCourantFourmi;
	
	public Salle(){
		this.nbCourantFourmi = 0;
	}
	
	boolean ajouterFourmi(){
		return ajouterFourmi(1);
	}
	
	boolean ajouterFourmi(int i){
		
		if(i > 0){
			
			this.nbCourantFourmi += i;
			return true;
		}else{
			
			return false;
		}
	}
	
	//.. ETC
}
