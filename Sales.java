import java.io.Serializable;
import java.util.Date;

public class Sales implements Serializable{
	private Date DateLogged;
	private String Season;
	private int Revenue;
	private int HivesBought;
	private int JarsBought;
	private int FoodBought;
	private int DrugsBought;
	private int OperatingExpenses;
	private int Other;
	public Sales() {
		super();
		DateLogged =null;
		Season ="";
		Revenue = 0;
		HivesBought = 0;
		JarsBought = 0;
		FoodBought = 0;
		DrugsBought = 0;
		OperatingExpenses = 0;
		Other = 0;
	}
	public Sales(Date now,String season, int revenue, int hivesBought, int jarsBought, int foodBought, int drugsBought,
			int operatingExpenses, int other) {
		super();
		DateLogged = now;
		Season = season;
		Revenue = revenue;
		HivesBought = hivesBought;
		JarsBought = jarsBought;
		FoodBought = foodBought;
		DrugsBought = drugsBought;
		OperatingExpenses = operatingExpenses;
		Other = other;
	}
	public Date getDateLogged() {
		return DateLogged;
	}
	public void setDateLogged(Date dateLogged) {
		DateLogged = dateLogged;
	}
	public String getSeason() {
		return Season;
	}
	public void setSeason(String season) {
		Season = season;
	}
	public int getRevenue() {
		return Revenue;
	}
	public void setRevenue(int revenue) {
		Revenue = revenue;
	}
	public int getHivesBought() {
		return HivesBought;
	}
	public void setHivesBought(int hivesBought) {
		HivesBought = hivesBought;
	}
	public int getJarsBought() {
		return JarsBought;
	}
	public void setJarsBought(int jarsBought) {
		JarsBought = jarsBought;
	}
	public int getFoodBought() {
		return FoodBought;
	}
	public void setFoodBought(int foodBought) {
		FoodBought = foodBought;
	}
	public int getDrugsBought() {
		return DrugsBought;
	}
	public void setDrugsBought(int drugsBought) {
		DrugsBought = drugsBought;
	}
	public int getOperatingExpenses() {
		return OperatingExpenses;
	}
	public void setOperatingExpenses(int operatingExpenses) {
		OperatingExpenses = operatingExpenses;
	}
	public int getOther() {
		return Other;
	}
	public void setOther(int other) {
		Other = other;
	}
	
	
	
	public double NetProfit() {	
		double profit =getRevenue() - TotalCost();
		return profit;		
	}

	public double TotalCost() {
		double sum = 150*getHivesBought()+ 1*getJarsBought()+75*getFoodBought()+25*getDrugsBought()+getOperatingExpenses()+getOther();
		return sum;	
	}

	public int HighestExpense() {
		int[] a = {150*getHivesBought() ,1*getJarsBought(),75*getFoodBought(),25*getDrugsBought(),getOperatingExpenses(),getOther()};
		int max = a[0];
		int q=0;
		for(int i = 0;i<a.length;i++) {
			if(a[i]>max) {
				max=a[i];
				q=i;
			}
		}
		if(q==0) {
			System.out.println( ANSI_CYAN + "The Highest expense is hives built : " + ANSI_GREEN +max + "$" + ANSI_RESET);			
		}
		else if(q==1) {
			System.out.println( ANSI_CYAN + "The Highest expense is jars bought : " + ANSI_GREEN +max +"$" + ANSI_RESET);	
		}
		else if(q==2) {
			System.out.println( ANSI_CYAN + "The Highest expense is food bought : " + ANSI_GREEN +max + "$" + ANSI_RESET);
		}
		else if(q==3) {
			System.out.println( ANSI_CYAN + "The Highest expense is Drugs bought : " + ANSI_GREEN +max + "$" + ANSI_RESET);
		}
		else if(q==4) {
			System.out.println( ANSI_CYAN + "The Highest expense is Operating the business : " + ANSI_GREEN +max + "$" + ANSI_RESET);
		}
		else if(q==5) {
			System.out.println( ANSI_CYAN + "The Highest expense is Miscellaneous Fees : " + ANSI_GREEN +max +"$" + ANSI_RESET);
		}	
		return max;	
	}

	public int JarsSold() {
		return getRevenue()/5;		
	}

	public double HoneyProduced(){		
		return JarsSold()*0.25;		
	}
	public void ListSales(){
		System.out.println(ANSI_CYAN + "Date: " + ANSI_GREEN + getDateLogged() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Season: " + ANSI_GREEN + getSeason() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Revenue: " + ANSI_GREEN + getRevenue() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Hives Bought: " + ANSI_GREEN + getHivesBought() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Jars Bought: " + ANSI_GREEN + getJarsBought() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Food Bought: " + ANSI_GREEN + getFoodBought() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Drugs Bought: " + ANSI_GREEN + getDrugsBought() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Operating Expenses: " + ANSI_GREEN + getOperatingExpenses() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Other Expenses: " + ANSI_GREEN + getOther() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Net Profit: " + ANSI_GREEN + NetProfit() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Total Cost: " + ANSI_GREEN + TotalCost() + ANSI_RESET);
		HighestExpense();
		System.out.println(ANSI_CYAN + "Jars Sold: " + ANSI_GREEN + JarsSold() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Honey Produced: " + ANSI_GREEN + HoneyProduced() + ANSI_RESET);
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
