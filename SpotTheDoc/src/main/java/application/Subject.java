package application;
public interface Subject {


    /**
     * @param o 
     * @return
     */
    public void attach(Observer o);

    /**
     * @param o 
     * @return
     */
    public void detach(Observer o);

    /**
     * @param appointment 
     * @return
     */
    public void notify(Appointment appointment);

}