
import java.util.*;

/**
 *
 */
public class SearchController {

    /**
     * Default constructor
     */
    public SearchController() {
    }

    /**
     * @param name
     * @return
     */
    public ArrayList<Doctor> searchByName(String name) {
        // TODO implement here
        return Doctor.getDoctorByName(name);
    }

    /**
     * @param location
     * @return
     */
    public ArrayList<Doctor> searchByLocation(String location) {
        // TODO implement here
        return Doctor.getDoctorByLocation(location);
    }

    /**
     * @param specialization
     * @return
     */
    public ArrayList<Doctor> searchBySpecialisation(String specialization) {
        // TODO implement here
        return Doctor.getDoctorBySpecialization(specialization);
    }

}
