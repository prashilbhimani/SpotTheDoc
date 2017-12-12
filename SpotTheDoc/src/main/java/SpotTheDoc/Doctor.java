package SpotTheDoc;

import java.sql.Time;
import java.util.ArrayList;

public class Doctor extends User implements Observer{
	    private String name;
	    private String phoneNo;
	    private ArrayList<String> speciality;
	    ArrayList<Time> officehours;
	    private Address address;
	   /* private */static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	   public ArrayList<Appointment> pendingAppointments = new ArrayList<Appointment>();
	   private ArrayList<Appointment> doctorAppointmentList = new ArrayList<Appointment>();
	    public Doctor(){
	    	setRole(RoleType.Doctor);
	    }  
	    
	    public String toString()
	    {
	    	return name;
	    }
	    public Doctor(String password,String userName,Address address,ArrayList<String> specialization,String phoneNo,String name,ArrayList<Time> officehours) {
	        //addDoctorDetails(address, specialization, contact, name, officehours);
	    	super(userName,password,RoleType.Doctor);
	    	this.address=address;
	    	this.speciality=specialization;
	    	this.phoneNo=phoneNo;
	    	this.name=name;
	    	this.officehours = officehours;
	    }
	    public ArrayList<Appointment> getAppointmentList() {
	        // TODO implement here
	        return doctorAppointmentList;
	    }

	    
	    public String registerDoctor() {
	        String content;
	        if (addDoctorDetails()) {
	            content = "Registered successfully";
	        } else {
	            content = "Choose another userName";
	        }
	        return content;
	    }
	    
	    
	    public  Boolean addDoctorDetails() {
	        // TODO implement here
	        if (checkuserNameAvailability(userName)) {
	            doctorList.add(this);
	            /*subject.attach(d);*/
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public ArrayList<String> getSpeciality() {
			return speciality;
		}
		public void setSpeciality(ArrayList<String> speciality) {
			this.speciality = speciality;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
	    
		public static ArrayList<Doctor> getDoctorList() {
	        // TODO implement here
	        return doctorList;
	    }
		public void addToAppointmentList(Appointment appointment) {
	        // TODO implement here
	        doctorAppointmentList.add(appointment);
	    }
		public static Doctor getObjectByuserName(String userName) {
	        // TODO implement here
	        for (Doctor doctor : getDoctorList()) {
	            if (userName.equals(doctor.getUserName())) {
	                return doctor;
	            }
	        }
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
	    
}/*


import java.sql.Time;
import java.util.*;

*//**
 *
 *//*
public class Doctor extends User implements Observer {

    *//**
     * Default constructor
     *//*
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

    *//**
     *
     *//*
    private String name;
    private String phoneNo;
    private ArrayList<String> speciality;
    private Address address;
    private ArrayList<Time> officeHours;
    private ArrayList<Appointment> appointmentList;
    private static ArrayList<Doctor> doctorList;
    public ArrayList<Appointment> observerState;

    private static Subject subject;
    private static RecordController recordControllerObject;

    *//**
     * @param date
     * @return
     *//*
    public ArrayList<Time> getAvailableSlot(Date date) {
        // TODO implement here
        return null;
    }

    *//**
     * @param comment
     * @param Prescription
     * @param appointmentId
     * @return
     *//*
    public void addPatientRecord(String comment, ArrayList<String> prescription, Integer appointmentId) {
        // TODO implement here
        recordControllerObject.addComment(comment);
        recordControllerObject.addPrescription(prescription);
        for (Appointment appointment : AppointmentController.appointmentList) {
            if (Objects.equals(appointmentId, appointment.getAppointmentId())) {
                int appointmentIndex = AppointmentController.appointmentList.indexOf(appointment);
                AppointmentController.appointmentList.get(appointmentIndex).setRecord(value); 
            }
        }
    }

    *//**
     * @param address
     * @param specialization
     * @param contact
     * @param name
     * @param officehours
     * @return
     *//*
    public static Boolean addDoctorDetails(String password, String userName, Address address, ArrayList<String> specialization, String contact, String name, ArrayList<Time> officehours) {
        // TODO implement here
        if (User.checkuserNameAvailability(userName)) {
            Doctor d = new Doctor(password, userName, address, specialization, contact, name, officehours);
            doctorList.add(d);
            subject.attach(d);
            return true;
        } else {
            return false;
        }
    }

    *//**
     * @return
     *//*
    public ArrayList<Doctor> getAllDoctors() {
        // TODO implement here
        return doctorList;
    }

    *//**
     * @param userName
     * @return
     *//*
    public static Doctor getObjectByuserName(String userName) {
        // TODO implement here
        for (Doctor doctor : getDoctorList()) {
            if (userName.equals(doctor.getuserName())) {
                return doctor;
            }
        }
        return null;
    }

    *//**
     * @return
     *//*
    public void updateDoctorRoleType() {        // TODO implement here

    }

    *//**
     * @param name
     * @return
     *//*
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

    *//**
     * @param location
     * @return
     *//*
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

    *//**
     * @param specialization
     * @return
     *//*
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

    *//**
     * @return
     *//*
    public ArrayList<Appointment> getAppointmentSchedule() {
        // TODO implement here
        return null;
    }

    *//**
     *
     *//*
    public void removeFromList() {
        // TODO implement here

    }

    *//**
     *
     *//*
    public void save() {
        // TODO implement here

    }

    *//**
     * @return
     *//*
    public String getName() {
        // TODO implement here
        return name;
    }

    *//**
     * @param value
     *
     *//*
    public void setName(String value) {
        // TODO implement here

    }

    *//**
     * @return
     *//*
    public String getPhoneNo() {
        // TODO implement here
        return phoneNo;
    }

    *//**
     * @param value
     *
     *//*
    public void setPhoneNo(String value) {
        // TODO implement here

    }

    *//**
     * @return
     *//*
    public ArrayList<String> getSpeciality() {
        // TODO implement here
        return speciality;
    }

    *//**
     * @param value
     *
     *//*
    public void setSpeciality(ArrayList<String> value) {
        // TODO implement here

    }

    *//**
     * @return
     *//*
    public Address getAddress() {
        // TODO implement here
        return address;
    }

    *//**
     * @param value
     *
     *//*
    public void setAddress(Address value) {
        // TODO implement here

    }

    *//**
     *
     *//*
    public ArrayList<Time> getOfficeHours() {
        // TODO implement here
        return officeHours;
    }

    *//**
     * @param value
     *
     *//*
    //public void setOfficeHours(void value) {
    public void setOfficeHours(ArrayList<Time> value) {
        // TODO implement here

    }

    *//**
     * @return
     *//*
    public ArrayList<Appointment> getAppointmentList() {
        // TODO implement here
        return appointmentList;
    }

    *//**
     * @return
     *//*
    public static ArrayList<Doctor> getDoctorList() {
        // TODO implement here
        return doctorList;
    }

    *//**
     * @param appointment
     *
     *//*
    public void addToAppointmentList(Appointment appointment) {
        // TODO implement here
        appointmentList.add(appointment);
    }

    *//**
     * @param id
     * @return
     *//*
    public static Appointment getObjectByID(Integer id) {
        // TODO implement here
        return null;
    }

    *//**
     * @param appointment
     * @return
     *//*
    public void updateAppointmentList(Appointment appointment) {
        // TODO implement here
        if (appointment.getDoctorUserName().equals(this.getuserName())) {
            observerState.add(appointment);
        }
        //if the caller username is the same as the doctor username on the appointment, then update observerstate

    }
}

*/