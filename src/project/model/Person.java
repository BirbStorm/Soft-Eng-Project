package project.model;
/** 
 * A class to define what a Person is.  Doctor, Nurse,
 * Patient, and Receptionist are Persons.
 */
public class Person {
    public String firstName, lastName;
    public int SSN;

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    /**
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    
    /** 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /** 
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    
    /** 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    /** 
     * @param firstName
     * @param lastName
     * @return 
     */
    public Person(String firstName, String lastName, int SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
