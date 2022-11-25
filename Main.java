import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
      Scanner console=new Scanner(System.in);
      
      File file = new File("C:\\Users\\user\\Desktop\\Users.txt");
      if(file.length()==0){
            Users AllUsers = new Users();
            Users SignedIn = new Users();
            SignedIn=Registration(AllUsers,console);
            writeObjectToFile(AllUsers, file);
      }else{
            Users AllUsers = readObjectFromFile(file);
            Users SignedIn = new Users();
            System.out.println("1) Login: \n2) Register: ");
            System.out.println("Choose One Of The Options: ");
            int LoginOrSignup=console.nextInt();
            if(LoginOrSignup==1){
                System.out.print("Enter an email: ");
                String email = console.next();
                System.out.print("\nEnter Password: ");
                String password = console.next();
                SignedIn = AllUsers.Login(email, password);
                System.out.println(AllUsers.users);
            }else{
                SignedIn=Registration(AllUsers,console);
                writeObjectToFile(AllUsers, file);
            }
            System.out.println("Welcome Back " + SignedIn.getBeeKeeper().getFName() + " " + SignedIn.getBeeKeeper().getLName());
            boolean bool=true;
            while(bool){
                System.out.println("1)Bee Management\n2)Customer Management\n3)Sales Management\n4)Stock Management\n");
                int Management = console.nextInt();
                switch(Management){
                    case 1:
                        System.out.println("1)Add\n2)Edit\n3)View");
                        int Option = console.nextInt();
                        switch(Option){
                            case 1:
                                System.out.println("APIARY:");
                                System.out.println("--------");
                                System.out.println("Apiary Name:");
                                String ApiaryName=console.next();
                                System.out.println("Apiary SerialNb:");
                                int ApiarySerialNB=console.nextInt();
                                System.out.println("Apiary Location:");
                                String ApiaryLocation=console.next();
                                Apiary newApiary = new Apiary(ApiaryName, ApiarySerialNB, ApiaryLocation);
                                System.out.println("-------------------------");
                                System.out.println("HIVE:");
                                System.out.println("--------");
                                System.out.println("Hive Size:");
                                int HiveSize= console.nextInt();
                                System.out.println("Hive Serial Number:");
                                int HiveSerialNb=console.nextInt();
                                System.out.println("Medical Condition(1-10):");
                                int HiveMedicalCondition=console.nextInt();
                                System.out.println("Number Of Frames:");
                                int HiveNbOfFrames=console.nextInt();
                                System.out.println("Are They Fed?(Y,N)");
                                char HiveFeeding=console.next().charAt(0);
                                boolean HiveFed=true;
                                if(HiveFeeding=='Y'){
                                    HiveFed=true;
                                }else{
                                    HiveFed=false;
                                }
                                System.out.println("Are They Drugged?(Y,N");
                                char HiveDrugged=console.next().charAt(0);
                                boolean HiveDrug=true;
                                if(HiveDrugged=='Y'){
                                    HiveDrug=true;
                                }else{
                                    HiveDrug=false;
                                }
                                Hive newHive = new Hive(HiveSize, HiveSerialNb, HiveMedicalCondition, HiveNbOfFrames, HiveFed, HiveDrug);
                                System.out.println("-------------------------");
                                System.out.println("Bees:");
                                System.out.println("--------");
                                System.out.println("Type Of Bee:");
                                String BeeType=console.next();
                                System.out.println("Estimated Number Of Bees:");
                                int EstimatesNbOfBees=console.nextInt();
                                System.out.println("Life Span:");
                                int LifeSpan=console.nextInt();
                                System.out.println("Efficiency Of Bees:");
                                int EfficiencyOfBee=console.nextInt();
                                GeneralBees newBee = new Bee(BeeType, EfficiencyOfBee, LifeSpan, EstimatesNbOfBees);
                                System.out.println("-------------------------");
                                System.out.println("QueenBee:");
                                System.out.println("--------");
                                boolean QueenBeeType=true;
                                System.out.println("Egg Laying Rate:");
                                int QueenBeeEggLayingRate=console.nextInt();
                                System.out.println("Life Span:");
                                int QueenBeeLifeSpan=console.nextInt();
                                System.out.println("Medical Health");
                                String QueenBeeMedicalHealth=console.next();
                                GeneralBees newQueenBee = new QueenBee(QueenBeeType, QueenBeeEggLayingRate, QueenBeeLifeSpan, QueenBeeMedicalHealth);
                                newHive.addBee(newBee);
                                newHive.addQueenBee(newQueenBee);
                                newApiary.addHiveToApiary(newHive);
                                SignedIn.getBeeKeeper().addApiaryToBeekeeperUser(newApiary);
                                break;
                            
                            case 2:
                                //Copy Above And just put set to change all
                                System.out.println("1)Edit\n2)Remove");
                                int EditOrRemove = console.nextInt();
                                switch(EditOrRemove){
                                    case 1:
                                        System.out.println("1)Apiary\n2)Hive\n3)QueenBee");
                                        int EditOption = console.nextInt();
                                        switch(EditOption){
                                            case 1:
                                                System.out.println("Enter The Apiary Serial Nb:");
                                                int EditApiarySerialNb=console.nextInt();
                                                newApiary=SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                                System.out.println("APIARY:" + newApiary.getApiarySerialNB());
                                                System.out.println("--------");
                                                System.out.println("Apiary Name:");
                                                ApiaryName=console.next();
                                                System.out.println("Apiary SerialNb:");
                                                ApiarySerialNB=console.nextInt();
                                                System.out.println("Apiary Location:");
                                                ApiaryLocation=console.next();
                                                newApiary.setApiaryName(ApiaryName);
                                                newApiary.setApiarySerialNB(ApiarySerialNB);
                                                newApiary.setLocation(ApiaryLocation);
                                                break;
                                            case 2:
                                                System.out.println("Enter The Apiary Serial Nb:");
                                                EditApiarySerialNb=console.nextInt();
                                                newApiary=SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                                System.out.println("Enter The Hive Serial Nb:");
                                                int EditHiveSerialNb=console.nextInt();
                                                Hive EditHive=newApiary.FindHiveBYSerialNBfromApiary(EditHiveSerialNb);
                                                System.out.println("HIVE:" + EditHive.getHiveSerialNb());
                                                System.out.println("--------");
                                                System.out.println("Hive Size:");
                                                HiveSize= console.nextInt();
                                                System.out.println("Hive Serial Number:");
                                                HiveSerialNb=console.nextInt();
                                                System.out.println("Medical Condition(1-10):");
                                                HiveMedicalCondition=console.nextInt();
                                                System.out.println("Number Of Frames:");
                                                HiveNbOfFrames=console.nextInt();
                                                System.out.println("Are They Fed?(Y,N)");
                                                HiveFeeding=console.next().charAt(0);
                                                HiveFed=true;
                                                if(HiveFeeding=='Y'){
                                                    HiveFed=true;
                                                }else{
                                                    HiveFed=false;
                                                }
                                                System.out.println("Are They Drugged?(Y,N");
                                                HiveDrugged=console.next().charAt(0);
                                                HiveDrug=true;
                                                if(HiveDrugged=='Y'){
                                                    HiveDrug=true;
                                                }else{
                                                    HiveDrug=false;
                                                }
                                                EditHive.setSize(HiveSize);
                                                EditHive.setHiveSerialNb(HiveSerialNb);
                                                EditHive.setMedicalCondition(HiveMedicalCondition);
                                                EditHive.setNbOfFrames(HiveNbOfFrames);
                                                EditHive.setFood(HiveFed);
                                                EditHive.setDrugs(HiveDrug);
                                                    break;
                                            case 3:
                                                System.out.println("Enter The Apiary Serial Nb:");
                                                EditApiarySerialNb=console.nextInt();
                                                newApiary=SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                                System.out.println("Enter The Hive Serial Nb:");
                                                EditHiveSerialNb=console.nextInt();
                                                EditHive=newApiary.FindHiveBYSerialNBfromApiary(EditHiveSerialNb);
                                                System.out.println("QueenBee:");
                                                System.out.println("--------");
                                                QueenBeeType=true;
                                                System.out.println("Egg Laying Rate:");
                                                QueenBeeEggLayingRate=console.nextInt();
                                                System.out.println("Life Span:");
                                                QueenBeeLifeSpan=console.nextInt();
                                                System.out.println("Medical Health");
                                                QueenBeeMedicalHealth=console.next();
                                                newQueenBee = new QueenBee(QueenBeeType, QueenBeeEggLayingRate, QueenBeeLifeSpan, QueenBeeMedicalHealth);
                                                EditHive.ChangeQueenBee(newQueenBee);
                                                break;
                                            default:
                                                System.out.println("Wrong Edit Option!");
                                                break;
                                        }
                                        break;
                                    
                                    case 2:
                                    System.out.println("1)Apiary\n2)Hive");
                                    EditOption = console.nextInt();
                                    switch(EditOption){
                                        case 1:
                                            System.out.println("Enter The Apiary Serial Nb:");
                                            int EditApiarySerialNb=console.nextInt();
                                            newApiary=SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                            SignedIn.getBeeKeeper().apiary.remove(newApiary);
                                            //Add if statement to check if Apiary was removed or not
                                            System.out.println("Successfully Removed Apiary!");
                                            break;
                                        case 2:
                                            System.out.println("Enter The Apiary Serial Nb:");
                                            EditApiarySerialNb=console.nextInt();
                                            newApiary=SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                            System.out.println("Enter The Hive Serial Nb:");
                                            int EditHiveSerialNb=console.nextInt();
                                            Hive EditHive=newApiary.FindHiveBYSerialNBfromApiary(EditHiveSerialNb);
                                            newApiary.removeHivefromApiary(EditHive);
                                            //Add if statement to check if hive was removed or not
                                            System.out.println("Successfully Removed Hive!");
                                            break;
                                        default:
                                            System.out.println("Wrong Edit Option!");
                                            break;
                                    }
                                        break;

                                    default:
                                        System.out.println("Wrong Option!");
                                        break;
                                }
                                break;
                            case 3:
                                SignedIn.getBeeKeeper().ListApiary();
                                break;
                            default:
                                System.out.println("Please ReEnter a Valid Number!");
                                break;
                        }



                        break;
                    case 2:




                        break;

                    case 3:
                    



                        break;

                    case 4:




                        break;

                    default:
                        System.out.println("Please ReEnter a Valid Number!");
                        break;
                }
            }
            
      }
      

