
import java.util.ArrayList;
public class Apiary {

	String ApiaryName ;
	int ApiarySerialNB;
	double Coordinates;
	String Location;
	public Apiary() {
		ApiaryName="";
		ApiarySerialNB=0;
		Coordinates=0.0;
		Location="";
		
		
	}
	public Apiary(String apiaryName, int apiarySerialNB, double coordinates, String location) {
		ApiaryName = apiaryName;
		ApiarySerialNB = apiarySerialNB;
		Coordinates = coordinates;
		Location = location;
		
	}
	ArrayList<Hive> Apiaryone=new ArrayList<Hive>(); 
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
	public double getCoordinates() {
		return Coordinates;
	}
	public void setCoordinates(int coordinates) {
		Coordinates = coordinates;
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
	
   public void ListHivesInApiary() {
	   for (int i = 0; i < Apiaryone.size();i++) 
	      { 		      
	        System.out.println("Hive Serial Number : "+ Apiaryone.get(i).getHiveSerialNb());  
		  
		   
		   
	      }   
   }
	
   public void removeHivefromApiary(Hive l) {
		
		Apiaryone.remove(l);
		
		
	}
   public void removeHiveBYSerialNBfromApiary(int l) {
	   for (int i = 0; i < Apiaryone.size();i++) 
	      { 		      
	       
		 if(  Apiaryone.get(i).getHiveSerialNb() == l ) {
			 Apiaryone.remove(i);
			 
		 }
		   
		   
	      }  
 	
 		
 	}
   public boolean FindHiveBYSerialNBfromApiary(int l) {
	   boolean check=false;
	   for (int i = 0; i < Apiaryone.size();i++) 
	      { 		      
	       
		 if(  Apiaryone.get(i).getHiveSerialNb() == l ) {
			 check=true;
			 
		 }
		   
		   
	      }
	   return check;
 	
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
	
	
	
}
