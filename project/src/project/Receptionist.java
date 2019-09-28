package project;

public class Receptionist {
    private Person receptionist;
    private Appointment appointment;
    private AppointmentManager am = new AppointmentManager();
    private RoomManager rm = new RoomManager();
    private PatientManager pm = new PatientManager();

    public Person getReceptionist() {
        return receptionist;
    }

    public Receptionist(Person receptionist) {
        this.receptionist = receptionist;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void registerPatient(Patient p){
        pm.addPatient(p);
    }

    public void removePatient(Patient p){
        pm.removePatient(p);
    }

    public void assignRoom(Doctor d, Nurse n, Patient p){
//        Room room = new Room(d,n,p,120);
//        rm.addRoom(room);
    }
}
