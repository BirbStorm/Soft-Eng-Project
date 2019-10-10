package project;

import java.util.ArrayList;
/** 
 * A class to keep track of all current Patients. Is managed
 * by Receptionist who can add and remove Patients from the
 * list.
 */
public class PatientManager {
    private ArrayList<Patient> patients = new ArrayList<>();

    
    /** 
     * @param patient
     */
    public void addPatient(Patient patient){
        patients.add(patient);
    }

    
    /** 
     * @param patient
     * @return int
     */
    public int getPatient(Patient patient){
        int SSN = patient.getSSN();
        for (int i = 0; i < patients.size(); i++){
            if(SSN == patients.get(i).getSSN()){
                return i;
            }
        }
        return -1;
    }

    
    /** 
     * @param p
     */
    public void removePatient(Patient p){
        patients.remove(p);
    }
}
