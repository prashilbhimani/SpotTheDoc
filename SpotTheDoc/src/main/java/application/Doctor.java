package application;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Doctor extends User implements Observer{
	    private String name;
	    private String phoneNo;
	    private String speciality;
	    private Status status;
	    //ArrayList<Time> officehours;
	    @Embedded
	    private Address address;
	    @ElementCollection
	    @CollectionTable(name ="doctorAppointmentList")
	    private List<Integer> doctorAppointmentList=new ArrayList<Integer>();
	   	public Doctor(){
	    	setRole(RoleType.Doctor);
	    	this.status=Status.Pending;
	    }  
	    
	    public String toString()
	    {
	    	return name;
	    }
	    public Doctor(String password,String userName,String name, Address address) {
	        //addDoctorDetails(address, specialization, contact, name, officehours);
	    	super(userName,password,RoleType.Doctor);
	    	this.name=name;
	    	this.status=Status.Pending;
	    }

	    
	    
	    
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public void setStatus(Status s){
			this.status=s;
		}
		//public ArrayList<String> getSpeciality() {
		//	return speciality;
		//}
		//public void setSpeciality(ArrayList<String> speciality) {
		//	this.speciality = speciality;
		//}
		
		
		/**
	     * @param appointment
	     * @return
	     */

		@Override
	    public void update(Appointment value) {
	        // TODO implement here
	        if (value.getStatus()==Status.Pending){
	        	this.doctorAppointmentList.add(value.getAppointmentId());
	        }else if (value.getStatus()==Status.Rejected){
	        	this.doctorAppointmentList.remove(value.getAppointmentId());
	        }
	    }
	    
}