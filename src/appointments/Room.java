package appointments;
/**
 * A class to keep track of Rooms.  Rooms have
 * numbers to identify them and Nurses are assigned
 * to specific Rooms.
 */
public class Room {
    public Nurse nurse;
    private int number;

    /**
     * @param doctor
     * @param nurse
     * @param number
     * @return
     */
    public Room(Doctor doctor, Nurse nurse, int number) {
        this.nurse = nurse;
        this.number = number;
    }


    /**
     * @return Nurse
     */
    public Nurse getNurse() {
        return nurse;
    }


    /**
     * @param nurse
     */
    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }


    /**
     * @return int
     */
    public int getNumber() {
        return number;
    }
}
