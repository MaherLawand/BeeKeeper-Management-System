
public class Customers {
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
	public void addCustomer() {
		
	}
	public Customers banCustomer(String email, int phonenumber) {
		
	}
	public Customers SearchCustomerbyEmailandPhoneNumber(String email,int phonenumber) {
		
		
	}
	public void ListCustomers() {
		
	}
	public void ListBannedCustomers() {
		
	}
}
