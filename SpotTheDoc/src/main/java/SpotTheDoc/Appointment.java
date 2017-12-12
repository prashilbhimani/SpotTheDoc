package SpotTheDoc;


import java.sql.Time;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class Appointment implements Subject {
	
	public Appointment(){
		this.setAppointmentId(++randomAppointmentID);
		this.setStatus(status.Pending);
	}

    public Appointment(String DoctorUserName,String PatientUserName, Time time, Date date) {
        this.setDate(date);
        this.setStartTime(time);
        this.setStatus(status.Pending);
        randomAppointmentID = randomAppointmentID + 1;
        this.setAppointmentId(randomAppointmentID);
        this.setPatientUserName(PatientUserName); //change this constructors arguments to have both doctor and patient username
        this.setDoctorUserName(DoctorUserName);
        //this.setEndTime(time);
    }

    /**
     *
     */
    private String doctorUserName;
    private Time startTime;
    private Time endTime;
    private Date date;
    private Status status;
    private Integer appointmentId;
    //private Record record;
    public String patientUserName;
    private static Integer randomAppointmentID = 0;

    @JsonIgnore
    @JsonProperty(value = "observers")
    public ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * @return
     */
    public void save() {
        // TODO implement here

    }

    /**
     * @return
     */
    public String getDoctorUserName() {
        // TODO implement here
        return doctorUserName;
    }

    /**
     * @param value
     * @return
     */
    public void setDoctorUserName(String value) {
        // TODO implement here
        this.doctorUserName = value;
        this.attach((Observer) Doctor.getObjectByuserName(this.doctorUserName));
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
        this.attach((Observer) Patient.getObjectByuserName(this.patientUserName));
    }

    /**
     * @return
     */
    public Time getStartTime() {
        // TODO implement here
        return startTime;
    }

    /**
     * @param value
     * @return
     */
    public void setStartTime(Time value) {
        // TODO implement here
    	//30 mins to be added in end time
        this.startTime = value;
    }

    /**
     * @return
     */
    public Time getEndTime() {
        // TODO implement here
        return endTime;
    }

    /**
     * @param value
     * @return
     */
    public void setEndTime(Time value) {
        // TODO implement here

    }

    /**
     * @return
     */
    public Date getDate() {
        // TODO implement here
        return date;
    }

    /**
     * @param value
     * @return
     */
    public void setDate(Date value) {
        // TODO implement here
        this.date = value;
    }

    /**
     * @return
     */
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
    }

    /**
     * @param o
     * @return
     */
    public void detach(Observer o) {
        // TODO implement here
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
