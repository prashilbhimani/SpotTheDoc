
import java.util.*;

/**
 * 
 */
public class Admin extends User {

    /**
     * Default constructor
     */
    protected Admin() {
    }

    /**
     * 
     */
    private static Admin admin;




    /**
     * @param doctor 
     * @return
     */
    public void approveDoctor(Doctor doctor) {
        // TODO implement here

    }

    /**
     * @return
     */
    public ArrayList<Doctor> viewAllDoctors() {
        // TODO implement here
        return null;
    }

    /**
     * @param doctor 
     * @return
     */
    public void deleteDoctor(Doctor doctor) {
        // TODO implement here

    }

    /**
     * @return
     */
    public void save() {
        // TODO implement here

    }

    /**
     * @return
     */
    public static Admin getInstance() {
        // TODO implement here
        if(admin == null){
            admin = new Admin();
        }
        return admin;
    }

}