package SpotTheDoc;

public class User {
	
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
    
    public RoleType login() {
        // TODO implement here 
    	return login(this.userName, this.password);
    }
    
	/*** @param userName * @param password * @return*/
    public RoleType login(String userName, String password) {
        // TODO implement here 
    	return RoleType.Patient;
    }
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
