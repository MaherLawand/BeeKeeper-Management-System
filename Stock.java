import java.sql.Date;

public class Stock extends BeeKeeper{
	private Date DateLogged;
	private int TotalNbOfJars;
	private int JarsFilledWithHoney;
	private int FoodUsed;
	private int DrugsUsed;
	public Date getDateLogged() {
		return DateLogged;
	}
	public Stock() {
		super();
		DateLogged =null;
		TotalNbOfJars = 0;
		JarsFilledWithHoney = 0;
		FoodUsed = 0;
		DrugsUsed = 0;
	}
	public Stock(Date dateLogged, int totalNbOfJars, int jarsFilledWithHoney, int foodInStock, int drugsInStock) {
		super();
		DateLogged = dateLogged;
		TotalNbOfJars = totalNbOfJars;
		JarsFilledWithHoney = jarsFilledWithHoney;
		FoodUsed = foodInStock;
		DrugsUsed = drugsInStock;
	}
	public void setDateLogged(Date dateLogged) {
		DateLogged = dateLogged;
	}
	public int getTotalNbOfJars() {
		return TotalNbOfJars;
	}
	public void setTotalNbOfJars(int totalNbOfJars) {
		TotalNbOfJars = totalNbOfJars;
	}
	public int getJarsFilledWithHoney() {
		return JarsFilledWithHoney;
	}
	public void setJarsFilledWithHoney(int jarsFilledWithHoney) {
		JarsFilledWithHoney = jarsFilledWithHoney;
	}
	public int getFoodUsed() {
		return FoodUsed;
	}
	public void setFoodUsed(int foodInStock) {
		FoodUsed = foodInStock;
	}
	public int getDrugsUsed() {
		return DrugsUsed;
	}
	public void setDrugsUsed(int drugsInStock) {
		DrugsUsed = drugsInStock;
	}
	public void HoneyInStock() {		
		 System.out.println(getJarsFilledWithHoney()*0.25 + " L");
	}
	public int NbOfEmptyJars() {
		return getTotalNbOfJars()-getJarsFilledWithHoney();
	}
	public void FoodInStock(int n) {
		// in main n = sales.getFoodBought
		System.out.print(n-getFoodUsed());
	}
	public void DrugsInStock(int n) {
		System.out.print(n-getDrugsUsed());
	}
	public int JarsUsed() {
		return JarsFilledWithHoney;
		
	}
	public void DisplayStock(int m , int n) {
		System.out.println("On " + getDateLogged() + ": \n In Stock: " + getTotalNbOfJars() + " jars \n" + getJarsFilledWithHoney() + " jars filled with honey \n" + getFoodUsed() + " Food used \n" + getDrugsUsed() + " Drugs Used \n" + JarsUsed() + " Jars Used \n" + NbOfEmptyJars() + " empty jars");
		FoodInStock(n);
		System.out.println(" Food in Stock");
		DrugsInStock(m);
		System.out.println(" Drugs in Stock");
		HoneyInStock();
	
	}
}
