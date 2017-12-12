package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepo doctorRepo;
	public String addDoctor(String username,String password, String name, String unit,String street, String city, String neighbourhood) {
		Address a=new Address(unit,  street, city, neighbourhood);
				
		Doctor d= new Doctor(password,username,name, a);
		doctorRepo.save(d);
		return "Done";
	}
	
	public List<Doctor> searchDoctorByName(String name){
		return doctorRepo.findByName(name);
	}
	public List<Doctor> searchDoctorByLocation(String location){
		return doctorRepo.findByAddressNeighbourhoodLocation(location);
	}
	public List<Doctor> searchDoctorBySpeciality(String speciality){
		return doctorRepo.findBySpeciality(speciality);
	}
	public void approveDoctor(String username){
		if(doctorRepo.exists(username)){
			Doctor d=doctorRepo.findOne(username);
			d.setStatus(Status.Approved);
			doctorRepo.save(d);
		}
	}
	public void deleteDoctor(String username){
		if(doctorRepo.exists(username)){
			doctorRepo.delete(doctorRepo.findOne(username));
		}
	}
	
	public List<Doctor> viewAllDoctor(){
		List<Doctor> d = new ArrayList<Doctor>();
		Iterator<Doctor> d1=(Iterator<Doctor>) doctorRepo.findAll();
		while (d1.hasNext())
		    d.add(d1.next());

		return d;
	}
}
