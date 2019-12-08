package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.Util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class docDAO {

    //*******************************
    //SELECT an Employee
    //*******************************
    public static Doctor searchDoctor (String dSSN) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Doctor WHERE SSN = "+dSSN;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.executeQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Doctor Doctor = getDoctorFromRS(rsEmp);

            return Doctor;
        } catch (SQLException e) {
            System.out.println("While searching for a Doctor with " + dSSN + " id, an error occurred: " + e);
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Doctor getDoctorFromRS(ResultSet rs) throws SQLException
    {
        Doctor doc = null;
        if (rs.next()) {
            doc = new Doctor(new Person(rs.getString("firstName"),
                    rs.getString("lastName"), rs.getInt("SSN")));
        }
        return doc;
    }

    //*******************************
    //SELECT Doctors
    //*******************************
    public static ResultSet searchDoctors () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM DOCTOR";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.executeQuery(selectStmt);

//            ObservableList<Doctor> docList = getDoctorList(rs);

            //Return employee object
            return rs;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from Doctor operation
    private static ObservableList<Doctor> getDoctorList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Doctor objects
        ObservableList<Doctor> Doctors = FXCollections.observableArrayList();

        while (rs.next()) {
            Doctor doc = new Doctor(new Person(rs.getString("firstName"),
                    rs.getString("lastName"), rs.getInt("SSN")));
            //Add Doctor to the ObservableList
            Doctors.add(doc);
        }
        //return Doctors (ObservableList of Doctors)
        return Doctors;
    }

    //*************************************
    //UPDATE an Doctor's Name
    //*************************************
    public static void updateFirstName (String SSN, String name) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt ="UPDATE Doctor\n" + " SET firstName = '" + name + "  WHERE SSN = " + SSN + ";";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    public static void updateLastName (String SSN, String name) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt ="UPDATE Doctor\n" + " SET lastName = '" + name + "  WHERE SSN = " + SSN + ";";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    //Admin methods

    public static void addDoc (String FName, String LName, int SSN) throws SQLException, ClassNotFoundException{
        String add = "INSERT INTO DOCTOR (SSN, firstName, lastName) VALUES (" + SSN + ", '" + FName + "', '" + LName + "');";

        try {
            DBUtil.dbExecuteUpdate(add);
        } catch (SQLException e) {
            System.out.print("Error occured while INSERT Operation: " + e);
            throw e;
        }
    }

    public static void removeDoc (String FName, String LName, int SSN) throws SQLException, ClassNotFoundException{
        String remove = "DELETE FROM DOCTOR WHERE SSN = '" + SSN + "';";

        try {
            DBUtil.dbExecuteUpdate(remove);
        } catch (SQLException e) {
            System.out.print("Error occured while INSERT Operation: " + e);
            throw e;
        }
    }



}