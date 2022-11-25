import java.io.Serializable;

public class Bee extends GeneralBees implements Serializable{
	public GeneralBees next;
	public Bee() {
		TypeOfBee="";
		EfficiencyOfBee=0;
		LifeSpan=0;
		EstimatesNbOfBees=0;
		next=null;
	}
	public Bee(String typeOfBee, int efficiencyOfBee, int lifeSpan, int estimatesNbOfBees) {
		super();
		TypeOfBee = typeOfBee;
		EfficiencyOfBee = efficiencyOfBee;
		LifeSpan = lifeSpan;
		EstimatesNbOfBees = estimatesNbOfBees;
		next=null;
	}
	public String getTypeOfBee() {
		return TypeOfBee;
	}
	public void setTypeOfBee(String typeOfBee) {
		TypeOfBee = typeOfBee;
	}
	public int getEfficiencyOfBee() {
		return EfficiencyOfBee;
	}
	public void setEfficiencyOfBee(int efficiencyOfBee) {
		EfficiencyOfBee = efficiencyOfBee;
	}
	public int getLifeSpan() {
		return LifeSpan;
	}
	public void setLifeSpan(int lifeSpan) {
		LifeSpan = lifeSpan;
	}
	public int getEstimatesNbOfBees() {
		return EstimatesNbOfBees;
	}
	public void setEstimatesNbOfBees(int estimatesNbOfBees) {
		EstimatesNbOfBees = estimatesNbOfBees;
	}
	public void display() {
		System.out.println(Bee.this);
	}

	
}


