
import java.util.*;

/**
 *
 */
public abstract class User {

    /**
     * Default constructor
     */
    public User() {
    }
    
    private String userName;
    private String password;
    private RoleType role;

    /**
     * @param userName
     * @param password
     * @return
     */
    public static RoleType login(String userName, String password) {
        // TODO implement here
        User u;
        u = Patient.getObjectByuserName(userName);
        if(u == null)
        {
            u = Doctor.getObjectByuserName(userName);
        }
        if (u == null){
            return null;
        }
        else{
            return u.getRole();
        }           
    }

    /**
     * @param userName
     * @return
     */
    public static Boolean checkuserNameAvailability(String userName) {
        // TODO implement here
        return null;
    }

    /**
     * @param userName
     * @param password
     * @param role
     * @return
     */
    public User User(String userName, String password, RoleType role) {
        // TODO implement here
        return null;
    }
    /**
     * @return
     */
    public String getuserName() {
        // TODO implement here
        return userName;
    }

    /**
     * @param value
     * @return
     */
    public void setuserName(String value) {
        // TODO implement here
        userName = value;
    }

    /**
     * @return
     */
    public String getPassword() {
        // TODO implement here
        return password;
    }

    /**
     * @param value
     * @return
     */
    public void setPassword(String value) {
        // TODO implement here
        password = value;
    }

    /**
     * @return
     */
    public RoleType getRole() {
        // TODO implement here
        return role;
    }

    /**
     * @param value
     * @return
     */
    public void setRole(RoleType value) {
        // TODO implement here
        role = value;
    }

}
