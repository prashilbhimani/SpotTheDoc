package SpotTheDoc;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleAppointmentController {

	@RequestMapping(method=RequestMethod.POST,value= "/scheduleAppointment")
	public String scheduleAppointmentRequest(@RequestBody Appointment appointment) {
		System.out.println("schedule appointment reuqest sent with the parameters");
		return AppointmentController.scheduleAppointment(appointment);
				
		}
	@RequestMapping(method=RequestMethod.POST,value= "/viewAppointment")
	public ArrayList<Appointment> viewAppointmentRequest(@RequestBody Appointment appointment) {
		ArrayList<Appointment> appointmentRequest = new ArrayList<Appointment>();
		System.out.println("View appointment reuqest sent with the parameters");
		 return AppointmentController.viewAppointmentRequests(appointment.getDoctorUserName());		
		}
	
	@RequestMapping(method=RequestMethod.POST,value= "/approveAppointment")
	public String approveAppointmentRequest(@RequestBody Appointment appointment) {
		System.out.println("View appointment reuqest sent with the parameters");
		return AppointmentController.approveAppointment(appointment.getAppointmentId(),appointment.getDoctorUserName());
				
		}
}