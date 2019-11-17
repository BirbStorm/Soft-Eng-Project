package project;

import java.util.Date;
import java.util.ArrayList;
/** 
 * A Patient is a client who requires an Appoinment to see a Doctor.
 * Patient must make an Appontment through the Receptionist.  Has a
 * list of past treatments and prescribed medicine. Can cancel the
 * Appointment.
 */
public class Patient {
    private AppointmentManager am = new AppointmentManager();
    public Appointment appointment = null;
    private Person p;
    private int SSN;
    private ArrayList<String> allPrescriptions = new ArrayList<>();
    private ArrayList<String> allTreatments = new ArrayList<>();

    private boolean hasInsurance;

    
    /** 
     * @param p
     * @param SSN
     * @return 
     */
    public Patient(Person p, int SSN) {
        this.p = p;
        this.SSN = SSN;
    }

    
    /** 
     * @param appointmentDayTime
     * @param patient
     * @param reason
     */
    public void createAppointment(Date appointmentDayTime, Patient patient, String reason) {
        Appointment temp = new Appointment(appointmentDayTime, patient, reason);
        am.addAppointment(temp);
        appointment = temp;
    }

    
    /** 
     * @param appointment
     * @param appointmentDayTime
     * @param reason
     */
    public void editAppointment(Appointment appointment, Date appointmentDayTime, String reason) {
        Appointment temp = am.getAppointment(appointment);
        temp.setAppointmentDate(appointmentDayTime);
        temp.setReason(reason);
    }

    
    /** 
     * @param appointment
     */
    public void cancelAppointment(Appointment appointment) {
        am.removeAppointment(appointment);
    }


    
    /** 
     * @return int
     */
    public int getSSN() {
        return SSN;
    }

    
    /** 
     * @return boolean
     */
    public boolean isHasInsurance() {
        return hasInsurance;
    }

    
    /** 
     * @param hasInsurance
     */
    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public void updatePrescriptions() {
        allPrescriptions.addAll(appointment.getPrescribedMedication());
    }

    public void updateTreatments() {
        allTreatments.addAll(appointment.getAdministeredTreatments());
    }

    
    /** 
     * @param a
     */
    public void payReceipt(Appointment a){
        a.receipt = 0;
    }
}