//       if(AllUsers.users.isEmpty()){
                    
                    
//       } 

      
//         Hive h = new Hive(500, 1120,10, 20, false, false);
//         Apiary A = new Apiary("Apiary1", 20120, "Test");
// A.addHiveToApiary(h);
// B.addApiaryToBeekeeperUser(A);

// Stock st = new Stock(null, 43, 34, 53, 50);
// B.addStockToBeekeeperUser(st);
// LocalDateTime now = LocalDateTime.now();  
// Sales s = new Sales(now,"Winter", 1000, 200, 500, 400, 20, 8000, 0);
// B.addSalesToBeekeeperUser(s);

// Customers all = new Customers();
// Customers s1 = new Customers("Maher","Lawand","maher.lawand@gmail.com","test1",70300981);
// Customers s2 = new Customers("Hadi","Youness","fds@gmail.com","test2",546546);
// all.addCustomer(s1,s1.getEmail());
// all.addCustomer(s2,s2.getEmail());
// B.addCustomersToBeekeeperUser(all);



      

//       writeObjectToFile(AllUsers, file);
//       AllUsers = readObjectFromFile(file);
//       AllUsers.Login("idk", "test");
  }

  // Serialization
  // Save object into a file.
  public static void writeObjectToFile(Users obj, File file) throws IOException {
      try (FileOutputStream fos = new FileOutputStream(file);
           ObjectOutputStream oos = new ObjectOutputStream(fos)) {
          oos.writeObject(obj);
          oos.flush();
      }
  }

  // Deserialization
  // Get object from a file.
  public static Users readObjectFromFile(File file) throws IOException, ClassNotFoundException {
      Users result = null;
      try (FileInputStream fis = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(fis)) {
          result = (Users) ois.readObject();
      }
      return result;
  }
  public static Users Registration(Users U,Scanner console){
        System.out.println("REGISTRATION:");
        System.out.println("---------------------");
        System.out.println("First Name: ");
        String FName = console.next();
        System.out.println("Last Name: ");
        String LName = console.next();
        System.out.println("Phone Number: ");
        int PhoneNumber = console.nextInt();
        System.out.println("Address: ");
        String Address = console.next();
        System.out.print("Enter an email: ");
        String email = console.next();
        System.out.print("\n Enter Password: ");
        String password = console.next();
        BeeKeeper B = new BeeKeeper(FName,LName,PhoneNumber,Address);
        U.setBeeKeeper(B);
        U.Register(email, password, B);
        Users SignedIn = U.Login(email, password);
        return SignedIn;
  }

