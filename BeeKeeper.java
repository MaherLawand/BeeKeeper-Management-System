import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

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
	HashMap<Date,Sales> sales = new HashMap();
	Customers s;
    //Customers
	 public void addCustomersToBeekeeperUserNoPrint(Customers c){
			s=c;
			
		}
    public void addApiaryToBeekeeperUser(Apiary A){
		apiary.add(A);
		System.out.println(ANSI_YELLOW +"Successfully Added Apiary " + ANSI_GREEN + A.getApiarySerialNB() + ANSI_RESET);
	}
    public void addStockToBeekeeperUser(Stock st){
		stock.add(st);
		System.out.println(ANSI_YELLOW +"Successfully Added Stock! " + ANSI_RESET);
		System.out.println(ANSI_YELLOW +"-----------------------------------------" + ANSI_RESET);
		
	}
    public void addSalesToBeekeeperUser(Date sdf,Sales s){
		sales.put(sdf,s);
		System.out.println(ANSI_YELLOW +"Successfully Added Sales! " + ANSI_RESET);
	}
    public void addCustomersToBeekeeperUser(Customers c){
		s=c;
		System.out.println(ANSI_YELLOW +"Successfully Added Customers!" + ANSI_RESET);
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
			System.out.println(ANSI_YELLOW +"-----------------------------------------" + ANSI_RESET);
		}
	}
	public void ListAllCustomers(){
		s.ListCustomers();
		s.ListBannedCustomers();
	}

	public Stock SearchStockByDate(Date d){
		for(int i=0;i<stock.size();i++){
			if(stock.get(i).getDateLogged()==d){
				return stock.get(i);
			}
		}
		return null;
	}
	public void ListAllStock(){
		for(int i=0;i<stock.size();i++){
			Date d=stock.get(i).getDateLogged();
			stock.get(i).DisplayStock(sales.get(d).getFoodBought(), sales.get(d).getDrugsBought());
			System.out.println(ANSI_YELLOW +"-----------------------------------------" + ANSI_RESET);
		}
	}
	public Sales SearchSalesByDate(Date d){
			return sales.get(d);
	}
	public void ListAllSales(){
		for (Sales s : sales.values()) {
			s.ListSales();
			System.out.println(ANSI_YELLOW + "-----------------------------------------" + ANSI_RESET);
		}
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
