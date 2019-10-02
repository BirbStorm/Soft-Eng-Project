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
        am.addAppointment(temp);
    }

    public void editAppointment(Appointment appointment, Date appointmentDayTime, Patient patient, String reason, Doctor doctor) {
        appointment.setAppointmentDate(appointmentDayTime);
        appointment.setPatient(patient);
        appointment.setReason(reason);
        appointment.setAssignDoctor(doctor);
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

    public void assignRoom(Room room){
        this.appointment.setRoom(room);
    }
    
    public void signIn(){
        appointment.signIn();
    }
}
