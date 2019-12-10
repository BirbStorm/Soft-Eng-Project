package project.model;

import javafx.collections.ObservableList;
import project.Util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class roomDAO {
    public static void addRoom(int roomID, int nurseSSN) throws SQLException, ClassNotFoundException {
        String add = "INSERT INTO ROOM (roomId, nurseSSN) VALUES (" + roomID + ", " + nurseSSN + ");";

        try {
            DBUtil.dbExecuteUpdate(add);
        }catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error occured while INSERT Operation: " + e);
            throw e;
        }
    }

    public static void removeRoom(int roomID, String nurse) throws SQLException, ClassNotFoundException {
        String remove = "DELETE FROM ROOM WHERE roomId = '" + roomID + "' OR nurseSSN = (SELECT SSN FROM NURSE WHERE lastName = '" + nurse + "');";

        try {
            DBUtil.dbExecuteUpdate(remove);
        }catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error occured while REMOVE Operation: " + e);
            throw e;
        }
    }

    public static ResultSet searchRooms() throws SQLException, ClassNotFoundException{
        String selectRooms = "SELECT * FROM ROOM";

        try{
            ResultSet rs = DBUtil.executeQuery(selectRooms);
            return rs;
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
}
