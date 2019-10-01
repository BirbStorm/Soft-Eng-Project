package project;

public class Room {
    public Nurse nurse;
    private int number;



    public Room(Doctor doctor, Nurse nurse, int number) {
        this.nurse = nurse;
        this.number = number;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public int getNumber() {
        return number;
    }
}
