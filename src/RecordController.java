
import java.util.*;

/**
 *
 */
public class RecordController {

    
    /**
     * Default constructor
     */
    public RecordController() {
    }

    /**
     * @param comment
     * @return
     */
    public void addComment(String comment, Appointment appointment) {
        // TODO implement here
        appointment.getRecord().setComments(comment);
    }

    /**
     * @param prescription
     * @return
     */
    public void addPrescription(ArrayList<String> prescription, Appointment appointment) {
        // TODO implement here
        appointment.getRecord().appendPrescription(prescription); 
    }

    /**
     * @param userName
     * @return
     */
    public Record viewPatientRecord(String userName) {
        // TODO implement here
        return null;
    }

}
