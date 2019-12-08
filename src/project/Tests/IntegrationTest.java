package project.Tests;

import org.junit.jupiter.api.Test;
import project.model.*;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    @Test
    void testIntTest() {

        Patient test = new Patient(new Person("John", "Doe", 123456789));
        GregorianCalendar testDate = new GregorianCalendar(2019, 11, 25, 1, 30, 0);
        Person p = new Person("Carson", "Davis", 123456214);
        Person p1 = new Person("Andy", "Russell", 124153);
        Doctor testDoc = new Doctor(p);
        Nurse testNurse = new Nurse(p1);

        Appointment AppointmentT = new Appointment(testDate.getTime(), test, "Stomach Pains");

        testNurse.getAppointment(AppointmentT);
        testDoc.getAppointment(AppointmentT);

        testDoc.makeDiagnosis("Patient has the flu");
        assertEquals(AppointmentT.getDiagnosis(), "Patient has the flu");

        testNurse.makeDiagnosis("Patient has a stomach ulcer");
        assertEquals(AppointmentT.getDiagnosis(), "Patient has a stomach ulcer");

    }

}
