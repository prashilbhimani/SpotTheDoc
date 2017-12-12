package application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchController {
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(method=RequestMethod.POST , value="/searchDoctor")
	public List<Doctor> searchDoctor(@RequestParam String name,@RequestParam String speciality,@RequestParam String location)  {
		HashSet<Doctor> set = new HashSet<Doctor>();

		if(name !=null){
			 set.addAll(doctorService.searchDoctorByName(name));
		}
		if(location !=null){
			set.addAll(doctorService.searchDoctorByLocation(location));
		}
		if(speciality !=null){
			set.addAll(doctorService.searchDoctorBySpeciality(speciality));
		}
		return new ArrayList<Doctor>(set);
	}
	
}