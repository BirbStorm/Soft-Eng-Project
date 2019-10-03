package project;

import java.util.ArrayList;

public class DoctorManager {

    private ArrayList<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        if (doctors.contains(doctor)) {
            doctors.remove(doctor);
        } else {
            System.out.print("That Doctor does not work here.");
        }
    }

    public Doctor getDoctor(Doctor doctor){
        for (Doctor doc : doctors) {
            if(doc.equals(doctor)){
                return doc;
            }
        }
        return null;
    }

}
