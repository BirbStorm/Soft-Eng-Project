package project;

import java.util.ArrayList;

public class Doctor extends Nurse{

    private Person doctor;
    private Appointment appointment;

    
    /** 
     * @param doctor
     * @return 
     */
    public Doctor(Person doctor) {
        this.doctor = doctor;
    }

    /**
     * @param appointment
     */
    public void getAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    public void makeDiagnosis(String diagnosis) {
        appointment.setDiagnosis(diagnosis);
    }
    
    /** 
     * @return Room
     */
    public Room getRoomNumber() {
        return appointment.getRoom();
    }

    
    /** 
     * @return Nurse
     */
    public Nurse getNurse() {
        return appointment.getAssignedNurse();
    }

    
    /** 
     * @return Patient
     */
    public Patient getPatient() {
        return appointment.getPatient();
    }

    
    /** 
     * @return String
     */
    public String getDiagnosis() {
        return appointment.getDiagnosis();
    }

    
    /** 
     * Doctor can prescribe medicine to a Patient based
     * on the Patient's diagnosis. 
     * 
     * @param medication
     */
    public void addPrescription(String medication) {
        appointment.addMedication(medication);
    }

    
    /** 
     * Doctor needs to review a Patient's history of prescribed
     * medication for the Appointment.
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getPrescriptions() {
        return appointment.getPrescribedMedication();
    }

    
    /** 
     * Doctor needs to review a Patient's history of treatments 
     * for the Appointment. 
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getAdministeredTreatments() {
        return appointment.getAdministeredTreatments();
    }

}
