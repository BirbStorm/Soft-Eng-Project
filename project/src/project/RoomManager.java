package project;

import java.util.ArrayList;

public class RoomManager {
    ArrayList<Room> rooms = new ArrayList<>();

    public void addRoom(Room room){
        rooms.add(room);
    }
    public void removeRoom(Room room){
        rooms.remove(room);
    }

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
