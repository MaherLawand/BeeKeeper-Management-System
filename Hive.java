import java.io.Serializable;

public class Hive implements Serializable{
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
    public int getSize() {
        return Size;
    }
    public void setSize(int size) {
        Size = size;
    }
    public int getMedicalCondition() {
        return MedicalCondition;
    }
    public void setMedicalCondition(int medicalCondition) {
        MedicalCondition = medicalCondition;
    }
    public int getNbOfFrames() {
        return NbOfFrames;
    }
    public void setNbOfFrames(int nbOfFrames) {
        NbOfFrames = nbOfFrames;
    }
    public boolean isFood() {
        return Food;
    }
    public void setFood(boolean food) {
        Food = food;
    }
    public boolean isDrugs() {
        return Drugs;
    }
    public void setDrugs(boolean drugs) {
        Drugs = drugs;
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
    public GeneralBees getFirst() {
        return First;
    }
    public void setFirst(GeneralBees first) {
        First = first;
    }
    public void addBee(GeneralBees bee){
        double Percent=0.0;
        Percent=((bee.EstimatesNbOfBees*0.23)/Size)*100;
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
        	System.out.println(ANSI_RED + "Number of Bees Exceeded the Hive Capacity!" + ANSI_RESET);
        	System.out.println(ANSI_YELLOW + "--------------------------------------------" + ANSI_RESET);
        }
    }
    public boolean isEmpty() {
    	return First==null;
    }
    public boolean isQueenBeeExist(){
        return First.TypeOfQueenBee;
    }
    public void addQueenBee(GeneralBees bee){
        	First=bee;     
    }
    public void ChangeQueenBee(GeneralBees bee) {
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
        System.out.println(ANSI_CYAN + "Hive: " + ANSI_GREEN + getHiveSerialNb() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Size: " +ANSI_GREEN + getSize() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Medical Condition (1-10) : " +ANSI_GREEN + getMedicalCondition() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Number Of Frames: " +ANSI_GREEN + getNbOfFrames() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Fed: " +ANSI_GREEN + isFood() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Drugged: " +ANSI_GREEN + isDrugs() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Percentage of Hive Filled % : " +ANSI_GREEN + PercentageOfHiveFilled() +" %" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Hive Efficiency : " +ANSI_GREEN + HiveEfficiency() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Honey Produced : " +ANSI_GREEN + HoneyProduced()+" L" + ANSI_RESET);
        GeneralBees BeeCurrent=First;
        while(BeeCurrent!=null){
        	if(BeeCurrent.TypeOfQueenBee) {
        		System.out.println(ANSI_CYAN+ "Queen Bee: "+ ANSI_GREEN + BeeCurrent.TypeOfQueenBee +"\n" + ANSI_CYAN + "Egg Laying Rate: " + ANSI_GREEN + BeeCurrent.EggLayingRate + "\n" + ANSI_CYAN + "LifeSpan: " + ANSI_GREEN + BeeCurrent.LifeSpan + "\n" + ANSI_CYAN +  "Medical Health: " + ANSI_GREEN + BeeCurrent.MedicalHealth + ANSI_RESET);
        	}else {
        		System.out.println(ANSI_CYAN+ "Type of Bee: "+ ANSI_GREEN + BeeCurrent.TypeOfBee +"\n" + ANSI_CYAN + "Efficiency of Bee: " + ANSI_GREEN + BeeCurrent.EfficiencyOfBee + "\n" + ANSI_CYAN + "LifeSpan: " + ANSI_GREEN + BeeCurrent.LifeSpan + "\n" + ANSI_CYAN + "Estimated Number Of Bees: " + ANSI_GREEN + BeeCurrent.EstimatesNbOfBees + ANSI_RESET);
        	}
            BeeCurrent=BeeCurrent.next;         
        }
        
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
