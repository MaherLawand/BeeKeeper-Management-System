
public class QueenBee extends GeneralBees{
	public GeneralBees next;
	public QueenBee() {
		TypeOfQueenBee=false;
		EggLayingRate=0;
		LifeSpan=0;
		MedicalHealth="";
		next=null;
	}
	public QueenBee(boolean typeOfQueenBee, int eggLayingRate, int lifeSpan, String medicalHealth) {
		super();
		TypeOfQueenBee = typeOfQueenBee;
		EggLayingRate = eggLayingRate;
		LifeSpan = lifeSpan;
		MedicalHealth = medicalHealth;
		next=null;
	}
	public boolean getTypeOfQueenBee() {
		return TypeOfQueenBee;
	}
	public void setTypeOfQueenBee(boolean typeOfQueenBee) {
		TypeOfQueenBee = typeOfQueenBee;
	}
	public int getEggLayingRate() {
		return EggLayingRate;
	}
	public void setEggLayingRate(int eggLayingRate) {
		EggLayingRate = eggLayingRate;
	}
	public int getLifeSpan() {
		return LifeSpan;
	}
	public void setLifeSpan(int lifeSpan) {
		LifeSpan = lifeSpan;
	}
	public String getMedicalHealth() {
		return MedicalHealth;
	}
	public void setMedicalHealth(String medicalHealth) {
		MedicalHealth = medicalHealth;
	}
	public void display() {
		System.out.println(QueenBee.this);
	}
	
}
