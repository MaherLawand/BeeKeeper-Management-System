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
Customers all = new Customers();
Customers s1 = new Customers("Maher","Lawand","maher.lawand9@gmail.com","test",70300981);
Customers s3 = new Customers("arij","fg","fds@gmail.com","sd",546546);
Customers s4 = new Customers("arij","fg","fdgs@gmail.com","sd",546546);

all.addCustomer(s1);
all.addCustomer(s3);
all.addCustomer(s4);
all.banCustomer(s4);

Customers email=all.SearchCustomerbyEmail("mdfs9@gmail.com");
if(email!=null){
    System.out.println(email.getEmail());
}else{
    System.out.println("null");
}
all.ListBannedCustomers();

    }
}