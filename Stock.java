import java.io.Serializable;
import java.util.Date;

public class Stock implements Serializable{
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
		 System.out.println(ANSI_GREEN + getJarsFilledWithHoney()*0.25 + " L" + ANSI_CYAN + "Honey In Stock" + ANSI_RESET);
	}
	public int NbOfEmptyJars() {
		return getTotalNbOfJars()-getJarsFilledWithHoney();
	}
	public void FoodInStock(int n) {
		// in main n = sales.getFoodBought
		System.out.print(ANSI_GREEN);
		System.out.print(n-getFoodUsed());
	}
	public void DrugsInStock(int n) {
		System.out.print(ANSI_GREEN);
		System.out.print(n-getDrugsUsed());
	}
	public int JarsUsed() {
		return JarsFilledWithHoney;
		
	}
	public void DisplayStock(int n , int m) {
		System.out.println(ANSI_CYAN + "On " + ANSI_GREEN + getDateLogged() + ANSI_CYAN + ": \nIn Stock: " + ANSI_GREEN + getTotalNbOfJars() + ANSI_CYAN + " jars \n" + ANSI_GREEN + getJarsFilledWithHoney() + ANSI_CYAN + " jars filled with honey \n" + ANSI_GREEN + getFoodUsed() + ANSI_CYAN +  " Food used \n" + ANSI_GREEN + getDrugsUsed() + ANSI_CYAN + " Drugs Used \n" + ANSI_GREEN +  JarsUsed() + ANSI_CYAN + " Jars Used \n" + ANSI_GREEN + NbOfEmptyJars() + ANSI_CYAN + " empty jars" + ANSI_RESET);
		FoodInStock(n);
		System.out.println(ANSI_CYAN + " Food in Stock" + ANSI_RESET);
		DrugsInStock(m);
		System.out.println(ANSI_CYAN + " Drugs in Stock" + ANSI_RESET);
		HoneyInStock();
	}
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
}
