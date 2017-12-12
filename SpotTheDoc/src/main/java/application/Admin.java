package application;

import java.util.*;

import javax.persistence.Entity;

/**
 * 
 */
@Entity
public class Admin extends User {
    private Admin() {
    }

    private static Admin admin;
    public void approveDoctor(Doctor doctor) {
        // TODO implement here

    }
    public void deleteDoctor(Doctor doctor) {
    		
    }


    public static Admin getInstance() {
        // TODO implement here
        if(admin == null){
            admin = new Admin();
        }
        return admin;
    }

}