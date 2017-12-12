package application;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends CrudRepository<Appointment,Integer> {
	public List<Appointment> findByDoctorUserName(String username);
	public List<Appointment> findByDoctorUserNameInAndStatusIn(String username, Status s);
	public List<Appointment> findByStartDate(Date d);
}
