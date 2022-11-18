
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
				System.out.println("The Highest expense is hives built : " +max +"$");
				
			}
			else if(q==1) {
				System.out.println("The Highest expense is jars bought : " +max +"$");
				
			}
			else if(q==2) {
				System.out.println("The Highest expense is food bought : " +max +"$");
				
			
			}
			else if(q==3) {
				System.out.println("The Highest expense is Drugs bought : " +max +"$");
				
			
			}
			else if(q==4) {
				System.out.println("The Highest expense is Operating the business : " +max +"$");
				
			
			}
			else if(q==5) {
				System.out.println("The Highest expense is Miscellaneous Fees : " +max +"$");
				
			
			}
		
		
		return max;
		
	}
	public int JarsSold() {
		return getRevenue()/5;
		
	}
	public double HoneyProduced(){
		
		return JarsSold()*0.25;
		
	}
	
}
