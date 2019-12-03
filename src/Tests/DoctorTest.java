package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import appointments.*;

import java.util.Date;

class DoctorTest extends Nurse {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdministeredTreatment() {
    }

    @Test
    void testMakeDiagnosis() {
    }



    @Test
    void addPrescription() {
        Date date = new Date();
        int SSN = 222;
        Person p = new Person("Johnnie", "Oldfield", SSN);
        Patient pat = new Patient(p);
        Appointment a = new Appointment(date, pat, "Cancer");

        Person d = new Person("Sean", "Northcutt", 12356789);
        Doctor doc = new Doctor(d);
        //assertTrue(doc.addPrescription("test"));
    }

}