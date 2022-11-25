import java.io.Serializable;
import java.util.HashSet;

public class Users implements Serializable{
    HashSet<Users> users = new HashSet<Users>();
    private String email;
    private String password;
    private BeeKeeper BeeK;
    public Users(){
        email="";
        password="";
    }
    public Users(String email,String password,BeeKeeper BeeK){
        this.email=email;
        this.password=password;
        this.BeeK=BeeK;
    }
    public String getEmail() {
		return email;
	}
	public void setPassowrd(String password) {
		this.password = password;
	}
    public String getPassword() {
		return password;
	}
	public void setBeeKeeper(BeeKeeper BeeK) {
		this.BeeK = BeeK;
	}
    public BeeKeeper getBeeKeeper() {
		return BeeK;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    public boolean isEmpty(){
        return users.size()==0;
    }
    public void Register(String email,String pass,BeeKeeper B){
        Users[] allUsers = users.toArray(new Users[users.size()]);
        for(int i=0; i< users.size();i++){
            if(allUsers[i].getEmail().equals(email)){
                System.out.println("Email Already Exists!");
                return;
            }
        }
            Users user = new Users(email,pass,B);
            users.add(user);
        
    }
    public Users Login(String email,String password){
        Users[] allUsers = users.toArray(new Users[users.size()]);
        int PasswordCount=0;
        int EmailCount=0;
        for(int i=0;i<users.size();i++){
            if(allUsers[i].getEmail().equals(email)){
                EmailCount++;
            }
            if(allUsers[i].getPassword().equals(password)){
                PasswordCount++;
            }
            if(allUsers[i].getEmail().equals(email) && allUsers[i].getPassword().equals(password)){
                return allUsers[i];
            }
        }
        if(EmailCount==0 && PasswordCount==0){
            System.out.println("Wrong Password and Email!"); 
        }else if(PasswordCount==0){
            System.out.println("Wrong Password!");
        }else{
            System.out.println("Wrong Email!");
        }
        return null;
    }
}
