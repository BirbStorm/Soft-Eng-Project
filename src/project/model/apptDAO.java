package project.model;


import project.Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class apptDAO {

    //*******************************
    //SELECT appointments
    //*******************************
    public static ResultSet searchAppointments() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Appointment";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.executeQuery(selectStmt);
            
            //Return employee object
            return rs;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Return ResultSet for specific doctor
    public static ResultSet searchDocAppointments(String doctorSNN) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "Select * FROM APPOINTMENT " +
                "INNER JOIN PATIENT ON PATIENT.SSN = APPOINTMENT.patSSN " +
                "INNER JOIN DOCTOR ON DOCTOR.SSN AND PATIENT.docSSN = " + doctorSNN;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.executeQuery(selectStmt);
            
            //Return employee object
            return rs;
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

    public static void addAppt(Date date, Integer patSSN, String issue) throws SQLException, ClassNotFoundException{
        String add = "INSERT INTO APPOINTMENT (Id, Date, PatientSSN, Issue) VALUES ( null, '" + date + "', " + patSSN + ", '" + issue + "');";
        try {
            DBUtil.dbExecuteUpdate(add);
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void updateAppt(Date date, Integer patSSN, String issue) throws SQLException, ClassNotFoundException{
        String update = "UPDATE APPOINTMENT SET DATE = '" + date + "', Issue = " + issue + "WHERE patSSN = " + patSSN + ";";
        try {
            DBUtil.dbExecuteUpdate(update);
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void deleteAppt(Date date, Integer patSSN, String issue) throws SQLException, ClassNotFoundException{
        String delete = "DELETE FROM APPOINTMENT WHERE PatientSSN = '" + patSSN + "';";
        try {
            DBUtil.dbExecuteUpdate(delete);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    // Select names of prescriptions
    public static ObservableList<String> getPrescriptionList() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT Name FROM PRESCRIPTION";
        //Declare a observable List which comprises of strings
        ObservableList<String> prescriptions = FXCollections.observableArrayList();

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.executeQuery(selectStmt);

            //Fill list
            while (rs.next()) {
                String pres = rs.getString("Name");

                //Add prescription to the ObservableList
                prescriptions.add(pres);
            }
            //return appointments (ObservableList of appointments)
            return prescriptions;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
    public static ResultSet searchPrescriptions() throws SQLException, ClassNotFoundException{
        String selectPrescriptions = "SELECT * FROM PRESCRIPTION";
        try{
            ResultSet pres = DBUtil.executeQuery(selectPrescriptions);
            return pres;
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

}