package application;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class ScheduleAppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	
	@RequestMapping(method=RequestMethod.POST,value= "/scheduleAppointment")
	public String scheduleAppointmentRequest(@RequestParam String patientUserName,@RequestParam String doctorUserName,@RequestParam int year,@RequestParam int month,@RequestParam int day,@RequestParam int hours,@RequestParam int min) {
		if(hours>8 && hours<18 && (min==0 || min ==30)){
			Date d=new Date(year-1900,month-1,day,hours,min);
			return appointmentService.scheduleAppointment(doctorUserName, patientUserName, d);
			
		}
		return "Enter timing between 9 and 17 rounded off to nearest half hours";
				
	}
	@RequestMapping(method=RequestMethod.POST,value= "/viewAppointment")
	public List<Appointment> viewAppointmentRequest(@RequestParam String doctorUserName) {
		 return appointmentRepo.findByDoctorUserName(doctorUserName);		
		}
	
	@RequestMapping(method=RequestMethod.POST,value= "/approveAppointment")
	public String approveAppointmentRequest(@RequestParam String doctorUserName, @RequestParam int appointmentId) {
		return appointmentService.approveAppointment(appointmentId, doctorUserName);
				
	}
	
}