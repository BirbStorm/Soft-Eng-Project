package appointments;

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
    private ArrayList<String> allPrescriptions = new ArrayList<>();
    private ArrayList<String> allTreatments = new ArrayList<>();

    private boolean hasInsurance;

    
    /** 
     * @param p
     * @return
     */
    public Patient(Person p) {
        this.p = p;
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
     * @return String
     */
    public String getFirstName() {
        return p.firstName;
    }

    
    /** 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.p.firstName = firstName;
    }

    
    /** 
     * @return String
     */
    public String getLastName() {
        return p.lastName;
    }

    
    /** 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.p.lastName = lastName;
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

    public int getSSN() {
        return p.getSSN();
    }
}
