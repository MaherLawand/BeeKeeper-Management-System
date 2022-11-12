
public class QueenBee {
	private String TypeOfQueenBee;
	private int EggLayingRate;
	private int LifeSpan;
	private String MedicalHealth;
	public QueenBee() {
		TypeOfQueenBee="";
		EggLayingRate=0;
		LifeSpan=0;
		MedicalHealth="";
	}
	public QueenBee(String typeOfQueenBee, int eggLayingRate, int lifeSpan, String medicalHealth) {
		super();
		TypeOfQueenBee = typeOfQueenBee;
		EggLayingRate = eggLayingRate;
		LifeSpan = lifeSpan;
		MedicalHealth = medicalHealth;
	}
	public String getTypeOfQueenBee() {
		return TypeOfQueenBee;
	}
	public void setTypeOfQueenBee(String typeOfQueenBee) {
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
	
}
