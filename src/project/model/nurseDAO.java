package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.Util.DBUtil;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class nurseDAO {

    //*******************************
    //SELECT an Employee
    //*******************************
    public static Nurse searchNurse (String nSSN) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM NURSE WHERE SSN = "+ nSSN;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.executeQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Nurse nurse = getNursefromRS(rs);

            return nurse;
        } catch (SQLException e) {
            System.out.println("While searching for a Patient with " + nSSN + " id, an error occurred: " + e);
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Nurse getNursefromRS(ResultSet rs) throws SQLException
    {
        Nurse nurse = null;
        if (rs.next()) {
            nurse = new Nurse(new Person(rs.getString("firstName"),
                    rs.getString("lastName"), rs.getInt("SSN")));
        }
        return nurse;
    }

    //*******************************
    //SELECT Patients
    //*******************************
    public static ResultSet searchNurses() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM NURSE";
        try {
            ResultSet rs = DBUtil.executeQuery(selectStmt);
            return rs;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from patient operation
    private static ObservableList<Nurse> getNurseList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of patient objects
        ObservableList<Nurse> nurses = FXCollections.observableArrayList();

        while (rs.next()) {
            Nurse nurse = new Nurse(new Person(rs.getString("firstName"),
                    rs.getString("lastName"), rs.getInt("SSN")));
            //Add patient to the ObservableList
            nurses.add(nurse);
        }
        //return patients (ObservableList of patients)
        return nurses;
    }

    //*************************************
    //UPDATE an patient's Name
    //*************************************
    public static void updateFirstName (String SSN, String name) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt ="UPDATE NURSE\n" + " SET firstName = '" + name + "  WHERE SSN = " + SSN + ";";

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
        String updateStmt ="UPDATE NURSE\n" + " SET lastName = '" + name + "  WHERE SSN = " + SSN + ";";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    //Admin methods
    public static void addNurse (String FName, String LName, String SSN) throws SQLException, ClassNotFoundException{
        String add = "INSERT INTO NURSE (SSN, firstName, lastName) VALUES (" + SSN + ", '" + FName + "', '" + LName + "');";

        try {
            DBUtil.dbExecuteUpdate(add);
        } catch (SQLException e) {
            System.out.print("Error occured while INSERT Operation: " + e);
            throw e;
        }
    }

    public static void removeNurse (String FName, String LName, String SSN) throws SQLException, ClassNotFoundException{
        String remove = "DELETE FROM NURSE WHERE SSN = '" + SSN + "';";

        try {
            DBUtil.dbExecuteUpdate(remove);
        } catch (SQLException e) {
            System.out.print("Error occured while DELETE Operation: " + e);
            throw e;
        }
    }

    public static Integer getNurseId(String nurseName) throws SQLException, ClassNotFoundException{
        String get = "SELECT * FROM NURSE WHERE lastName = '" + nurseName + "';";
        try {
            Integer id = 0;
            ResultSet rs = DBUtil.executeQuery(get);
            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }
}