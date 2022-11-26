import java.io.Serializable;
import java.util.ArrayList;
public class Apiary implements Serializable{
	ArrayList<Hive> Apiaryone=new ArrayList<Hive>(); 
	String ApiaryName ;
	int ApiarySerialNB;
	String Location;

	public Apiary() {
		ApiaryName="";
		ApiarySerialNB=0;
		Location="";
	}

	public Apiary(String apiaryName, int apiarySerialNB, String location) {
		ApiaryName = apiaryName;
		ApiarySerialNB = apiarySerialNB;
		Location = location;
		
	}

	public String getApiaryName() {
		return ApiaryName;
	}

	public void setApiaryName(String apiaryName) {
		ApiaryName = apiaryName;
	}

	public int getApiarySerialNB() {
		return ApiarySerialNB;
	}

	public void setApiarySerialNB(int apiarySerialNB) {
		ApiarySerialNB = apiarySerialNB;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	
	public void addHiveToApiary(Hive l) {	
		Apiaryone.add(l);
	}
	public boolean isEmpty(){
		return Apiaryone.size()==0;
	}
	
   public void removeHivefromApiary(Hive l) {
		Apiaryone.remove(l);
		return;
   }

    public void removeHiveBYSerialNBfromApiary(int l) {
	   for (int i = 0; i < Apiaryone.size();i++) 
	   { 		      
		    if(Apiaryone.get(i).getHiveSerialNb() == l ) {
			    Apiaryone.remove(i); 
		    }
	   }  
    }

   public Hive FindHiveBYSerialNBfromApiary(int l) {
	   for (int i = 0; i < Apiaryone.size();i++) 
	      { 		      
		 if(  Apiaryone.get(i).getHiveSerialNb() == l ) {
			 return Apiaryone.get(i)	; 
		 }
	      }
	   return null;
 	}


	public void  sortHivesInApiaryByQueenStatus() {
		for (int i = 0; i < Apiaryone.size();i++) 
	      { 		           
		 if( !Apiaryone.get(i).isQueenBeeExist()) {
			 for (int j = i; j < Apiaryone.size();j++) 
		      { 		        
			 if( Apiaryone.get(j).isQueenBeeExist()) {
				 Hive temp = Apiaryone.get(i);
				 Hive temp2 = Apiaryone.get(j);
				 Apiaryone.set(i, temp2);
				 Apiaryone.set(j, temp);
			 }			 
		 }
	}	
	      }
	}
	public void ListHivesInApiary() {
		for (int i = 0; i < Apiaryone.size();i++) 
		   { 		      
			 Apiaryone.get(i).HiveStatus();
		   }   
	}
	public void ApiaryStatus(){
		System.out.println(ANSI_CYAN + "Apiary: " + ANSI_GREEN  + getApiarySerialNB() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Name: "  + ANSI_GREEN + getApiaryName() + ANSI_RESET);
		System.out.println(ANSI_CYAN + "Location: "+  ANSI_GREEN + getLocation() + ANSI_RESET);
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
