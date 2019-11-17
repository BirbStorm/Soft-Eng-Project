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
     * @return Nurse
     */
    public Nurse getNurse() {
        return appointment.getAssignedNurse();
    }

    
    /** 
     * @return String
     */
    public String getDiagnosis() {
        return appointment.getDiagnosis();
    }

    
    /** 
     * Doctor can presribe medicine to a Patient based
     * on the Patient's diagnosis. 
     * 
     * @param medication
     */
    public void addPrescription(String medication) {
        appointment.addMedication(medication);
    }

    
    /** 
     * Doctor needs to review a Patient's history of prescribed
     * mediction for the Appointment. 
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
