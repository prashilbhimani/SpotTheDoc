package application;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	@Id
	protected String userName;
	protected String password;
    private RoleType role;
    /*** Default constructor*/
    public User() {
    	
    }
    public User(String userName, String password) {
    	this.userName=userName;
    	this.password=password;
    }
    public User(String userName, String password, RoleType role) {
    	this.userName=userName;
    	this.password=password;
    	this.role=role;
    }
    
    
	/*** @param userName * @param password * @return*/
    //public static RoleType login(String userName, String password) {
    //	
    //}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
	
	public Boolean checkuserNameAvailability(String userName) {
        // TODO implement here
        return true;
    }
    
}
