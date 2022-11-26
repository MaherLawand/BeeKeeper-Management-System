import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException{
      Scanner console=new Scanner(System.in);
      
      File file = new File("C:\\Users\\user\\Desktop\\Users.txt");
      if(file.length()==0){
            Users AllUsers = new Users();
            Registration(AllUsers,console);
            writeObjectToFile(AllUsers, file);
      }
            Users AllUsers = readObjectFromFile(file);
            Users SignedIn = new Users();
            System.out.println(ANSI_YELLOW +"1) Login: \n2) Register: " + ANSI_RESET);
            System.out.println(ANSI_CYAN + "Choose One Of The Options: " + ANSI_RESET);
            int LoginOrSignup=console.nextInt();
            if(LoginOrSignup==1){
                System.out.print(ANSI_CYAN + "Enter an email: " + ANSI_RESET);
                String email = console.next();
                System.out.print(ANSI_CYAN + "\nEnter Password: " + ANSI_RESET);
                String password = console.next();
                SignedIn = AllUsers.Login(email, password);
            }else{
                SignedIn=Registration(AllUsers,console);
                writeObjectToFile(AllUsers, file);
            }
            System.out.println(ANSI_YELLOW + "Welcome Back " + ANSI_GREEN + SignedIn.getBeeKeeper().getFName() + " " + SignedIn.getBeeKeeper().getLName() + ANSI_RESET);
            boolean bool=true;
            while(bool){
                System.out.println(ANSI_YELLOW + "1) Bee Management\n2) Customer Management\n3) Sales Management\n4) Stock Management\n5) Exit" + ANSI_RESET);
                int Management = console.nextInt();
                switch(Management){
                    //Bee Management
                    case 1:
                        System.out.println(ANSI_YELLOW +"1) Add\n2) Edit\n3) View" + ANSI_RESET);
                        int Option = console.nextInt();
                        switch(Option){
                            //Add Everything into apiary
                            case 1:
                                System.out.println(ANSI_YELLOW + "APIARY:"  + ANSI_RESET);
                                System.out.println(ANSI_YELLOW + "--------"  + ANSI_RESET);
                                System.out.println(ANSI_CYAN + "Apiary Name:");
                                String ApiaryName=console.next();
                                System.out.println(ANSI_CYAN + "Apiary SerialNb:");
                                int ApiarySerialNB=console.nextInt();
                                Apiary CheckApiary = SignedIn.getBeeKeeper().SearchApiaryBySerialNb(ApiarySerialNB);
                                Apiary newApiary;
                                String ApiaryLocation;
                                if(CheckApiary==null){
                                    System.out.println(ANSI_CYAN + "Apiary Location:");
                                    ApiaryLocation=console.next();
                                    newApiary = new Apiary(ApiaryName, ApiarySerialNB, ApiaryLocation);
                                }else{
                                    System.out.println(ANSI_RED + "Apiary " + ANSI_GREEN + ApiarySerialNB + ANSI_RED + " Already Exists!" + ANSI_RESET);
                                    break;
                                }
                                System.out.println(ANSI_YELLOW + "-----------------------------------------"  + ANSI_RESET);
                                System.out.println(ANSI_YELLOW + "HIVE:"  + ANSI_RESET);
                                System.out.println(ANSI_YELLOW + "--------"  + ANSI_RESET);
                                System.out.println(ANSI_CYAN + "Hive Size:" + ANSI_RESET);
                                int HiveSize= console.nextInt();
                                System.out.println(ANSI_CYAN + "Hive Serial Number:"  + ANSI_RESET);
                                int HiveSerialNb=console.nextInt();
                                int HiveMedicalCondition;
                                int HiveNbOfFrames;
                                char HiveFeeding;
                                boolean HiveFed;
                                char HiveDrugged;
                                boolean HiveDrug;
                                Hive newHive;
                                Apiary CheckApiaryThatContainsHiveSerialNb = SignedIn.getBeeKeeper().FindApiaryBYSerialNBfromHive(HiveSerialNb);
                                if(CheckApiaryThatContainsHiveSerialNb==null){
                                        System.out.println(ANSI_CYAN + "Medical Condition(1-10):"  + ANSI_RESET);
                                        HiveMedicalCondition=console.nextInt();
                                        System.out.println(ANSI_CYAN + "Number Of Frames:"  + ANSI_RESET);
                                        HiveNbOfFrames=console.nextInt();
                                        System.out.println(ANSI_CYAN + "Are They Fed?(Y,N)"  + ANSI_RESET);
                                        HiveFeeding=console.next().charAt(0);
                                        HiveFed=true;
                                        if(HiveFeeding=='Y'){
                                            HiveFed=true;
                                        }else{
                                            HiveFed=false;
                                        }
                                        System.out.println(ANSI_CYAN + "Are They Drugged?(Y,N)"  + ANSI_RESET);
                                        HiveDrugged=console.next().charAt(0);
                                        HiveDrug=true;
                                        if(HiveDrugged=='Y'){
                                            HiveDrug=true;
                                        }else{
                                            HiveDrug=false;
                                        }
                                        newHive = new Hive(HiveSize, HiveSerialNb, HiveMedicalCondition, HiveNbOfFrames, HiveFed, HiveDrug);
                                        System.out.println(ANSI_YELLOW + "-----------------------------------------"  + ANSI_RESET);
                                }else{                                    
                                        System.out.println(ANSI_RED + "Hive " + ANSI_GREEN + HiveSerialNb + ANSI_RED + " Already Exists!" + ANSI_RESET);
                                        break;  
                                }
                                System.out.println(ANSI_YELLOW + "BEES:"  + ANSI_RESET);
                                System.out.println(ANSI_YELLOW + "--------"  + ANSI_RESET);
                                System.out.println(ANSI_CYAN + "Type Of Bee 'Species' :"  + ANSI_RESET);
                                String BeeType=console.next();
                                System.out.println(ANSI_CYAN + "Estimated Number Of Bees:"  + ANSI_RESET);
                                int EstimatesNbOfBees=console.nextInt();
                                System.out.println(ANSI_CYAN + "Life Span(days) :" + ANSI_RESET);
                                int LifeSpan=console.nextInt();
                                System.out.println(ANSI_CYAN + "Efficiency Of Bees:"  + ANSI_RESET);
                                int EfficiencyOfBee=console.nextInt();
                                GeneralBees newBee = new Bee(BeeType, EfficiencyOfBee, LifeSpan, EstimatesNbOfBees);
                                System.out.println(ANSI_YELLOW + "-----------------------------------------"  + ANSI_RESET);
                                System.out.println(ANSI_YELLOW + "QUEENBEE:"  + ANSI_RESET);
                                System.out.println(ANSI_YELLOW + "--------"  + ANSI_RESET);
                                boolean QueenBeeType=true;
                                System.out.println(ANSI_CYAN + "Egg Laying Rate:"  + ANSI_RESET);
                                int QueenBeeEggLayingRate=console.nextInt();
                                System.out.println(ANSI_CYAN + "Life Span(years) :"  + ANSI_RESET);
                                int QueenBeeLifeSpan=console.nextInt();
                                System.out.println(ANSI_CYAN + "Medical Health 'Description' "  + ANSI_RESET);
                                String QueenBeeMedicalHealth=console.next();
                                GeneralBees newQueenBee = new QueenBee(QueenBeeType, QueenBeeEggLayingRate, QueenBeeLifeSpan, QueenBeeMedicalHealth);
                                newHive.addBee(newBee);
                                newHive.addQueenBee(newQueenBee);
                                newApiary.addHiveToApiary(newHive);
                                SignedIn.getBeeKeeper().addApiaryToBeekeeperUser(newApiary);
                                break;
                            //Edit or Remove(Apiary/Hive/QueenBee)
                            case 2:
                                System.out.println(ANSI_YELLOW + "1) Edit\n2) Remove"  + ANSI_RESET);
                                int EditOrRemove = console.nextInt();
                                switch(EditOrRemove){
                                    //Edit
                                    case 1:
                                        System.out.println(ANSI_YELLOW + "1) Edit Apiary\n2) Edit Hive\n3) Edit QueenBee"  + ANSI_RESET);
                                        int EditOption = console.nextInt();
                                        switch(EditOption){
                                            //Edit Apiary
                                            case 1:
                                                System.out.println(ANSI_CYAN + "Enter The Apiary Serial Nb:"  + ANSI_RESET);
                                                int EditApiarySerialNb=console.nextInt();
                                                CheckApiary = SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                                if(CheckApiary!=null){
                                                    newApiary=SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                                    System.out.println(ANSI_YELLOW + "APIARY:" + ANSI_GREEN + " " + newApiary.getApiarySerialNB() + " " + ANSI_RESET);
                                                    System.out.println(ANSI_YELLOW + "--------" + ANSI_RESET);
                                                    System.out.println(ANSI_CYAN + "Apiary Name:" + ANSI_RESET);
                                                    ApiaryName=console.next();
                                                    System.out.println(ANSI_CYAN + "Apiary SerialNb:" + ANSI_RESET);
                                                    ApiarySerialNB=console.nextInt();
                                                    System.out.println(ANSI_CYAN + "Apiary Location:" + ANSI_RESET);
                                                    ApiaryLocation=console.next();
                                                    newApiary.setApiaryName(ApiaryName);
                                                    newApiary.setApiarySerialNB(ApiarySerialNB);
                                                    newApiary.setLocation(ApiaryLocation);
                                                    break;
                                                }else{
                                                    System.out.println(ANSI_RED + "Apiary " + ANSI_GREEN + EditApiarySerialNb + ANSI_RED + " Doesn't Exist!" + ANSI_RESET);
                                                    break;
                                                }
                                            //Edit Hive    
                                            case 2:
                                                System.out.println(ANSI_CYAN + "Enter The Hive Serial Nb:" + ANSI_RESET);
                                                int EditHiveSerialNb=console.nextInt();
                                                CheckApiaryThatContainsHiveSerialNb = SignedIn.getBeeKeeper().FindApiaryBYSerialNBfromHive(EditHiveSerialNb);
                                                Hive EditHive;
                                                if(CheckApiaryThatContainsHiveSerialNb!=null){
                                                    EditHive=CheckApiaryThatContainsHiveSerialNb.FindHiveBYSerialNBfromApiary(EditHiveSerialNb);
                                                    System.out.println(ANSI_YELLOW + "HIVE:" + ANSI_GREEN + " " + EditHive.getHiveSerialNb() + " " + ANSI_RESET );
                                                    System.out.println(ANSI_YELLOW + "--------" + ANSI_RESET);
                                                    System.out.println(ANSI_CYAN + "Hive Size:" + ANSI_RESET);
                                                    HiveSize= console.nextInt();
                                                    System.out.println(ANSI_CYAN + "Hive Serial Number:" + ANSI_RESET);
                                                    HiveSerialNb=console.nextInt();
                                                    System.out.println(ANSI_CYAN + "Medical Condition(1-10):" + ANSI_RESET);
                                                    HiveMedicalCondition=console.nextInt();
                                                    System.out.println(ANSI_CYAN + "Number Of Frames:" + ANSI_RESET);
                                                    HiveNbOfFrames=console.nextInt();
                                                    System.out.println(ANSI_CYAN + "Are They Fed?(Y,N)" + ANSI_RESET);
                                                    HiveFeeding=console.next().charAt(0);
                                                    HiveFed=true;
                                                    if(HiveFeeding=='Y'){
                                                        HiveFed=true;
                                                    }else{
                                                        HiveFed=false;
                                                    }
                                                    System.out.println(ANSI_CYAN + "Are They Drugged?(Y,N)" + ANSI_RESET);
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
                                            }else{
                                                System.out.println(ANSI_RED + "Hive " + ANSI_GREEN + EditHiveSerialNb + ANSI_RED + " Doesn't Exist!" + ANSI_RESET);
                                                break;
                                            }
                                            //Edit QueenBee
                                            case 3:
                                            System.out.println(ANSI_CYAN + "Enter The Hive Serial Nb:" + ANSI_RESET);
                                            EditHiveSerialNb=console.nextInt();
                                            CheckApiaryThatContainsHiveSerialNb = SignedIn.getBeeKeeper().FindApiaryBYSerialNBfromHive(EditHiveSerialNb);
                                            if(CheckApiaryThatContainsHiveSerialNb!=null){
                                                EditHive=CheckApiaryThatContainsHiveSerialNb.FindHiveBYSerialNBfromApiary(EditHiveSerialNb);
                                                System.out.println(ANSI_YELLOW + "QUEENBEE:" + ANSI_RESET);
                                                System.out.println(ANSI_YELLOW + "--------" + ANSI_RESET);
                                                QueenBeeType=true;
                                                System.out.println(ANSI_CYAN + "Egg Laying Rate:" + ANSI_RESET);
                                                QueenBeeEggLayingRate=console.nextInt();
                                                System.out.println(ANSI_CYAN + "Life Span:(years)" + ANSI_RESET);
                                                QueenBeeLifeSpan=console.nextInt();
                                                System.out.println(ANSI_CYAN + "Medical Health" + ANSI_RESET);
                                                QueenBeeMedicalHealth=console.next();
                                                newQueenBee = new QueenBee(QueenBeeType, QueenBeeEggLayingRate, QueenBeeLifeSpan, QueenBeeMedicalHealth);
                                                EditHive.ChangeQueenBee(newQueenBee);
                                                break;
                                            }else{
                                                System.out.println(ANSI_RED + "Hive " + ANSI_GREEN + EditHiveSerialNb + ANSI_RED + " Doesn't Exist!" + ANSI_RESET);
                                                break;
                                            }
                                            default:
                                                System.out.println(ANSI_RED + "Wrong Edit Option!" + ANSI_RESET);
                                                break;
                                        }
                                        break;
                                    //Remove
                                    case 2:
                                    System.out.println(ANSI_YELLOW + "1) Remove Apiary\n2) Remove Hive" + ANSI_RESET);
                                    EditOption = console.nextInt();
                                    switch(EditOption){
                                        //Remove Apiary
                                        case 1:
                                            System.out.println(ANSI_CYAN + "Enter The Apiary Serial Nb:" + ANSI_RESET);
                                            int EditApiarySerialNb=console.nextInt();
                                            newApiary=SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                            if(newApiary!=null){
                                                SignedIn.getBeeKeeper().apiary.remove(newApiary);
                                                System.out.println(ANSI_YELLOW + "Successfully Removed Apiary!" + ANSI_RESET);
                                            }else{
                                                System.out.println(ANSI_RED + "Apiary Not Found!" + ANSI_RESET);
                                            }
                                            break;
                                        //Remove Hive
                                        case 2:
                                            System.out.println(ANSI_CYAN + "Enter The Apiary Serial Nb:" + ANSI_RESET);
                                            EditApiarySerialNb=console.nextInt();
                                            newApiary=SignedIn.getBeeKeeper().SearchApiaryBySerialNb(EditApiarySerialNb);
                                            if(newApiary!=null){
                                                System.out.println(ANSI_CYAN + "Enter The Hive Serial Nb:" + ANSI_RESET);
                                                int EditHiveSerialNb=console.nextInt();
                                                Hive EditHive=newApiary.FindHiveBYSerialNBfromApiary(EditHiveSerialNb);
                                                if(EditHive!=null){
                                                    newApiary.removeHivefromApiary(EditHive);
                                                    System.out.println(ANSI_YELLOW + "Successfully Removed Hive!" + ANSI_RESET);
                                                }else{
                                                    System.out.println(ANSI_RED + "Hive Not Found!" + ANSI_RESET);
                                                }
                                            }else{
                                                System.out.println(ANSI_RED + "Apiary Not Found!" + ANSI_RESET);
                                            }
                                            break;
                                        default:
                                            System.out.println(ANSI_RED + "Wrong Edit Option!" + ANSI_RESET);
                                            break;
                                    }
                                        break;

                                    default:
                                        System.out.println(ANSI_RED + "Wrong Edit Or Remove Option!" + ANSI_RESET);
                                        break;
                                }
                                break;
                            //View Apiary
                            case 3:
                                SignedIn.getBeeKeeper().ListApiary();
                                break;
                            default:
                                System.out.println(ANSI_RED + "Invalid Add/Edit/Remove Option!" + ANSI_RESET);
                                break;
                        }
                        break;
                    //Customer Management
                    case 2:
                        System.out.println(ANSI_YELLOW + "1) Add\n2) Ban\n3) View" + ANSI_RESET);
                        Option = console.nextInt();
                        switch(Option){
                            //Add Customers
                            case 1:
                                System.out.println(ANSI_CYAN + "How many Customers Do You Want To Add?" + ANSI_RESET);
                                int NumberOfCustomers= console.nextInt();
                                int counter=0;
                                while(counter!=NumberOfCustomers){
                                    System.out.println(ANSI_CYAN + "Enter Customer " + counter + " First Name: " + ANSI_RESET);
                                    String CustomerFName=console.next();
                                    System.out.println(ANSI_CYAN + "Enter Customer " + counter + "  Last Name: " + ANSI_RESET);
                                    String CustomerLName=console.next();
                                    System.out.println(ANSI_CYAN + "Enter Customer " + counter + " email: " + ANSI_RESET);
                                    String CustomerEmail=console.next();
                                    System.out.println(ANSI_CYAN + "Enter Customer " + counter + " Address: " + ANSI_RESET);
                                    String CustomerAddress=console.next();
                                    System.out.println(ANSI_CYAN + "Enter Customer " + counter + " PhoneNumber: " + ANSI_RESET);
                                    int CustomerPhoneNb=console.nextInt();
                                    Customers newCustomer = new Customers(CustomerFName, CustomerLName, CustomerEmail, CustomerAddress, CustomerPhoneNb);
                                    SignedIn.getBeeKeeper().s.addCustomer(newCustomer, CustomerEmail);
                                    counter++;
                                }
                                break;
                            //Ban Customer
                            case 2:
                                System.out.println(ANSI_CYAN + "Enter Customer's Email You Wish To Ban:" + ANSI_RESET);
                                String BanningEmail=console.next();
                                Customers BannedCustomer=SignedIn.getBeeKeeper().s.SearchCustomerbyEmail(BanningEmail);
                                if(BannedCustomer!=null){
                                    SignedIn.getBeeKeeper().s.banCustomer(BannedCustomer, BanningEmail);
                                }else{
                                    System.out.println(ANSI_RED + "Customer With This Email Doesn't Exist!" + ANSI_RESET);
                                }
                                break;
                            //View Customers
                            case 3:
                                SignedIn.getBeeKeeper().ListAllCustomers();
                                break;
                            default:
                                System.out.println(ANSI_RED + "Invalid Add/Ban/View Option!" + ANSI_RESET);
                                break;
                        }            
                            break;
                    //Sales Management
                    case 3:
                        System.out.println(ANSI_YELLOW + "1) Add(Sales then Stock)\n2) Edit\n3) View" + ANSI_RESET);
                        Option = console.nextInt();
                        switch(Option){
                            //Add Sales And Stock
                            case 1:
                                System.out.println(ANSI_YELLOW + "SALES: " + ANSI_RESET);
                                System.out.println(ANSI_CYAN + "Enter Date(dd/MM/yyyy): " + ANSI_RESET);
                                String Date = console.next();                               
                                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date);
                                Sales CheckSalesByDate = SignedIn.getBeeKeeper().SearchSalesByDate(date1);
                                String Season;
                                int Revenue;
                                int HivesBought;
                                int JarsBought;
                                int FoodBought;
                                int DrugsBought;
                                int OperatingExpenses;
                                int Other;
                                int TotalNbOfJars;
                                int JarsFilledWithHoney;
                                int FoodUsed; 
                                int DrugsUsed;
                                if(CheckSalesByDate==null){
                                    System.out.println(ANSI_CYAN + "Enter Season (Spring,Summer) :" + ANSI_RESET);
                                    Season=console.next();
                                    System.out.println(ANSI_CYAN + "Enter Revenue: " + ANSI_RESET);
                                    Revenue = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Amount Of Hives Bought: " + ANSI_RESET);
                                    HivesBought =console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Amount Of Jars Bought: " + ANSI_RESET);
                                    JarsBought =console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Amount Of Food Bought: " + ANSI_RESET);
                                    FoodBought = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Amount Of Drugs Bought: " + ANSI_RESET);
                                    DrugsBought = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Operating Expenses: " + ANSI_RESET);
                                    OperatingExpenses = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Other Expenses: " + ANSI_RESET);
                                    Other= console.nextInt();                                                              
                                    System.out.println(ANSI_YELLOW + "-----------------------" + ANSI_RESET);
                                    System.out.println(ANSI_YELLOW + "STOCK: " + ANSI_RESET);
                                    System.out.println(ANSI_CYAN + "Enter Total Number Of Jars: " + ANSI_RESET);
                                    TotalNbOfJars = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Jars Filled With Honey: " + ANSI_RESET);
                                    JarsFilledWithHoney= console.nextInt();
                                    if(JarsFilledWithHoney>TotalNbOfJars){
                                        System.out.println(ANSI_RED + "Jars Filled With Honey Cant Be More Than The Total Number Of Jars!!" + ANSI_RESET);
                                    }else{
                                        System.out.println(ANSI_CYAN + "Food Used: " + ANSI_RESET);
                                        FoodUsed = console.nextInt();
                                        System.out.println(ANSI_CYAN + "Drugs Used: " + ANSI_RESET);
                                        DrugsUsed = console.nextInt();
                                        Sales newSales = new Sales(date1, Season, Revenue, HivesBought, JarsBought, FoodBought, DrugsBought, OperatingExpenses, Other);
                                        Stock newStock = new Stock(date1, TotalNbOfJars, JarsFilledWithHoney, FoodUsed, DrugsUsed);
                                        SignedIn.getBeeKeeper().addSalesToBeekeeperUser(date1, newSales);
                                        SignedIn.getBeeKeeper().addStockToBeekeeperUser(newStock);
                                    }
                                }else{
                                    System.out.println(ANSI_RED + "Sales And Stock With This Date " + ANSI_GREEN + date1 + ANSI_RED +" Already Exist!" + ANSI_RESET);
                                }
                                break;
                            //Edit Sales
                            case 2:
                                System.out.println(ANSI_CYAN + "Enter Date(dd/MM/yyyy): " + ANSI_RESET);
                                Date = console.next();
                                date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date);
                                Sales EditSales=SignedIn.getBeeKeeper().SearchSalesByDate(date1);
                                if(EditSales!=null){
                                    System.out.println(ANSI_CYAN + "Enter Season (Spring,Summer) :" + ANSI_RESET);
                                    Season=console.next();
                                    System.out.println(ANSI_CYAN + "Enter Revenue: " + ANSI_RESET);
                                    Revenue = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Amount Of Hives Bought: " + ANSI_RESET);
                                    HivesBought =console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Amount Of Jars Bought: " + ANSI_RESET);
                                    JarsBought =console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Amount Of Food Bought: " + ANSI_RESET);
                                    FoodBought = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Amount Of Drugs Bought: " + ANSI_RESET);
                                    DrugsBought = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Operating Expenses: " + ANSI_RESET);
                                    OperatingExpenses = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Enter Other Expenses: " + ANSI_RESET);
                                    Other= console.nextInt();
                                    EditSales.setSeason(Season);
                                    EditSales.setRevenue(Revenue);
                                    EditSales.setHivesBought(HivesBought);
                                    EditSales.setJarsBought(JarsBought);
                                    EditSales.setFoodBought(FoodBought);
                                    EditSales.setDrugsBought(DrugsBought);
                                    EditSales.setOperatingExpenses(OperatingExpenses);
                                    EditSales.setOther(Other);
                                    System.out.println(ANSI_YELLOW + "Successfuly Updated!" + ANSI_RESET);
                                }else{
                                    System.out.println(ANSI_RED + "Sales With This Date " + ANSI_GREEN + date1 + ANSI_RED +" Doesnt't Exist!" + ANSI_RESET);
                                }
                                break;
                            //View Sales
                            case 3:
                                SignedIn.getBeeKeeper().ListAllSales();
                                break;
                            default:
                                System.out.println(ANSI_RED + "Invalid Add/Edit/View Option!" + ANSI_RESET);
                                break;
                        }
                            break;
                    //Stock Management
                    case 4:
                    System.out.println(ANSI_YELLOW + "1) Edit\n2) View" + ANSI_RESET);
                    Option = console.nextInt();
                    switch(Option){
                        //Edit Stock
                        case 1:
                            System.out.println(ANSI_CYAN + "Enter Date(dd/MM/yyyy): " + ANSI_RESET);
                            String Date = console.next();
                            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date);
                            Stock EditStock=SignedIn.getBeeKeeper().SearchStockByDate(date1);
                            if(EditStock!=null){
                                System.out.println(ANSI_CYAN + "Enter Total Number Of Jars: " + ANSI_RESET);
                                int TotalNbOfJars = console.nextInt();
                                System.out.println(ANSI_CYAN + "Jars Filled With Honey: " + ANSI_RESET);
                                int JarsFilledWithHoney= console.nextInt();
                                if(JarsFilledWithHoney>TotalNbOfJars){
                                    System.out.println("Jars Filled With Honey Cant Be More Than The Total Number Of Jars!!" + ANSI_RESET);
                                }else{
                                    System.out.println(ANSI_CYAN + "Food Used: " + ANSI_RESET);
                                    int FoodUsed = console.nextInt();
                                    System.out.println(ANSI_CYAN + "Drugs Used: " + ANSI_RESET);
                                    int DrugsUsed = console.nextInt();
                                    EditStock.setTotalNbOfJars(TotalNbOfJars);
                                    EditStock.setJarsFilledWithHoney(JarsFilledWithHoney);
                                    EditStock.setFoodUsed(FoodUsed);
                                    EditStock.setDrugsUsed(DrugsUsed);
                                    System.out.println(ANSI_YELLOW + "Successfully Updated!" + ANSI_RESET);
                                }
                            }else{
                                System.out.println(ANSI_RED + "Stock With This Date " + ANSI_GREEN + date1 + ANSI_RED +" Doesn't Exist!" + ANSI_RESET);
                            }
                            break;
                        //View Stock
                        case 2:
                            SignedIn.getBeeKeeper().ListAllStock();
                            break;
                        default:
                            System.out.println(ANSI_RED + "Invalid Add/Edit/View Option!" + ANSI_RESET);
                            break;
                        }
                        break;
                    //Exit
                    case 5:
                        bool=false;
                        break;
                    default:
                        System.out.println(ANSI_RED + "Please Input a Valid Number!" + ANSI_RESET);
                        break;
                    }
                    
            }
            //Save data into the file
            writeObjectToFile(AllUsers, file);
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

  //Registration
  public static Users Registration(Users U,Scanner console){
        System.out.println(ANSI_YELLOW + "REGISTRATION:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "---------------------" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "First Name: " + ANSI_RESET);
        String FName = console.next();
        System.out.println(ANSI_CYAN + "Last Name: " + ANSI_RESET);
        String LName = console.next();
        System.out.println(ANSI_CYAN + "Phone Number: " + ANSI_RESET);
        int PhoneNumber = console.nextInt();
        System.out.println(ANSI_CYAN + "Address: " + ANSI_RESET);
        String Address = console.next();
        System.out.print(ANSI_CYAN + "Enter an email: " + ANSI_RESET);
        String email = console.next();
        System.out.print(ANSI_CYAN + "\nEnter Password: " + ANSI_RESET);
        String password = console.next();
        BeeKeeper B = new BeeKeeper(FName,LName,PhoneNumber,Address);
        Customers allCustomers=new Customers();
        B.addCustomersToBeekeeperUserNoPrint(allCustomers);
        U.setBeeKeeper(B);
        U.Register(email, password, B);
        Users SignedIn = U.Login(email, password);
        return SignedIn;
  }

  //Colors
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
