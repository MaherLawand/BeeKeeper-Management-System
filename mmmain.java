import java.util.HashSet;

public class mmmain {
    public static void main(String[] args){

Users allUsers = new Users();
String email="maher.lawand9@gmail.com";
String pass="fddf";
BeeKeeper B = new BeeKeeper(); 
allUsers.Register(email, pass, B);
Users signedin = allUsers.Login(email, pass);

Hive h = new Hive(500, 1120,10, 20, false, false);
Apiary A = new Apiary("Apiary1", 20120, 0.0, "Test");
A.addHiveToApiary(h);
B.addApiaryToBeekeeperUser(A);

System.out.println(signedin.getBeeKeeper().a);

Stock st = new Stock(null, 43, 34, 53, 50);
B.addStockToBeekeeperUser(st);

Sales s = new Sales(pass, 1000, 200, 500, 400, 20, 8000, 0);
B.addSalesToBeekeeperUser(s);

Customers all = new Customers();
Customers s1 = new Customers("Maher","Lawand","maher.lawand@gmail.com","test1",70300981);
Customers s2 = new Customers("Hadi","Youness","fds@gmail.com","test2",546546);
all.addCustomer(s1,s1.getEmail());
all.addCustomer(s2,s2.getEmail());
System.out.println(all.ActiveCustomers);
B.addCustomersToBeekeeperUser(all);

Customers test= signedin.getBeeKeeper().s.SearchCustomerbyEmail("maher.lawandd@gmail.com");
if(test!=null){
    System.out.println(test.getFName());
}else{
    System.out.println("Email Doesnt Exist!");
}

String email2 = "fds@gmail.com@gmail.com";
String pass2 = "fddf";
BeeKeeper B2 = new BeeKeeper();
allUsers.Register(email2, pass2, B2);

signedin.getBeeKeeper().s.banCustomer(s2, s2.getEmail());
signedin.getBeeKeeper().s.ListBannedCustomers();
signedin = allUsers.Login(email2, pass2);
    }
}