import java.util.ArrayList;

public class BeeKeeper {
	Apiary a;
	ArrayList<Stock> stock = new ArrayList<Stock>();
	ArrayList<Sales> sales = new ArrayList<Sales>();
	Customers s;
    //Customers
    public void addApiaryToBeekeeperUser(Apiary A){
		a=A;
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
