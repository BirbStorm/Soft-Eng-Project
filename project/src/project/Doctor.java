package project;

import java.util.ArrayList;

public class Doctor extends Nurse{

    private Person doctor;
    private Appointment appointment;

    public Doctor (Person doctor){
        this.doctor = doctor;
    }
    public void getAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Room getRoomNumber() {
        return appointment.getRoom();
    }

    public Nurse getNurse() {
        return appointment.getAssignedNurse();
    }

    public Patient getPatient() {
        return appointment.getPatient();
    }

    public String getDiagnosis() {
        return appointment.getDiagnosis();
    }

    public void addPrescription(String medication) {
        appointment.addMedication(medication);
    }

    public ArrayList<String> getPrescriptions() {
        return appointment.getPrescribedMedication();
    }

    public ArrayList<String> getAdministeredTreatments() {
        return appointment.getAdministeredTreatments();
    }

}
