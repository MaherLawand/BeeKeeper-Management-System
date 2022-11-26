import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customers implements Serializable{
	HashMap <String,Customers> ActiveCustomers = new HashMap<>();
	HashMap <String,Customers> BannedCustomers = new HashMap<>();
	private String FName;
	private String LName;
	private String email;
	private String address;
	private int PhoneNumber;
	public Customers() {
		super();
		FName ="";
		LName ="";
		email ="";
		address ="";
		PhoneNumber=0;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Customers(String fName, String lName, String email, String address, int phoneNumber) {
		super();
		FName = fName;
		LName = lName;
		this.email = email;
		this.address = address;
		PhoneNumber = phoneNumber;
	}
	public void addCustomer(Customers s,String email) {
		if(ActiveCustomers.keySet().contains(email)){
			System.out.println(ANSI_RED+"Already An Active Customer!!"+ANSI_RESET);
		}else if(BannedCustomers.keySet().contains(email)){
			System.out.println(ANSI_RED+"Customer "+ANSI_GREEN  + s.getFName() + " " + s.getLName()+ANSI_RED+ " Banned!"+ANSI_RESET);
		}else{
			ActiveCustomers.put(email, s);
			System.out.println(ANSI_YELLOW+"Successfully Added Customer "+ANSI_GREEN + s.getFName() + " " + s.getLName()+ANSI_RESET);
		}
	}
	public Customers banCustomer(Customers s,String email) {
		Customers banned=null;
		if(!BannedCustomers.keySet().contains(email) && ActiveCustomers.keySet().contains(email)){
			BannedCustomers.put(email, s);
			banned=s;
			ActiveCustomers.remove(email, s);
			System.out.println(ANSI_YELLOW+"Successfully Banned Customer "+ANSI_GREEN + s.getFName() + " " + s.getLName()+ANSI_RESET);
		}else if(!ActiveCustomers.keySet().contains(email)){
			System.out.println(ANSI_RED+"Customer Doesnt Exist!"+ANSI_RESET);
		}else{
			System.out.println(ANSI_RED+"Customer Already Banned!"+ANSI_RESET);
		}
		return banned;
	}
	public Customers SearchCustomerbyEmail(String email) {
		Customers[] customers = ActiveCustomers.values().toArray(new Customers[ActiveCustomers.size()]);
		// for(int i=0;i<customers.length;i++){
		// 	System.out.println(customers[i].email);
		// }
		Arrays.sort(customers, new Comparator<Customers>() {
			@Override
			public int compare(Customers o1, Customers o2) {
				return o1.getEmail().compareTo(o2.getEmail());
			}
		});
		int l = 0, r = customers.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (customers[m].getEmail().compareTo(email) < 0) {
				l = m + 1; 
			} else if (customers[m].getEmail().compareTo(email) > 0) {
				r = m - 1;
			} 
			else{
				return customers[m];
			}
    }
	return null;
}
	
	public void ListCustomers() {
		System.out.println(ANSI_YELLOW + "Active Customers:" + ANSI_RESET);
		for (Customers s : ActiveCustomers.values()) {
			System.out.println(ANSI_CYAN + "First Name:" + ANSI_GREEN + " " + s.getFName() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Last Name:" + ANSI_GREEN + " " + s.getLName() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Email:" + ANSI_GREEN + " " + s.getEmail() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Address:" + ANSI_GREEN + " " + s.getAddress() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Phone Number:" + ANSI_GREEN + " " + s.getPhoneNumber() + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "-------------------------------------" + ANSI_RESET);
			
		}
	}
	public void ListBannedCustomers() {
		System.out.println(ANSI_YELLOW + "Banned Customers: " + ANSI_RESET);
		for (Customers s : BannedCustomers.values()) {
			System.out.println(ANSI_CYAN + "First Name: " + ANSI_GREEN + " " +  s.getFName() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Last Name: " + ANSI_GREEN + " " +  s.getLName() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Email: " + ANSI_GREEN + " " + s.getEmail() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Address: " + ANSI_GREEN + " " +  s.getAddress() + ANSI_RESET);
			System.out.println(ANSI_CYAN + "Phone Number: " + ANSI_GREEN + " " + s.getPhoneNumber() + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "-------------------------------------" + ANSI_RESET);
			
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

