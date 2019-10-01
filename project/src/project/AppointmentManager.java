package project;

import java.util.ArrayList;

public class AppointmentManager {

    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        if (appointments.contains(appointment)) {
            appointments.remove(appointment);
        } else {
            System.out.print("Appointment not in appointment list.");
        }
    }

}
