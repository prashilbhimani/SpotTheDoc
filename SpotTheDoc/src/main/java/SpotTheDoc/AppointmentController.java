package SpotTheDoc;


import java.sql.Time;
import java.util.*;

/**
 *
 */
public class AppointmentController {

	/**
	 * Default constructor
	 */
	public static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	

	/**
	 * @param appointmentID
	 * @param userName
	 * @return
	 */
	public static String approveAppointment(Integer appointmentID, String userName) {
		// TODO implement here
		Doctor d = Doctor.getObjectByuserName(userName);
		Appointment appointmentDetails=null;
		for (Appointment appointment : d.pendingAppointments) {
			if (appointmentID == appointment.getAppointmentId()) {
				appointmentDetails = appointment;				
			}
		}
		if(appointmentDetails!=null){
			d.pendingAppointments.remove(appointmentDetails);
			d.addToAppointmentList(appointmentDetails);
			appointmentDetails.setStatus(Status.Approved);
		}
		return "status set to approved for appointment id " +appointmentID;
	}

	/**
	 * @param appointmentID
	 * @param userName
	 * @return
	 */

	public void rejectAppointment(Integer appointmentID, String userName) {
		// TODO implement here
		Doctor d = Doctor.getObjectByuserName(userName);
		for (Appointment appointment : d.pendingAppointments) {
			if (Objects.equals(appointmentID, appointment.getAppointmentId())) {
				int appointmentIndex = d.pendingAppointments.indexOf(appointment);
				d.pendingAppointments.remove(appointmentIndex);
				appointment.setStatus(Status.Rejected);
			}
		}
	}

	/**
	 * @param userName
	 * @return
	 */
	public ArrayList<Appointment> viewAppointmentSchedule(String userName) {
		// TODO implement here
		Doctor d = Doctor.getObjectByuserName(userName);
		return d.getAppointmentList();
	}

	/**
	 * @param userName
	 * @return
	 */
	public static ArrayList<Appointment>  viewAppointmentRequests(String userName) {
		// TODO implement here
		Doctor d = Doctor.getObjectByuserName(userName);
		return d.pendingAppointments;
	}

	/**
	 * @param t
	 * @return
	 */
	public void selectTimeSlot(Time t) {
		// TODO implement here

	}

	public static String scheduleAppointment(Appointment appointment){
		appointmentList.add(appointment);
		Doctor doctor = Doctor.getObjectByuserName(appointment.getDoctorUserName());
		doctor.pendingAppointments.add(appointment);
		return "Appointment Created successfully - waiting for doctor approval.";
	}    

}
