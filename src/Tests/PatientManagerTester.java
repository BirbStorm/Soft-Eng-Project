package Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import appointments.Patient;
import appointments.PatientManager;
import appointments.Person;

public class PatientManagerTester{
    @Test
    @DisplayName("addPatient return correct when adding patients")
    void addPatientTest(){
        PatientManager pm = new PatientManager();
        int SSN = 999999292;
        Person p = new Person("Andy", "Russel", SSN);
        Patient pat = new Patient(p);
        //assertTrue(pm.addPatient(pat));
    }
    @Test
    @DisplayName("addPatient return correct when adding a duplicate")
    void addPatientTestforDup(){
        PatientManager pm = new PatientManager();
        int SSN = 999292;
        Person p = new Person("Sean", "Northcutt", SSN);
        Patient pat = new Patient(p);

        int SSN2 = 95499292;
        Person p2 = new Person("Carson", "Davis", SSN2);
        Patient pat2 = new Patient(p2);

        //assertFalse(pm.addPatient(pat2));
    }
}