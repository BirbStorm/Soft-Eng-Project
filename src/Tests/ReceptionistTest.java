package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.*;

class ReceptionistTest {

    private Person person;
    private Patient p;
    private Doctor d;
    private Nurse n;
    private Room r;
    private Receptionist receptionistUnderTest;

    @BeforeEach
    void setUp() {
        person = new Person("allo", "vera");
        receptionistUnderTest = new Receptionist(person);
        Doctor d = null;
        Nurse n = null;
        Patient p = null;
        Room r = new Room (d,n,22);
    }

    @Test
    void testRegisterPatient() {
        // Run the test
        receptionistUnderTest.registerPatient(p);

        // Verify the results
//        assertTrue();
    }

    @Test
    void testRemovePatient() {
        // Setup

        // Run the test
        receptionistUnderTest.removePatient(p);

        // Verify the results
    }

    @Test
    void testAssignRoom() {
        // Setup

        // Run the test
        //receptionistUnderTest.assignRoom(r);

        // Verify the results

    }
}
