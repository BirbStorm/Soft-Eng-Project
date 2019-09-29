package project;

import java.util.Date;

public class Patient {
    private AppointmentManager am;
    private Appointment appointment;
    private String firstName, lastName;
    private int SSN;

    private boolean hasInsurance;

    public Patient(String firstName, String lastName, int SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }

    public void createAppointment(Date appointmentDayTime, Patient patient, String reason) {
        Appointment temp = new Appointment(appointmentDayTime, patient, reason);
    }

    public void editAppointment(Appointment appointment, Date appointmentDayTime, Patient patient, String reason) {
        appointment.setAppointmentDate(appointmentDayTime);
        appointment.setPatient(patient);
        appointment.setReason(reason);
    }

    public void cancelAppointment(Appointment appointment) {
        am.removeAppointment(appointment);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
