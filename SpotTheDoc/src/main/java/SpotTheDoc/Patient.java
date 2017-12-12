package SpotTheDoc;

import java.util.ArrayList;

public class Patient extends User implements Observer {
	

    private String name;
   // private ArrayList<Appointment> AppointmentList;
    /*private*/ static ArrayList<Patient> patientList = new ArrayList<Patient>();
    private static ArrayList<Appointment> patientAppointmentList = new ArrayList<Appointment>();
    

    /*** Default constructor*/
    public Patient(){
    	setRole(RoleType.Patient);
    }
    public Patient(String name, String userName, String password) {
    	super(userName,password,RoleType.Patient);
    	this.name=name;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String registerPatient() {
		 String content;
	        if (addPatientDetails()) {
	            content = "Registered successfully";
	        } else {
	            content = "Choose another userName";
	        }
	        return content;	
	}    
    /**
     * @param userName
     * @return
     */
    public Boolean addPatientDetails() {
        /* Patient list should not be the part of patient class.It contains list of patients and should be either part of singleton or separate singleton class*/
    	if (checkuserNameAvailability(this.userName)) {
            patientList.add(this);
            return true;
        } else {
            return false;
        }
    }

    public static Patient getObjectByuserName(String userName) {
        // TODO implement here
        for (Patient patient : getPatientList()) {
            if (userName.equals(patient.getUserName())) {
                return patient;
            }
        }
        return null;
    }
    public static ArrayList<Patient> getPatientList() {
        // TODO implement here
        return patientList;
    }
    
    public void update(Appointment appointment) {
        if (appointment.getStatus().equals(Status.Approved)) {
            updateAppointmentList(appointment);
        }
    }
    
    /**
     * @param value
     * @return
     */
    public void updateAppointmentList(Appointment value) {
        // TODO implement here
        patientAppointmentList.add(value);
    }
//
//    /**
//     * @return
//     */
//    public ArrayList<Appointment> getAppointmentSchedule() {
//        // TODO implement here
//        return null;
//    }
//
//    /**
//     * @return
//     */
//    public void save() {
//        // TODO implement here
//
//    }
//
//    /**
//     * @return
//     */
//    public String getName() {
//        // TODO implement here
//        return "";
//    }
//
//    /**
//     * @param value
//     * @return
//     */
//    public void setName(String value) {
//        // TODO implement here
//
//    }
//
//    /**
//     * @return
//     */
//    public ArrayList<Appointment> getAppointmentList() {
//        // TODO implement here
//        return null;
//    }
//
//    /**
//     * @param value
//     * @return
//     */
//    public void updateAppointmentList(Appointment value) {
//        // TODO implement here
//
//    }
//
//    /**
//     * @return
//     */

//
//    /**
//     * @param value
//     * @return
//     */
//    public static void appendPatientList(Patient value) {
//        // TODO implement here
//
//    }
//
//    /**
//     * @param id
//     * @return
//     */
//    public static Appointment getObjectByID(Integer id) {
//        // TODO implement here
//        return null;
//    }

}
