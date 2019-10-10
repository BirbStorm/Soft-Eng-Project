package project;

import java.util.ArrayList;
/** 
 * A class to keep track of all current Rooms. Is managed
 * by Receptionist who can add and remove Rooms from the
 * list.
 */
public class RoomManager {
    private ArrayList<Room> rooms = new ArrayList<>();

    
    /** 
     * @param room
     */
    public void addRoom(Room room){
        rooms.add(room);
    }
    
    /** 
     * @param room
     */
    public void removeRoom(Room room){
        rooms.remove(room);
    }

    
    /** 
     * @param room
     * @return int
     */
    public int getRoom(Room room){
        int num = room.getNumber();
        for (int i = 0; i < rooms.size(); i++){
            if(num == rooms.get(i).getNumber()){
                return i;
            }
        }
        return -1;
    }
}
