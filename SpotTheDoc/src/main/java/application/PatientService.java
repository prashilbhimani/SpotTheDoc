package application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	@Autowired
	private PatientRepo patientRepo;
	public String addPatient(String username,String password, String name) {
		Patient p= new Patient(name,username,password);
		patientRepo.save(p);
		return "Done";
	}
	
}
