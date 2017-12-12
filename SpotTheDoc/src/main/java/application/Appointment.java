package application;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 **
*/
@Entity
public class Appointment implements Subject {
	
    private String doctorUserName;
    private Date startDate;
    private Date endDate;
    private Status status;
    @Id
    private Integer appointmentId;
    @Embedded
    private Record record;
    public String patientUserName;
    @ElementCollection
    @CollectionTable(name ="observersUserName")
    public List<String> observersUserName= new ArrayList<String>();
    @Transient
    public ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public Appointment(){
    	
    }
    public Appointment(int id, String DoctorUserName,String PatientUserName, Date date) {
    	this.appointmentId=id;
        this.setStartDate(date);
        this.setStatus(status.Pending);
        this.setPatientUserName(PatientUserName); //change this constructors arguments to have both doctor and patient username
        this.setDoctorUserName(DoctorUserName);
    }

    public String getDoctorUserName() {
        return doctorUserName;
    }

    /**
     * @param value
     * @return
     */
    public void setDoctorUserName(String value) {
        this.doctorUserName = value;
        //this.attach((Observer) Doctor.getObjectByuserName(this.doctorUserName));
    }

    public String getPatientUserName() {
        // TODO implement here
        return patientUserName;
    }

    /**
     * @param value
     * @return
     */
    public void setPatientUserName(String value) {
        // TODO implement here
        this.patientUserName = value;
        //this.attach((Observer) Patient.getObjectByuserName(this.patientUserName));
    }

    /**
     * @return
     */
    public Date getStartDate() {
        // TODO implement here
        return startDate;
    }

    /**
     * @param value
     * @return
     */
    public void setStartDate(Date value) {
        // TODO implement here
    	//30 mins to be added in end time
        this.startDate = value;
    }

    /**
     * @return
     */
    public Date getEndDate() {
        // TODO implement here
        return endDate;
    }
    
    public Status getStatus() {
        // TODO implement here
        return status;
    }

    /**
     * @param value
     * @return
     */
    public void setStatus(Status value) {
        // TODO implement here
        this.status = value;
        notify(this);
    }

    /**
     * @return
     */
    public Integer getAppointmentId() {
        // TODO implement here
        return appointmentId;
    }

    /**
     * @param value
     * @return
     */
    public void setAppointmentId(Integer value) {
        // TODO implement here
        this.appointmentId = value;
    }

    /**
     * @return
     */
//    public Record getRecord() {
//        // TODO implement here
//        return record;
//    }

    /**
     * @param value
     * @return
     */
//    public void setRecord(Record value) {
//        // TODO implement here
//        record = value;
//    }

    public void attach(Observer o) {
        // TODO implement here
        observers.add(o);
        User u=(User)o;
        observersUserName.add(u.getUserName());
    }

    /**
     * @param o
     * @return
     */
    public void detach(Observer o) {
        int observerIndex = observers.indexOf(o);
        observers.remove(observerIndex);
    }

    /**
     * @param appointment
     * @return
     */
    @Override
    public void notify(Appointment appointment) {
        // TODO implement here
        for (Observer observer : observers) {
            observer.update(appointment);
            //call update appointment list on doctor
        }
    }
}
