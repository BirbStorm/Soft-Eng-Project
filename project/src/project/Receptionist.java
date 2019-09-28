package project;

public class Receptionist {
    Person receptionist;
    Appointment appointment;
    AppointmentManager am = new AppointmentManager();
    PatientManager pm = new PatientManager();

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
}
