package project;

import java.util.Date;
import java.util.ArrayList;

public class Appointment {

    private Date appointmentDayTime;
    private Doctor assignedDoc;
    private Nurse assignedNurse;
    private Patient patient;
    private String reason;
    private Room room;
    private String diagnosis;
    private String recommendedTreatment;

    private ArrayList<String> administeredTreatments = new ArrayList<>();
    private ArrayList<String> prescribedMedication = new ArrayList<>();

    private boolean hasArrived = false;
    public double receipt;

    
    /** 
     * Constructor
     * 
     * @param appointmentDayTime
     * @param patient
     * @param reason
     * @return 
     */
    public Appointment(Date appointmentDayTime, Patient patient, String reason) {
        this.appointmentDayTime = appointmentDayTime;
        this.patient = patient;
        this.reason = reason;
        receipt = 80;
    }

    
    /** 
     * @return String
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    
    /** 
     * A Nurse can register a Diagnosis to an Apponitment.
     * The Diagnosis identifies the nature of an illness or
     * problem the Patient is having. A Doctor can review
     * and edit the Diagnosis. 
     * 
     * @param diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    
    /** 
     * @return Room
     */
    public Room getRoom() {
        return room;
    }

    
    /** 
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    
    /** 
     * @return String
     */
    public String getReason() {
        return reason;
    }

    
    /** 
     * A Patient specifies the purpose of creating
     * an Appointment. 
     * 
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    
    /** 
     * @return Patient
     */
    public Patient getPatient() {
        return patient;
    }

    
    /** 
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    
    /** 
     * @return Nurse
     */
    public Nurse getAssignedNurse() {
        return assignedNurse;
    }

    
    /** 
     * @param assignedNurse
     */
    public void setAssignedNurse(Nurse assignedNurse) {
        this.assignedNurse = assignedNurse;
    }

    
    /** 
     * @return Doctor
     */
    public Doctor getAssignDoctor() {
        return assignedDoc;
    }

    
    /** 
     * @param assignedDoc
     */
    public void setAssignDoctor(Doctor assignedDoc) {
        this.assignedDoc = assignedDoc;
    }

    
    /** 
     * @return Date
     */
    public Date getAppointmentDate() {
        return appointmentDayTime;
    }

    
    /** 
     * @param date
     */
    public void setAppointmentDate(Date date) {
        this.appointmentDayTime = date;
    }

    
    /** 
     * @return boolean
     */
    public boolean hasSignedIn() {
        return hasArrived;
    }

    /** 
     * A Patient has 'signed in' when a Receptionist
     * confrims the Patient has shown up for thier
     * Appointment.
     */
    public void signIn() {
        hasArrived = true;
    }

    
    /** 
     * 
     * 
     * @param medication
     */
    public void hasAdminister(String medication) {
        administeredTreatments.add(medication);
    }

    
    /** 
     * @param treatment
     */
    public void assignTreatment(String treatment) {
        recommendedTreatment = treatment;
    }

    
    /** 
     * @return String
     */
    public String getRecommendedTreatment() {
        return recommendedTreatment;
    }

    
    /** 
     * @param medication
     */
    public void addMedication(String medication) {
        prescribedMedication.add(medication);
    }

    
    /** 
     * A Doctor can review a list of past treatments a 
     * Patient has received.
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getAdministeredTreatments() {
        return administeredTreatments;
    }

    
    /** 
     * A Doctor can review a list of past medication a 
     * Patient has been prescribed.
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getPrescribedMedication() {
        return prescribedMedication;
    }

    
    /** 
     * HARD CODED
     * Keeps track of the amount a Patient owes for an
     * Appointment.
     * 
     * @return double
     */
    public double bill(){
        for (String medicine: getPrescribedMedication()){
            receipt += 20;
        }
        for (String treatments: getAdministeredTreatments()){
            receipt += 40;
        }
        if(patient.isHasInsurance()){
            return receipt * .5;
        }
        return receipt;
    }
}