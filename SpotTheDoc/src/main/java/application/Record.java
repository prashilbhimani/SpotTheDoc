package application;
import java.util.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * 
 */
@Embeddable 
public class Record {

    /**
     * Default constructor
     */
    public Record() {
    }
    private ArrayList<String> prescription;
    private String comments;

    /**
     * @return
     */
    public ArrayList<String> getPrescription() {
        // TODO implement here
        return null;
    }

    /**
     * @param value 
     * @return
     */
    public void appendPrescription(ArrayList<String> prescription) {
        // TODO implement here

    }

    /**
     * @return
     */
    public String getComments() {
        // TODO implement here
        return "";
    }

    /**
     * @param value 
     * @return
     */
    public void setComments(String value) {
        // TODO implement here

    }

}