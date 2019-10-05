package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AppointmentTest extends AppointmentManager {

    private Patient mockPatient = new Patient(new Person("John", "doe"), 8675309);
    private Appointment appointmentUnderTest;

    @BeforeEach
    void setUp() {
        appointmentUnderTest = new Appointment(new GregorianCalendar(2017, 1, 1, 0, 0, 0).getTime(), mockPatient, "reason");
    }

    @Test
    void testHasSignedIn() {
        // Setup

        // Run the test
        final boolean result = appointmentUnderTest.hasSignedIn();

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testSignIn() {
        // Setup

        // Run the test
        appointmentUnderTest.signIn();

        // Verify the results
    }

    @Test
    void testHasAdminister() {
        // Setup
        final String medication = "medication";

        // Run the test
        appointmentUnderTest.hasAdminister(medication);

        // Verify the results
    }

    @Test
    void testAssignTreatment() {
        // Setup
        final String treatment = "treatment";

        // Run the test
        appointmentUnderTest.assignTreatment(treatment);

        // Verify the results
    }

    @Test
    void testAddMedication() {
        // Setup
        final String medication = "medication";

        // Run the test
        appointmentUnderTest.addMedication(medication);

        // Verify the results
    }

    @Test
    void testBill() {
        // Setup
        final double expectedResult = 0.0;
        when(mockPatient.isHasInsurance()).thenReturn(false);

        // Run the test
        final double result = appointmentUnderTest.bill();

        // Verify the results
        assertEquals(expectedResult, result, 0.0001);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setDiagnosis() {
    }

    @Test
    void setAppointmentDate() {
    }

    @Test
    void hasSignedIn() {
    }

    @Test
    void signIn() {
    }

    @Test
    void hasAdminister() {
    }

    @Test
    void assignTreatment() {
    }

    @Test
    void addMedication() {
    }

    @Test
    void bill() {
    }
}
