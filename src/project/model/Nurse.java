package project.model;

import java.util.ArrayList;
/** 
 * A Nurse is assigned a room and only works in that
 * room.  The Nurse can diagnose the Patient and 
 * administer medicine. 
 */
public class Nurse {

    private Person nurse;
    private Appointment appointment;
    private boolean administeredTreatment = false;

    public Nurse(){ }
    public Nurse(Person nurse) {
        this.nurse = nurse;
    }

    /** 
     * @param appointment
     */
    public void getAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void administeredTreatment() {
        this.administeredTreatment = true;
    }

    
    /** 
     * @return Doctor
     */
    public Doctor getDoctor() {
        return appointment.getAssignDoctor();
    }

    
    /** 
     * @return Patient
     */
    public Patient getPatient() {
        return appointment.getPatient();
    }

    
    /** 
     * After reviewing the symptoms and/or other problems
     * the Patient has, the Nurse can make a Diagnosis.
     * @param diagnosis
     */
    public void makeDiagnosis(String diagnosis) {
        appointment.setDiagnosis(diagnosis);
    }

    
    /** 
     * A Nurse can administer medicine to a Patient.  Based
     * on the Diagnosis of the Patient. 
     * 
     * @param medication
     */
    public void administeredTreatment(String medication) {
        appointment.hasAdminister(medication);
    }

    
    /** 
     * Nurse needs to review a Patient's history of prescribed
     * mediction for the Appointment. 
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getPrescriptions() {
        return appointment.getPrescribedMedication();
    }

    
    /** 
     * Nurse needs to review a Patient's history of treatments 
     * for the Appointment.
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getAdministeredTreatments() {
        return appointment.getAdministeredTreatments();
    }

    
    /** 
     * @return boolean
     */
    public boolean hasBeenTreated() {
        return administeredTreatment;
    }

}
