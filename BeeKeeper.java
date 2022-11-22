import java.util.ArrayList;

public class BeeKeeper {
	ArrayList<Hive> hives = new ArrayList<Hive>();
	ArrayList<Stock> stock = new ArrayList<Stock>();
	ArrayList<Sales> sales = new ArrayList<Sales>();
	Customers s;
    //Customers
    public void addHiveToBeekeeperUser(Hive h){
		hives.add(h);
	}
    public void addStockToBeekeeperUser(Stock st){
		stock.add(st);
	}
    public void addSalesToBeekeeperUser(Sales s){
		sales.add(s);
	}
    public void addCustomersToBeekeeperUser(Customers c){
		s=c;
	}

}
