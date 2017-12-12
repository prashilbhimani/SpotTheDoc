package application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor, String>{
	public List<Doctor> findByName(String name);
	public List<Doctor> findBySpeciality(String speciality);
	public List<Doctor> findByAddressNeighbourhoodLocation(String location);
}
