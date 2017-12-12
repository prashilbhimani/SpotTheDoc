
import java.sql.Time;
import java.util.*;

/**
 *
 */
public class Doctor extends User implements Observer {

    /**
     * Default constructor
     */
    public Doctor(String password, String userName, Address address, ArrayList<String> specialization, String contact, String name, ArrayList<Time> officehours) {
        //addDoctorDetails(address, specialization, contact, name, officehours);
        setPassword(password);
        setuserName(userName);
        setAddress(address);
        setSpeciality(specialization);
        setPhoneNo(contact);
        setName(name);
        setOfficeHours(officehours);
        setRole(RoleType.Doctor);
    }

    /**
     *
     */
    private String name;
    private String phoneNo;
    private ArrayList<String> speciality;
    private Address address;
    private ArrayList<Time> officeHours;
    private ArrayList<Appointment> doctorAppointmentList;
    private static ArrayList<Doctor> doctorList;

    public ArrayList<Appointment> pendingAppointments;

    private static RecordController recordControllerObject;

    /**
     * @param date
     * @return
     */
    public ArrayList<Time> getAvailableSlot(Date date) {
        // TODO implement here
        return null;
    }

    /**
     * @param comment
     * @param Prescription
     * @param appointmentId
     * @return
     */
    public void addPatientRecord(String comment, ArrayList<String> prescription, Integer appointmentId) {
        // TODO implement here
        int appointmentIndex = 0;
        for (Appointment appointment : AppointmentController.appointmentList) {
            if (Objects.equals(appointmentId, appointment.getAppointmentId())) {
                appointmentIndex = AppointmentController.appointmentList.indexOf(appointment);
                AppointmentController.appointmentList.get(appointmentIndex).setRecord(new Record());
            }
        }
        recordControllerObject.addComment(comment, AppointmentController.appointmentList.get(appointmentIndex));
        recordControllerObject.addPrescription(prescription, AppointmentController.appointmentList.get(appointmentIndex));

    }

    /**
     * @param address
     * @param specialization
     * @param contact
     * @param name
     * @param officehours
     * @return
     */
    public static Boolean addDoctorDetails(String password, String userName, Address address, ArrayList<String> specialization, String contact, String name, ArrayList<Time> officehours) {
        // TODO implement here
        if (User.checkuserNameAvailability(userName)) {
            Doctor d = new Doctor(password, userName, address, specialization, contact, name, officehours);
            doctorList.add(d);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return
     */
    public ArrayList<Doctor> getAllDoctors() {
        // TODO implement here
        return doctorList;
    }

    /**
     * @param userName
     * @return
     */
    public static Doctor getObjectByuserName(String userName) {
        // TODO implement here
        for (Doctor doctor : getDoctorList()) {
            if (userName.equals(doctor.getuserName())) {
                return doctor;
            }
        }
        return null;
    }

    /**
     * @return
     */
    public void updateDoctorRoleType() {
        // TODO implement here

    }

    /**
     * @param name
     * @return
     */
    public static ArrayList<Doctor> getDoctorByName(String name) {
        // TODO implement here
        ArrayList<Doctor> returnDoctorList = new ArrayList<Doctor>();
        for (Doctor doctor : getDoctorList()) {
            if (name.equals(doctor.getName())) {
                returnDoctorList.add(doctor);
            }
        }
        return returnDoctorList;
    }

    /**
     * @param location
     * @return
     */
    public static ArrayList<Doctor> getDoctorByLocation(String location) {
        // TODO implement here
        ArrayList<Doctor> returnDoctorList = new ArrayList<Doctor>();
        for (Doctor doctor : getDoctorList()) {
            if (location.equals(doctor.getAddress().getNeighbourhoodLocation())) {
                returnDoctorList.add(doctor);
            }
        }
        return returnDoctorList;
    }

    /**
     * @param specialization
     * @return
     */
    public static ArrayList<Doctor> getDoctorBySpecialization(String specialization) {
        // TODO implement here
        ArrayList<Doctor> returnDoctorList = new ArrayList<Doctor>();
        for (Doctor doctor : getDoctorList()) {
            if (specialization.equals(doctor.getSpeciality())) {
                returnDoctorList.add(doctor);
            }
        }
        return returnDoctorList;
    }

    /**
     * @return
     */
    public ArrayList<Appointment> getAppointmentSchedule() {
        // TODO implement here
        return doctorAppointmentList;
    }

    /**
     *
     */
    public void removeFromList() {
        // TODO implement here

    }

    /**
     *
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
     *
     */
    public void setName(String value) {
        // TODO implement here
        name = value;
    }

    /**
     * @return
     */
    public String getPhoneNo() {
        // TODO implement here
        return phoneNo;
    }

    /**
     * @param value
     *
     */
    public void setPhoneNo(String value) {
        // TODO implement here
        phoneNo = value;
    }

    /**
     * @return
     */
    public ArrayList<String> getSpeciality() {
        // TODO implement here
        return speciality;
    }

    /**
     * @param value
     *
     */
    public void setSpeciality(ArrayList<String> value) {
        // TODO implement here
        for (String v : value) {
            speciality.add(v);
        }
    }

    /**
     * @return
     */
    public Address getAddress() {
        // TODO implement here
        return address;
    }

    /**
     * @param value
     *
     */
    public void setAddress(Address value) {
        // TODO implement here
        address = value;
    }

    /**
     *
     */
    public ArrayList<Time> getOfficeHours() {
        // TODO implement here
        return officeHours;
    }

    /**
     * @param value
     *
     */
    //public void setOfficeHours(void value) {
    public void setOfficeHours(ArrayList<Time> value) {
        // TODO implement here
        for (Time v : value) {
            officeHours.add(v);
        }
    }

    /**
     * @return
     */
    public ArrayList<Appointment> getAppointmentList() {
        // TODO implement here
        return doctorAppointmentList;
    }

    /**
     * @return
     */
    public static ArrayList<Doctor> getDoctorList() {
        // TODO implement here
        return doctorList;
    }

    /**
     * @param appointment
     *
     */
    public void addToAppointmentList(Appointment appointment) {
        // TODO implement here
        doctorAppointmentList.add(appointment);
    }

    /**
     * @param id
     * @return
     */
    public static Appointment getObjectByID(Integer id) {
        // TODO implement here
        return null;
    }

    /**
     * @param appointment
     * @return
     */
    public void update(Appointment appointment) {
        // TODO implement here
        if (appointment.getStatus().equals(Status.Pending)) {
            pendingAppointments.add(appointment);
        }
    }
}
