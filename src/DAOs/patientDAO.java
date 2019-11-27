package DAOs;

import Util.DBUtil;
import appointments.Patient;
import appointments.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class patientDAO {

    //*******************************
    //SELECT an Employee
    //*******************************
    public static Patient searchPatient (String pSSN) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM PATIENT WHERE SSN = "+pSSN;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.executeQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Patient patient = getPatientFromRS(rsEmp);

            return patient;
        } catch (SQLException e) {
            System.out.println("While searching for a Patient with " + pSSN + " id, an error occurred: " + e);
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Patient getPatientFromRS(ResultSet rs) throws SQLException
    {
        Patient pat = null;
        if (rs.next()) {
            pat = new Patient(new Person(rs.getString("firstName"),
                                         rs.getString("lastName"), rs.getInt("SSN")));
        }
        return pat;
    }

    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<Patient> searchPatients () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM PATIENT";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.executeQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Patient> patList = getPatientList(rs);

            //Return employee object
            return patList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Patient> getPatientList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Patient> patients = FXCollections.observableArrayList();

        while (rs.next()) {
            Patient pat = new Patient(new Person(rs.getString("firstName"),
                    rs.getString("lastName"), rs.getInt("SSN")));
            //Add employee to the ObservableList
            patients.add(pat);
        }
        //return patients (ObservableList of Employees)
        return patients;
    }

    //*************************************
    //UPDATE an employee's email address
    //*************************************
    public static void updateEmpEmail (String empId, String empEmail) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE employees\n" +
                        "      SET EMAIL = '" + empEmail + "'\n" +
                        "    WHERE EMPLOYEE_ID = " + empId + ";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //DELETE an employee
    //*************************************
    public static void deletePat (String empId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM employees\n" +
                        "         WHERE employee_id ="+ empId +";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }


}