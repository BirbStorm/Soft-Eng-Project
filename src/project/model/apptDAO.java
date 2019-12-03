package project.model;

import project.Util.DBUtil;
import project.model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class apptDAO {

    //*******************************
    //SELECT appointments
    //*******************************
    public static ObservableList<Appointment> searchappointments () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Appointment";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.executeQuery(selectStmt);

            ObservableList<Appointment> apptList = getAppointmentList(rs);

            //Return employee object
            return apptList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from Appointment operation
    private static ObservableList<Appointment> getAppointmentList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Appointment objects
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();

        while (rs.next()) {
            //TODO: FIGURE THIS OUT
//            Appointment appt = new Appointment(new Person(rs.getString("firstName"),
//                    rs.getString("lastName"), rs.getInt("SSN")));
            //Add Appointment to the ObservableList
//            appointments.add(appt);
        }
        //return appointments (ObservableList of appointments)
        return appointments;
    }
    
}