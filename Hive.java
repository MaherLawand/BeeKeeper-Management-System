public class Hive {
    GeneralBees First;
    private int Size;
    private int HiveSerialNb;
    private int MedicalCondition;
    private int NbOfFrames;
    private boolean Food;
    private boolean Drugs;

    public Hive(){
    	First=null;
        Size=0;
        HiveSerialNb=0;
        MedicalCondition=0;
        NbOfFrames=0;
        Food=false;
        Drugs=false;
    }
    public Hive(int Size,int HiveSerialNb, int MedicalCondition, int NbOfFrames,boolean Food,boolean Drugs){
    	First=null;
        this.Size=Size;
        this.HiveSerialNb=HiveSerialNb;
        this.MedicalCondition=MedicalCondition;
        this.NbOfFrames=NbOfFrames;
        this.Food=Food;
        this.Drugs=Drugs;
    }
    public void addBee(String typeOfBee, int efficiencyOfBee, int lifeSpan, int estimatesNbOfBees){
        GeneralBees bee=new Bee(typeOfBee,efficiencyOfBee,lifeSpan,estimatesNbOfBees);
        double Percent=0.0;
        Percent=((estimatesNbOfBees*0.23)/Size)*100;
        if(PercentageOfHiveFilled()+Percent<=100) {
        GeneralBees current=First;
        if(First==null){
            First=bee;
        }else{
            while(current.next!=null){
                current=current.next;
            }
            current.next=bee;
        }  
        }else {
        	System.out.println("Number of Bees Exceeded the Hive Capacity!");
        	System.out.println("--------------------------------------------");
        }
    }
    public boolean isEmpty() {
    	return First==null;
    }
    public boolean isQueenBeeExist(){
        return First.TypeOfQueenBee;
    }
    public void addQueenBee(boolean typeOfQueenBee, int eggLayingRate, int lifeSpan, String medicalHealth){
        GeneralBees bee=new QueenBee(typeOfQueenBee,eggLayingRate,lifeSpan,medicalHealth);
        if(isEmpty()) {
        	First=bee;
        }else if(isQueenBeeExist()) {
        	System.out.println("Queen Bee Already exists! Please Use ChangeQueenBee Method!");
        }
    }
    public void ChangeQueenBee(boolean typeOfQueenBee, int eggLayingRate, int lifeSpan, String medicalHealth) {
    	 GeneralBees bee=new QueenBee(typeOfQueenBee,eggLayingRate,lifeSpan,medicalHealth);
    	 bee.next=First.next;
    	 First=bee;
    }
    public double PercentageOfHiveFilled() {
    	GeneralBees Current=First;
    	int sum=0;
    	double Percent=0.0;
    	while(Current!=null) {    		
    		sum+=Current.EstimatesNbOfBees;
    		Current=Current.next;
    	}
    	Percent=((sum*0.23)/Size)*100;
    	return Percent;	
    }
    public double HiveEfficiency() {
    	GeneralBees Current=First;
    	int sum=0;
    	double Efficiency=0.0;
    	while(Current!=null) {    		
    		sum+=Current.EstimatesNbOfBees;
    		Current=Current.next;
    	}
    	Efficiency=HoneyProduced()/sum;
    	return Efficiency;	
    }
    public double HoneyProduced(){
    	GeneralBees Current=First;
    	double Honey=0.0;
    	while(Current!=null) {    		
    		Honey+=(Current.EstimatesNbOfBees*Current.EfficiencyOfBee);
    		Current=Current.next;
    	}
    	return Honey;	
    }
    public void HiveStatus(){
        GeneralBees BeeCurrent=First;
        while(BeeCurrent!=null){
        	if(BeeCurrent.TypeOfQueenBee) {
        		System.out.println("Queen Bee: "+ BeeCurrent.TypeOfQueenBee +"\n" + "Egg Laying Rate: " + BeeCurrent.EggLayingRate + "\n" + "LifeSpan: " + BeeCurrent.LifeSpan + "\n" + "Medical Health: " +BeeCurrent.MedicalHealth);
        		System.out.println("--------------------------------------------");
        	}else {
        		System.out.println("Type of Bee: "+ BeeCurrent.TypeOfBee +"\n" + "Efficiency of Bee: " + BeeCurrent.EfficiencyOfBee + "\n" + "LifeSpan: " + BeeCurrent.LifeSpan + "\n" + "Estimated Number Of Bees: " +BeeCurrent.EstimatesNbOfBees);
        		System.out.println("--------------------------------------------");
        	}
            BeeCurrent=BeeCurrent.next;         
        }
        System.out.println("Percentage of Hive Filled: " + PercentageOfHiveFilled());
        System.out.println("Hive Efficiency: " + HiveEfficiency());
        System.out.println("Honey Produced: " + HoneyProduced());
    }
    public void addFrame(int i) {
    	NbOfFrames = NbOfFrames +i;
    	System.out.println(" Frames Added: " + i );
    	
    }
    public void removeFrame(int i) {
    	NbOfFrames = NbOfFrames -i;
    	System.out.println(" Frames Removed: " + i );
    	
    }
	public int getHiveSerialNb() {
		
		return HiveSerialNb;
	}
	public void setHiveSerialNb(int hiveSerialNb) {
		HiveSerialNb = hiveSerialNb;
	}
    
    
    
    
}
