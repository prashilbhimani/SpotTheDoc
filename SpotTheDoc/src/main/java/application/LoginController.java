package application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DoctorRepo doctorRepo;
	@Autowired
	private PatientRepo patientRepo;
	
	@RequestMapping(method=RequestMethod.POST , value="/login")
	public RoleType loginRequest(@RequestParam String username,@RequestParam String password)  {
		return userService.login(username, password);
	}
	
	@RequestMapping(method=RequestMethod.POST,value= "/registerPatient")
	public String registerPatientRequest(@RequestParam String name, @RequestParam String username,@RequestParam String password) {
		if (!userService.checkUserNameExists(username)){
			return patientService.addPatient(username,password,name);
		}
		return "Failed. Username exists";
	}

	@RequestMapping(method=RequestMethod.POST,value= "/registerDoctor")
	public String registerDoctorRequest(@RequestParam String username,@RequestParam String password,@RequestParam String name, @RequestParam String unit, @RequestParam String street, @RequestParam String neighbourhood, @RequestParam String city) {
		if (!userService.checkUserNameExists(username)){
			
			return doctorService.addDoctor(username,password,name,unit,street,city, neighbourhood );
		}
		return "Failed. Username exists";
	}

	
	
	@RequestMapping("/test")
	public String testCall() {
		//to do authenticate User
		System.out.println(" register user reuqest ");
		return "Hello";
	}
	
	
}
