package application;
import java.sql.Time;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepo appointmentRepo;
	@Autowired
	private DoctorRepo doctorRepo;
	@Autowired
	private PatientRepo patientRepo;
	
	public String approveAppointment(Integer appointmentID, String userName) {
		// TODO implement here
		if(appointmentRepo.exists(appointmentID)){
			Appointment a=appointmentRepo.findOne(appointmentID);
			if (a.getDoctorUserName().equals(userName)){
				a.setStatus(Status.Approved);
				appointmentRepo.save(a);
				return "status set to approved for appointment id " +appointmentID;
			}
			return "Unauthorized Change";
		}
		
		return "No appointment found";
	}


	
	public String scheduleAppointment(String doctorUserName,String patientUserName,Date d){
		if(patientRepo.exists(patientUserName) && doctorRepo.exists(doctorUserName)){
			int id=(int)appointmentRepo.count();
			Appointment a=new Appointment (id,doctorUserName,patientUserName,d);

			if(appointmentRepo.findByStartDate(d).isEmpty()){
				Patient p=patientRepo.findOne(patientUserName);
				a.attach(p);
				Doctor d1=doctorRepo.findOne(doctorUserName);
				a.attach(d1);
				a.setStatus(Status.Pending);
				patientRepo.save(p);
				doctorRepo.save(d1);
				appointmentRepo.save(a);
				
				return "Appointment Created successfully - waiting for doctor approval.";
			}
			return "Please choose another time slot";
			
		}
		return "Patient or Doctor does not exist";
		
	}
	public void buildObserverList(Appointment a){
		for(String u: a.observersUserName){
			if(patientRepo.exists(u)){
				a.attach((Observer)patientRepo.findOne(u));
			}
			if(doctorRepo.exists(u)){
				a.attach((Observer)doctorRepo.findOne(u));
			}
		}
	}
	public Appointment getAppointmentObject(Integer id){
		Appointment a=appointmentRepo.findOne(id);
		buildObserverList(a);
		return a;
	}

}
