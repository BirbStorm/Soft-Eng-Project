package project;

public class Doctor {

    private Person doctor;
    private Appointment appointment;

    public void getAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setPrescription() {
    }

    public Room getRoomNumber() {
        return appointment.getRoom();
    }

    public Nurse getNurse() {
        return appointment.getAssignedNurse();
    }

    public Patient getPatient() {
        return appointment.getPatient();
    }
}
