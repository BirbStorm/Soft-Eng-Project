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

<<<<<<< HEAD
<<<<<<< HEAD
    public void assignRoom(Room room){
        this.appointment.setRoom(room);
=======
    public void assignRoom(Doctor d, Nurse n, Patient p) {
        // Room room = new Room(d,n,p,120);
        // rm.addRoom(room);
=======
    public void assignRoom(Room room){
        this.appointment.setRoom(room);
>>>>>>> ada72dfee5ebc52044fc721553acece6557a1f8b
    }
    
    public void signIn(){
        appointment.signIn();
<<<<<<< HEAD
>>>>>>> a007be122f8254e3051102326aa4fb337a60d45c
=======
    }

    public double receipt(){
        return appointment.bill();
>>>>>>> ada72dfee5ebc52044fc721553acece6557a1f8b
    }
}
