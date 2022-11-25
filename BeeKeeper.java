import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BeeKeeper implements Serializable {
	private String FName;
	private String LName;
	private int PhoneNumber;
	private String Address;
	public BeeKeeper(){
		FName="";
		LName="";
		PhoneNumber=0;
		Address="";
	}
	public BeeKeeper(String FName,String LName,int PhoneNumber,String Address){
		this.FName=FName;
		this.LName=LName;
		this.PhoneNumber=PhoneNumber;
		this.Address=Address;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	ArrayList<Apiary> apiary = new ArrayList<Apiary>();
	ArrayList<Stock> stock = new ArrayList<Stock>();
	ArrayList<Sales> sales = new ArrayList<Sales>();
	Customers s;
    //Customers
    public void addApiaryToBeekeeperUser(Apiary A){
		apiary.add(A);
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
	public Apiary SearchApiaryBySerialNb(int SerialNb){
		for(int i=0;i<apiary.size();i++){
			if(apiary.get(i).getApiarySerialNB()==SerialNb){
				return apiary.get(i);
			}
		}
		return null;
	}
	public void ListApiary(){
		for(int i=0;i<apiary.size();i++){
			apiary.get(i).ApiaryStatus();
			apiary.get(i).ListHivesInApiary();
			System.out.println("----------------------------");
		}
	}
	public Stock SearchStockByDate(Date d){
		for(int i=0;i<stock.size();i++){
			if(stock.get(i).getDateLogged()==d){
				return stock.get(i);
			}
		}
		return null;
	}
	public Sales SearchSalesByDate(LocalDateTime d){
		for(int i=0;i<sales.size();i++){
			if(sales.get(i).getDateLogged()==d){
				return sales.get(i);
			}
		}
		return null;
	}

}
