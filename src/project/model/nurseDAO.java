package project.model;

import project.Util.DBUtil;
import project.model.Nurse;
import project.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    public static ObservableList<Nurse> searchNurse() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM NURSE";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.executeQuery(selectStmt);

            ObservableList<Nurse> nurseList = getNurseList(rs);

            //Return employee object
            return nurseList;
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


}