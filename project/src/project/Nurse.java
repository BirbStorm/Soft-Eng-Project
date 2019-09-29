package project;

public class Nurse {

    private Person nurse;
    private Appointment appointment;
    private boolean administeredTreatment = false;

    public void getAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void administeredTreatment() {
        administeredTreatment = true;
    }

    public Doctor getDoctor() {
        return appointment.assignedDoc;
    }

    public Patient getPatient() {
        return appointment.patient;
    }

    public void makeDiagnosis(String diagnosis) {
        appointment.diagnosis = diagnosis;
    }

}
