import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Comparator;

public class Customers {
	HashSet <Customers> ActiveCustomers = new HashSet<Customers>();
	HashSet <Customers> BannedCustomers = new HashSet<Customers>();
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
	public void addCustomer(Customers s) {
		if(ActiveCustomers.contains(s)){
			System.out.println("Already Registered!");
		}else if(BannedCustomers.contains(s)){
			System.out.println("Customer Banned!");
		}else{
			ActiveCustomers.add(s);
		}
	}
	public Customers banCustomer(Customers s) {
		Customers banned=s;
		if(!BannedCustomers.contains(s) && ActiveCustomers.contains(s)){
			BannedCustomers.add(s);
			ActiveCustomers.remove(s);
		}else if(!ActiveCustomers.contains(s)){
			System.out.println("Customer Doesnt Exist!");
		}else{
			System.out.println("Customer Already Banned!");
		}
		return banned;
	}
	public Customers SearchCustomerbyEmail(String email) {
		Customers[] customers = ActiveCustomers.toArray(new Customers[ActiveCustomers.size()]);
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
		for (Customers s : ActiveCustomers) {
			System.out.println("First Name: " + s.getFName());
			System.out.println("Last Name: " + s.getLName());
			System.out.println("Email: " + s.getEmail());
			System.out.println("Address: " + s.getAddress());
			System.out.println("Phone Number: " + s.getPhoneNumber());
			System.out.println("-------------------------------------");
			
		}
	}
	public void ListBannedCustomers() {
		for (Customers s : BannedCustomers) {
			System.out.println("First Name: " + s.getFName());
			System.out.println("Last Name: " + s.getLName());
			System.out.println("Email: " + s.getEmail());
			System.out.println("Address: " + s.getAddress());
			System.out.println("Phone Number: " + s.getPhoneNumber());
			System.out.println("-------------------------------------");
			
		}
	}


	
}

