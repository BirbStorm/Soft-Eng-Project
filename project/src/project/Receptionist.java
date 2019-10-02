package project;

import java.util.Date;

public class Receptionist {
    private Person receptionist;
    private Appointment appointment;
    private AppointmentManager am = new AppointmentManager();
    private RoomManager rm = new RoomManager();
    private PatientManager pm = new PatientManager();

    public Receptionist(Person receptionist) {
        this.receptionist = receptionist;
    }

    public Person getReceptionist() {
        return receptionist;
    }

    public void makeAppointment(Date appointmentDayTime, Patient patient, String reason) {
        Appointment temp = new Appointment(appointmentDayTime, patient, reason);
        am.addAppointment(temp);
    }

    public void editAppointment(Appointment appointment, Date appointmentDayTime, Patient patient, String reason, Doctor doctor) {
        Appointment temp = am.getAppointment(appointment);
        temp.setAppointmentDate(appointmentDayTime);
        temp.setPatient(patient);
        temp.setReason(reason);
        temp.setAssignDoctor(doctor);
    }

    public void cancelAppointment(Appointment appointment) {
        am.removeAppointment(appointment);
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = am.getAppointment(appointment);
    }

    public void registerPatient(Patient p) {
        pm.addPatient(p);
    }

    public void removePatient(Patient p) {
        pm.removePatient(p);
    }

    public void assignRoom(Room room){
        this.appointment.setRoom(room);
    }
    
    public void signIn(){
        appointment.signIn();
    }

    public double receipt(){
        return appointment.bill();
    }
}
