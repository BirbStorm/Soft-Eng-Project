package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import static org.mockito.MockitoAnnotations.initMocks;

class ReceptionistTest {

//    @Mock
    private Person mockReceptionist;

    private Receptionist receptionistUnderTest;

    @BeforeEach
    void setUp() {
//        initMocks(this);
        receptionistUnderTest = new Receptionist(mockReceptionist);
    }

    @Test
    void testRegisterPatient() {
        // Setup
        final Patient p = null;

        // Run the test
        receptionistUnderTest.registerPatient(p);

        // Verify the results
    }

    @Test
    void testRemovePatient() {
        // Setup
        final Patient p = null;

        // Run the test
        receptionistUnderTest.removePatient(p);

        // Verify the results
    }

    @Test
    void testAssignRoom() {
        // Setup
        final Doctor d = null;
        final Nurse n = null;
        final Patient p = null;

        // Run the test
        //receptionistUnderTest.assignRoom(d, n, p);

        // Verify the results
    }
}
