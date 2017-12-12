package SpotTheDoc;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	@RequestMapping(method=RequestMethod.POST , value="/login")
	public RoleType loginRequest(@RequestBody User user) {
		//to do authenticate User		
		System.out.println("login Request:"+user.getPassword()+"  user name"+user.getUserName());
		return user.login();
	}
	
	@RequestMapping(method=RequestMethod.POST,value= "/registerPatient")
	public String registerPatientRequest(@RequestBody Patient patient) {
		//to do authenticate User

		System.out.println(" register user reuqest "+patient.patientList.size());
		return patient.registerPatient();
		
	}

	@RequestMapping(method=RequestMethod.POST,value= "/registerDoctor")
	public String registerDoctorRequest(@RequestBody Doctor doctor) {
		//to do authenticate User
		System.out.println(" register user reuqest "+ doctor.doctorList.size());
		return doctor.registerDoctor();
		
	}

	
	
	@RequestMapping("/test")
	public String testCall() {
		//to do authenticate User
		System.out.println(" register user reuqest ");
		return "Hello";
	}
	
	
}
