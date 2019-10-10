package project;

import java.util.ArrayList;
/** 
 * A class to keep track of all current Doctors. Is managed
 * by Receptionist who can add and remove Doctors from the
 * list.
 */
public class DoctorManager {

    private ArrayList<Doctor> doctors = new ArrayList<>();

    
    /** 
     * @param doctor
     */
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    
    /** 
     * @param doctor
     */
    public void removeDoctor(Doctor doctor) {
        if (doctors.contains(doctor)) {
            doctors.remove(doctor);
        } else {
            System.out.print("That Doctor does not work here.");
        }
    }

    
    /** 
     * @param doctor
     * @return Doctor
     */
    public Doctor getDoctor(Doctor doctor){
        for (Doctor doc : doctors) {
            if(doc.equals(doctor)){
                return doc;
            }
        }
        return null;
    }

}
