package application;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * 
 */
@Embeddable
public class Address {

    /**
     * Default constructor
     */
    public Address(String unit, String street, String city, String neighbourhood) {
    	this.unit=unit;
    	this.street=street;
    	this.city=city;
    	this.neighbourhoodLocation=neighbourhood;
    	
    }
    private String neighbourhoodLocation;
    private String unit;
    private String street;
    private String city;
    private String state;
    /**
     * @return
     */
    public String getNeighbourhoodLocation() {
        // TODO implement here
        return "";
    }

    /**
     * @param value 
     * @return
     */
    public void setNeighbourhoodLocation(String value) {
        // TODO implement here

    }

    /**
     * @return
     */
    public String getUnit() {
        // TODO implement here
        return "";
    }

    /**
     * @param value 
     * @return
     */
    public void setUnit(String value) {
        // TODO implement here

    }

    /**
     * @return
     */
    public String getStreet() {
        // TODO implement here
        return "";
    }

    /**
     * @param value 
     * @return
     */
    public void setStreet(String value) {
        // TODO implement here

    }

    /**
     * @return
     */
    public String getCity() {
        // TODO implement here
        return "";
    }

    /**
     * @param value 
     * @return
     */
    public void setCity(String value) {
        // TODO implement here

    }

    /**
     * @return
     */
    public String getState() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setState(String value) {
        // TODO implement here
    }



}