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

    private ArrayList<String> administeredTreatments = new ArrayList<String>();
    private ArrayList<String> prescribedMedication = new ArrayList<String>();

    private boolean hasArrived = false;

    public Appointment(Date appointmentDayTime, Patient patient, String reason) {
        this.appointmentDayTime = appointmentDayTime;
        this.patient = patient;
        this.reason = reason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Nurse getAssignedNurse() {
        return assignedNurse;
    }

    public void setAssignedNurse(Nurse assignedNurse) {
        this.assignedNurse = assignedNurse;
    }

    public Doctor getAssignDoctor() {
        return assignedDoc;
    }

    public void setAssignDoctor(Doctor assignedDoc) {
        this.assignedDoc = assignedDoc;
    }

    public Date getAppointmentDate() {
        return appointmentDayTime;
    }

    public void setAppointmentDate(Date date) {
        this.appointmentDayTime = date;
    }

    public boolean hasSignedIn() {
        return hasArrived;
    }

    public void signIn() {
        hasArrived = true;
    }

    public void hasAdminister(String medication) {
        administeredTreatments.add(medication);
    }

    public void assignTreatment(String treatment) {
        recommendedTreatment = treatment;
    }

    public String getRecommendedTreatment() {
        return recommendedTreatment;
    }

    public void addMedication(String medication) {
        prescribedMedication.add(medication);
    }

    public ArrayList<String> getAdministeredTreatments() {
        return administeredTreatments;
    }

    public ArrayList<String> getPrescribedMedication() {
        return prescribedMedication;
    }

}