//         try {
//           Users AllUsers = new Users();
//           BeeKeeper B = new BeeKeeper();
//           FileOutputStream Users = new FileOutputStream(new File("C:\\Users\\user\\Desktop\\Users.txt"));
//           ObjectOutputStream o = new ObjectOutputStream(Users);
//           if(AllUsers.users.isEmpty()){
//             System.out.println("Enter an email: ");
//             String email = console.next();
//             System.out.println("Enter Password: ");
//             String password = console.next();
//             AllUsers.Register(email, password, B);
//             Users signedin = AllUsers.Login(email, password);
//         } 
//           o.writeObject(AllUsers);
//           o.close();
//           Users.close();

//           Hive h = new Hive(500, 1120,10, 20, false, false);
// Apiary A = new Apiary("Apiary1", 20120, "Test");
// A.addHiveToApiary(h);
// B.addApiaryToBeekeeperUser(A);

// Stock st = new Stock(null, 43, 34, 53, 50);
// B.addStockToBeekeeperUser(st);
// LocalDateTime now = LocalDateTime.now();  
// Sales s = new Sales(now,"Winter", 1000, 200, 500, 400, 20, 8000, 0);
// B.addSalesToBeekeeperUser(s);

// Customers all = new Customers();
// Customers s1 = new Customers("Maher","Lawand","maher.lawand@gmail.com","test1",70300981);
// Customers s2 = new Customers("Hadi","Youness","fds@gmail.com","test2",546546);
// all.addCustomer(s1,s1.getEmail());
// all.addCustomer(s2,s2.getEmail());
// B.addCustomersToBeekeeperUser(all);



//           FileInputStream fi = new FileInputStream(new File("C:\\Users\\user\\Desktop\\Users.txt"));
// 			    ObjectInputStream oi = new ObjectInputStream(fi);
//           Users u1 = (Users) oi.readObject();
//           System.out.println(u1.getBeeKeeper().s.SearchCustomerbyEmail("maher.lawand@gmail.com"));
//           fi.close();
//           oi.close();
//         }catch (FileNotFoundException e) {
//           System.out.println("File not found");
//         } catch (IOException e) {
//           System.out.println("Error initializing stream");
//         } catch (ClassNotFoundException e) {
//           e.printStackTrace();
//         }
        

       
//   }

}