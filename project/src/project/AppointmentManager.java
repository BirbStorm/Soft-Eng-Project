package project;

import java.util.ArrayList;
    /** 
     * A class to keep track of all current apointments. Is managed
     * by Receptionist who can add and remove appointments from the
     * list.
     */
public class AppointmentManager {
    private ArrayList<Appointment> appointments = new ArrayList<>();

    
    /** 
     * @param appointment
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    
    /** 
     * @param appointment
     */
    public void removeAppointment(Appointment appointment) {
        if (appointments.contains(appointment)) {
            appointments.remove(appointment);
        } else {
            System.out.print("Appointment not in appointment list.");
        }
    }

    
    /** 
     * @param appointment
     * @return Appointment
     */
    public Appointment getAppointment(Appointment appointment){
        for (Appointment a: appointments) {
            if(a.equals(appointment)){
                return a;
            }
        }
        return null;
    }

}
