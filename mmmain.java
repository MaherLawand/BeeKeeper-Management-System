import java.util.HashSet;

public class mmmain {
    public static void main(String[] args){
//        Hive h = new Hive(50,1,123, 2,true,false);
//        Hive h1 = new Hive(50,2,123, 2,true,false);
//        Hive h2 = new Hive(50,3,123, 2,true,false);
//        h1.addQueenBee(true, 15, 3, "Ohioo");
//        h2.addQueenBee(true, 15, 3, "Ohioo");
//        h1.addBee("Ohio", 15, 100, 217);
//        h2.addBee("Ohio", 15, 100, 217);
//        h.addBee("Ohio", 15, 100, 217);
       
     
//        Apiary f = new Apiary("nigroo", 69, 30.3325 , "Da7ye" );
       
//        f.addHiveToApiary(h);
//        f.addHiveToApiary(h1);
//        f.addHiveToApiary(h2);
//        f.ListHivesInApiary();
//        System.out.println(f.FindHiveBYSerialNBfromApiary(3));
      
       
//        f.sortHivesInApiaryByQueenStatus();
//        f.ListHivesInApiary();
       
       
//        System.out.println(f.FindHiveBYSerialNBfromApiary(3));
       
//        f.removeHiveBYSerialNBfromApiary(1);
//        f.ListHivesInApiary();
       
        
        
//     }
// }

Users allUsers = new Users();
String email="maher.lawand9@gmail.com";
String pass="fddf";
BeeKeeper B = new BeeKeeper();
allUsers.Register(email, pass, B);
Users signedin = allUsers.Login(email, pass);

Hive h = new Hive(500, 1120,10, 20, false, false);
B.addHiveToBeekeeperUser(h);

Stock st = new Stock(null, 43, 34, 53, 50);
B.addStockToBeekeeperUser(st);

Sales s = new Sales(pass, 1000, 200, 500, 400, 20, 8000, 0);
B.addSalesToBeekeeperUser(s);

Customers all = new Customers();
Customers s1 = new Customers("Maher","Lawand","maher.lawand@gmail.com","test1",70300981);
Customers s2 = new Customers("Hadi","Youness","fds@gmail.com","test2",546546);
all.addCustomer(s1);
all.addCustomer(s2);
B.addCustomersToBeekeeperUser(all);

Customers test= signedin.getBeeKeeper().s.SearchCustomerbyEmail("fds@gmail.com");
System.out.println(test.getFName());

String email2 = "maher.lawand9@gmail.com";
String pass2 = "fddf";
BeeKeeper B2 = new BeeKeeper();
allUsers.Register(email2, pass2, B2);
    }
}