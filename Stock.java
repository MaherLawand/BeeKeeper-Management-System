import java.sql.Date;

public class Stock {
	private Date DateLogged;
	private int TotalNbOfJars;
	private int JarsFilledWithHoney;
	private int FoodInStock;
	private int DrugsInStock;
	public Date getDateLogged() {
		return DateLogged;
	}
	public Stock() {
		super();
		DateLogged =null;
		TotalNbOfJars = 0;
		JarsFilledWithHoney = 0;
		FoodInStock = 0;
		DrugsInStock = 0;
	}
	public Stock(Date dateLogged, int totalNbOfJars, int jarsFilledWithHoney, int foodInStock, int drugsInStock) {
		super();
		DateLogged = dateLogged;
		TotalNbOfJars = totalNbOfJars;
		JarsFilledWithHoney = jarsFilledWithHoney;
		FoodInStock = foodInStock;
		DrugsInStock = drugsInStock;
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
	public int getFoodInStock() {
		return FoodInStock;
	}
	public void setFoodInStock(int foodInStock) {
		FoodInStock = foodInStock;
	}
	public int getDrugsInStock() {
		return DrugsInStock;
	}
	public void setDrugsInStock(int drugsInStock) {
		DrugsInStock = drugsInStock;
	}
	public void HoneyInStock() {
		
	}
	public int NbOfEmptyJars() {
		
	}
	public void FoodUsed(int n) {
		
	}
	public void DrugsUsed(int n) {
		
	}
	public void JarsUsed(int n) {
		
	}
	public Stock DisplayStock() {
		
	}
}
