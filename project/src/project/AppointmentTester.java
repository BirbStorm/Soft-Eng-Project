package project;
import org.junit.*;
import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

class AppointmentTester {
    @Test
    void test_bill(){
        double expected_receipt = 60.0;
        Date d = new Date();
        Person p = new Person("firstName", "lastName");
        int SSN = 22222;
        Patient pat = new Patient(p, SSN);
        String reason = "coughing";
        Appointment a = new Appointment(d, pat, reason);
        double receipt = a.bill();
        assertEquals(expected_receipt, receipt);
    }

}