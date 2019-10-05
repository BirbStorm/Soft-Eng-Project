package project;

import java.util.Date;
import java.util.ArrayList;

public class Patient {
    private AppointmentManager am;
    public Appointment appointment;
    private Person p;
    private int SSN;
    private ArrayList<String> allPrescriptions = new ArrayList<>();
    private ArrayList<String> allTreatments = new ArrayList<>();

    private boolean hasInsurance;

    public Patient(Person p, int SSN) {
        this.p = p;
        this.SSN = SSN;
    }

    public void createAppointment(Date appointmentDayTime, Patient patient, String reason) {
        Appointment temp = new Appointment(appointmentDayTime, patient, reason);
        am.addAppointment(temp);
    }

    public void editAppointment(Appointment appointment, Date appointmentDayTime, String reason) {
        Appointment temp = am.getAppointment(appointment);
        temp.setAppointmentDate(appointmentDayTime);
        temp.setReason(reason);
    }

    public void cancelAppointment(Appointment appointment) {
        am.removeAppointment(appointment);
    }

    public String getFirstName() {
        return p.firstName;
    }

    public void setFirstName(String firstName) {
        this.p.firstName = firstName;
    }

    public String getLastName() {
        return p.lastName;
    }

    public void setLastName(String lastName) {
        this.p.lastName = lastName;
    }

    public int getSSN() {
        return SSN;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public void updatePrescriptions() {
        allPrescriptions.addAll(appointment.getPrescribedMedication());
    }

    public void updateTreatments() {
        allTreatments.addAll(appointment.getAdministeredTreatments());
    }

    public void payReceipt(Appointment a){
        a.receipt = 0;
    }
}
