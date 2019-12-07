package project.model;

import project.Util.DBUtil;

import java.sql.SQLException;

public class roomDAO {
    public static void addRoom(int roomID, int nurseSSN) throws SQLException, ClassNotFoundException {
        String add = "INSERT INTO ROOM (roomID, nurseSSN) VALUES (" + roomID + ", " + nurseSSN + ");";

        try {
            DBUtil.dbExecuteUpdate(add);
        }catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error occured while INSERT Operation: " + e);
            throw e;
        }
    }
}
