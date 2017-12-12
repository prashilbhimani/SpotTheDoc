
import java.util.*;

/**
 *
 */
public class Patient extends User implements Observer {

    /**
     * Default constructor
     */
    public Patient(String name, String userName, String password) {
        //addPatientDetails(name, userName, password);
        setName(name);
        setRole(RoleType.Patient);
        setuserName(userName);
        setPassword(password);
    }

    private String name;
    private ArrayList<Appointment> patientAppointmentList;
    private static ArrayList<Patient> patientList;

    /**
     * @param userName
     * @return
     */
    public static Boolean addPatientDetails(String name, String userName, String password) {
        if (User.checkuserNameAvailability(userName)) {
            appendPatientList(new Patient(name, userName, password));
            return true;
        } else {
            return false;
        }
    }

    public static Patient getObjectByuserName(String userName) {
        // TODO implement here
        for (Patient patient : getPatientList()) {
            if (userName.equals(patient.getuserName())) {
                return patient;
            }
        }
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Appointment> getAppointmentSchedule() {
        // TODO implement here
        return patientAppointmentList;
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
    public String getName() {
        // TODO implement here
        return name;
    }

    /**
     * @param value
     * @return
     */
    public void setName(String value) {
        // TODO implement here
        name = value;
    }

    /**
     * @return
     */
    public ArrayList<Appointment> getAppointmentList() {
        // TODO implement here
        return patientAppointmentList;
    }

    /**
     * @param value
     * @return
     */
    public void updateAppointmentList(Appointment value) {
        // TODO implement here
        patientAppointmentList.add(value);
    }

    /**
     * @return
     */
    public static ArrayList<Patient> getPatientList() {
        // TODO implement here
        return patientList;
    }

    /**
     * @param value
     * @return
     */
    public static void appendPatientList(Patient value) {
        // TODO implement here
        patientList.add(value);
    }

    /**
     * @param id
     * @return
     */
    public static Appointment getObjectByID(Integer id) {
        // TODO implement here
        return null;
    }

    public void update(Appointment appointment) {
        if (appointment.getStatus().equals(Status.Approved)) {
            updateAppointmentList(appointment);
        }
    }
}
