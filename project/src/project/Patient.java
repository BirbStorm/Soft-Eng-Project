package project;

public class Patient {
    private Appointment appointment;
    private Person p;
    private int SSN;



    private boolean hasInsurance;

    public Patient(Person p, int SSN) {
        this.p = p;
        this.SSN = SSN;
    }

    public int getSSN() {
        return SSN;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}
