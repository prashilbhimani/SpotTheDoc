package application;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class Controller {
	@Autowired
	private DoctorRepo doctorRepo;
	@Autowired
	private PatientRepo patientRepo;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;
	
	
	@RequestMapping(method=RequestMethod.POST , value="/approveDoctor")
	public void approveDoctorByUserName(@RequestParam String username)  {
		doctorService.approveDoctor(username);
	}
	@RequestMapping(method=RequestMethod.POST , value="/deleteDoctor")
	public void deleteDoctorByUserName(@RequestParam String username)  {
		doctorService.deleteDoctor(username);
	}
	@RequestMapping(method=RequestMethod.POST , value="/viewDoctor")
	public List<Doctor> viewAllDoctor(@RequestParam String username)  {
		return doctorService.viewAllDoctor();
	}
}
