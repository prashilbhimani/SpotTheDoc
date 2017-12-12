
import java.sql.Time;
import java.util.*;

/**
 *
 */
public class AppointmentController {

    /**
     * Default constructor
     */
    public AppointmentController() {
    }
    
    public static ArrayList<Appointment> appointmentList;
    //public ArrayList <Appointment> subjectState;

    /**
     * @param appointmentID
     * @param userName
     * @return
     */
    public void approveAppointment(Integer appointmentID, String userName) {
        // TODO implement here
        Doctor d = Doctor.getObjectByuserName(userName);
        for (Appointment appointment : d.pendingAppointments) {
            if (Objects.equals(appointmentID, appointment.getAppointmentId())) {
                int appointmentIndex = d.pendingAppointments.indexOf(appointment);
                d.pendingAppointments.remove(appointmentIndex);
                d.addToAppointmentList(appointment);
                appointment.setStatus(Status.Approved);
            }
        }
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
    public ArrayList<Appointment> viewAppointmentRequests(String userName) {
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

    /**
     * @param userName
     * @param time
     * @param date
     * @return
     */
    public void createAppointment(String userName, Time time, Date date) {
        // TODO implement here
        Appointment a = new Appointment(userName, time, date);
        appointmentList.add(a);
        
    }

    /**
     * @param o
     * @return
     */
    

}
