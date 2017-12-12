package application;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Patient extends User implements Observer {
	

    private String name;
    @ElementCollection
    @CollectionTable(name ="patientAppointmentList")
    private List<Integer> patientAppointmentList=new ArrayList<Integer>();
    
    public Patient(){
    	
    }
    public Patient(String name, String userName, String password) {
    	super(userName,password,RoleType.Patient);
    	this.name=name;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	@Override
    public void update(Appointment value) {
        // TODO implement here
        if (value.getStatus()==Status.Pending){
        	this.patientAppointmentList.add(value.getAppointmentId());
        }else if (value.getStatus()==Status.Rejected){
        	this.patientAppointmentList.remove(value.getAppointmentId());
        }
    }

}
