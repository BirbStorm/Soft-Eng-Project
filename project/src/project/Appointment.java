package project;

import java.util.Date;

public class Appointment {

    private Date appointmentDayTime;
    private Doctor assignedDoc;
    private Nurse assignedNurse;
    private Patient patient;
    private String reason;
    private Room room;
    private String diagnosis;

    public Appointment makeAppointment() {
        return null;
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

}