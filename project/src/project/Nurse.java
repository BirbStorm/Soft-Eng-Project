package project;

import java.util.ArrayList;

public class Nurse {

    private Person nurse;
    private Appointment appointment;
    private boolean administeredTreatment = false;

    public void getAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void administeredTreatment() {
        this.administeredTreatment = true;
    }

    public Doctor getDoctor() {
        return appointment.getAssignDoctor();
    }

    public Patient getPatient() {
        return appointment.getPatient();
    }

    public void makeDiagnosis(String diagnosis) {
        appointment.setDiagnosis(diagnosis);
    }

    public void administeredTreatment(String medication) {
        appointment.hasAdminister(medication);
    }

    public ArrayList<String> getPrescriptions() {
        return appointment.getPrescribedMedication();
    }

    public ArrayList<String> getAdministeredTreatments() {
        return appointment.getAdministedTreatments();
    }

    public boolean hasBeenTreated() {
        return administeredTreatment;
    }

}
