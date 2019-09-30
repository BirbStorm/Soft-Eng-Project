package project;

import java.util.Date;

public class Receptionist {
    private Person receptionist;
    private Appointment appointment;
    private AppointmentManager am = new AppointmentManager();
    private RoomManager rm = new RoomManager();
    private PatientManager pm = new PatientManager();

    public void makeAppointment(Date appointmentDayTime, Patient patient, String reason) {
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

    public Person getReceptionist() {
        return receptionist;
    }

    public Receptionist(Person receptionist) {
        this.receptionist = receptionist;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void registerPatient(Patient p) {
        pm.addPatient(p);
    }

    public void removePatient(Patient p) {
        pm.removePatient(p);
    }

    public void assignRoom(Doctor d, Nurse n, Patient p) {
        // Room room = new Room(d,n,p,120);
        // rm.addRoom(room);
    }

    public void signIn(Appointment appointment){
        appointment.signIn();
    }
}
