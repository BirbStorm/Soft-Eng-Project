package project;

import java.util.Date;

public class DoctorTester{

    void addPrescription_test(){
        Date date = new Date();
        Person p = new Person("Johnnie", "Oldfield");
        int SSN = 222;
        Patient pat = new Patient(p, SSN);
        Appointment a = new Appointment(date, pat, "Cancer");
        
        Person d = new Person("Sean", "Northcutt");
        Doctor doc = new Doctor(d);
        assertTrue(Doctor.addPrescription("Steroids"));
    }
    
}