package project;

import java.util.ArrayList;

public class PatientManager {
    private ArrayList<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public int getPatient(Patient patient){
        int SSN = patient.getSSN();
        for (int i = 0; i < patients.size(); i++){
            if(SSN == patients.get(i).getSSN()){
                return i;
            }
        }
        return 0;
    }

    public void removePatient(Patient p){
        patients.remove(p);
    }
}
