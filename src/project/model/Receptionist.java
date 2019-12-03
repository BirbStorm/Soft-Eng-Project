package project.model;

import java.util.Date;

/**
 * A Receptionist oversees all Manager classes to
 * maintain information pertaining to Appointments.
 * A Recptionoist assigns most parameters to an
 * Appointment.  A Patient has to go through the
 * Receptionist to create the Appointment.
 */
public class Receptionist {
    private Person receptionist;
    private Appointment appointment;
    private AppointmentManager am = new AppointmentManager();
    private RoomManager rm = new RoomManager();
    private PatientManager pm = new PatientManager();


    /**
     * @param receptionist
     * @return
     */


    /**
     * @return Person
     */


    /**
     * @param appointmentDayTime
     * @param patient
     * @param reason
     */
    public void makeAppointment(Date appointmentDayTime, Patient patient, String reason) {
        Appointment temp = new Appointment(appointmentDayTime, patient, reason);
        am.addAppointment(temp);
    }


    /**
     * @param appointment
     * @param appointmentDayTime
     * @param patient
     * @param reason
     * @param doctor
     */
    public void editAppointment(Appointment appointment, Date appointmentDayTime, Patient patient, String reason, Doctor doctor) {
        Appointment temp = am.getAppointment(appointment);
        temp.setAppointmentDate(appointmentDayTime);
        temp.setPatient(patient);
        temp.setReason(reason);
        temp.setAssignDoctor(doctor);
    }


    /**
     * @param appointment
     */
    public void cancelAppointment(Appointment appointment) {
        am.removeAppointment(appointment);
    }

    public Person getReceptionist() {
        return receptionist;
    }

    public Receptionist(Person receptionist) {
        this.receptionist = receptionist;
    }

    public void getAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    /**
     * @param appointment
     */
    public void setAppointment(Appointment appointment) {
        this.appointment = am.getAppointment(appointment);
    }


    /**
     * A Patient has to go thorugh a Receptionist to create an
     * Appointment.
     *
     * @param p
     */
    public void registerPatient(Patient p) {
        pm.addPatient(p);
    }


    /**
     * @param p
     */
    public void removePatient(Patient p) {
        pm.removePatient(p);
    }


    /**
     * @param room
     */
    public void assignRoom(Room room) {
        this.appointment.setRoom(room);
    }

    /**
     * When a Patient arrives at appointment the
     * Receptionist can count them as signed in.
     */
    public void signIn() {
        appointment.signIn();
    }


    /**
     * @return double
     */
    public double receipt() {
        return appointment.bill();
    }
}
