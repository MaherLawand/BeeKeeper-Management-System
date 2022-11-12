
public class Sales {
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
		Season ="";
		Revenue = 0;
		HivesBought = 0;
		JarsBought = 0;
		FoodBought = 0;
		DrugsBought = 0;
		OperatingExpenses = 0;
		Other = 0;
	}
	public Sales(String season, int revenue, int hivesBought, int jarsBought, int foodBought, int drugsBought,
			int operatingExpenses, int other) {
		super();
		Season = season;
		Revenue = revenue;
		HivesBought = hivesBought;
		JarsBought = jarsBought;
		FoodBought = foodBought;
		DrugsBought = drugsBought;
		OperatingExpenses = operatingExpenses;
		Other = other;
	}
	public double NetProfit() {
		
	}
	public double TotalCost() {
		
	}
	public double HighestExpense() {
		
	}
	public int JarsSold() {
		
	}
	public int HoneyProduced() {
		
	}
}
