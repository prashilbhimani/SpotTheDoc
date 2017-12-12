
import java.sql.Time;
import java.util.*;

/**
 *
 */
public class Controller {

    /**
     * Default constructor
     */
    private static AppointmentController appointmentControllerObject;
    private static RecordController recordControllerObject;
    
    public Controller() {

    }

    /**
     * @param password
     * @param name
     * @param userName
     * @param address
     * @param specialization
     * @param contact
     * @param officehours
     * @return
     */
    public String registerDoctor(String password, String name, String userName, Address address, ArrayList<String> specialization, String contact, ArrayList<Time> officehours) {
        String content;
        if (Doctor.addDoctorDetails(password, userName, address, specialization, contact, name, officehours)) {
            content = "Registered successfully";
        } else {
            content = "Choose another userName";
        }
        return content;
    }

    /**
     * @param password
     * @param name
     * @param userName
     * @return
     */
    public String registerPatient(String password, String name, String userName) {
        String content;
        if (Patient.addPatientDetails(name, userName, password)) {
            content = "Registered successfully";
        } else {
            content = "Choose another userName";
        }
        return content;
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    public RoleType login(String userName, String password) {
        // TODO implement here
        return User.login(userName, password);
    }

    /**
     * @param userName
     * @return
     */
    public void deleteDoctor(String userName) {
        // TODO implement here
        Doctor doctor = Doctor.getObjectByuserName(userName);
        Admin admin = Admin.getInstance();
        admin.deleteDoctor(doctor);

    }

    /**
     * @param userName
     * @return
     */
    public void approveDoctorRequest(String userName) {
        // TODO implement here
        Doctor doctor = Doctor.getObjectByuserName(userName);
        Admin admin = Admin.getInstance();
        admin.approveDoctor(doctor);
    }

    /**
     * @return
     */
    public ArrayList<Doctor> viewAllDoctors() {
        // TODO implement here
        Admin admin = Admin.getInstance();
        return admin.viewAllDoctors();
    }

    /**
     * @param userName
     * @return
     */
    public Doctor viewDoctorProfile(String userName) {
        // TODO implement here
        Doctor doctor = Doctor.getObjectByuserName(userName);
        return doctor;
    }

    /**
     * @param userName
     * @param date
     * @return
     */
    public ArrayList<Time> viewAvailableSlots(String userName, Date date) {
        // TODO implement here
        Doctor doctor = Doctor.getObjectByuserName(userName);
        return doctor.getAvailableSlot(date);
    }

    /**
     * @param name
     * @param specialization
     * @param location
     * @return
     */
    public ArrayList<Doctor> searchDoctor(String name, String specialization, String location) {
        // TODO implement here
        ArrayList<Doctor> doctorsMatched = new ArrayList<Doctor>();
        ArrayList<Doctor> doctors;
        SearchController searchObject = new SearchController();
        doctors = searchObject.searchByName(name);
        for (Doctor doctor : doctors) {
            doctorsMatched.add(doctor);
        }
        doctors = searchObject.searchByLocation(location);
        for (Doctor doctor : doctors) {
            doctorsMatched.add(doctor);
        }
        doctors = searchObject.searchBySpecialisation(specialization);
        for (Doctor doctor : doctors) {
            doctorsMatched.add(doctor);
        }
        return doctorsMatched;
    }

    /**
     * @param comment
     * @param Prescription
     * @param appointmentId
     * @return
     */
    public void updatePatientRecord(String comment, ArrayList<String> prescription, Integer appointmentId) {
        // TODO implement here
        Record r = new Record();
        Appointment appObject = Patient.getObjectByID(appointmentId);
        appObject.setRecord(r);
        recordControllerObject.addComment(comment, appObject);
        recordControllerObject.addPrescription(prescription, appObject);
    }

    /**
     * @param userName
     * @param time
     * @param date
     * @return
     */
    public String scheduleAppointment(String userName, Time time, Date date) {
        // TODO implement here
        appointmentControllerObject.createAppointment(userName, time, date);
        return "Appointment Created successfully - waiting for doctor approval.";
    }

}
