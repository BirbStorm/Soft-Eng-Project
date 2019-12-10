package project;

import com.mysql.cj.result.SqlDateValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import project.model.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class DoctorController {
    //Admin info
    @FXML private TextField AdminTxtFName, AdminTxtLName, AdminTxtSSN, AdminTxtRoom;
    @FXML private RadioButton AdminDocRB, AdminNurseRB;
    @FXML private ChoiceBox AdminNurseChoice;

    //Receptionist info
    @FXML private TextField recDate, recIssue, recFName, recLName, recSSN;
    @FXML private ChoiceBox recAssignDoc, recRoomBox, recPatCombo;

    //Doctor info
    @FXML private ChoiceBox docPrescriptionChoice, docChoice;
    @FXML private Button docLogin, prescAdd;
    private Doctor currentDoc;

    //Nurse info
    @FXML private ChoiceBox nurseChoice;

    //Patient info
    @FXML private TextField PatTxtFName, PatTxtLName, PatDate, PatIssue;
    @FXML private ChoiceBox patBox;

    //Initialize info
    @FXML private TableView<ObservableList<String>> recTable, docTable, nurseTable, patTable;
    @FXML private TableColumn<ObservableList<String>, String> column;

    //Admin Tab
    @FXML private void AddNurseNDoc(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            if (AdminDocRB.isSelected()){
               docDAO.addDoc(AdminTxtFName.getText(), AdminTxtLName.getText(), Integer.parseInt(AdminTxtSSN.getText()));
            }
            else if(AdminNurseRB.isSelected()){
               nurseDAO.addNurse(AdminTxtFName.getText(), AdminTxtLName.getText(), AdminTxtSSN.getText());
            }
            else;
        }
        catch (SQLException e){
            System.out.println("Error occured while making the doctor or nurse object" + e);
        }
    }
    @FXML private void RemoveNurseNDoc(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            if (AdminDocRB.isSelected()){
                docDAO.removeDoc(AdminTxtFName.getText(), AdminTxtLName.getText(), Integer.parseInt(AdminTxtSSN.getText()));
            }
            else if(AdminNurseRB.isSelected()){
                nurseDAO.removeNurse(AdminTxtFName.getText(), AdminTxtLName.getText(), AdminTxtSSN.getText());
            }
            else;
        }
        catch (SQLException e){
            System.out.println("Error occured while making the doctor or nurse object" + e);
        }
    }
    @FXML private void btnAddRoom(ActionEvent actionEvent) throws  SQLException, ClassNotFoundException{
        try{
            Integer nurseId = nurseDAO.getNurseId(AdminNurseChoice.getSelectionModel().getSelectedItem().toString());
            roomDAO.addRoom(Integer.parseInt(AdminTxtRoom.getText()), nurseId);
            fillRoomChoice();
        } catch (SQLException e){
            System.out.println("Error while making room" + e);
        }
    }
    @FXML private void btnRemoveRoom(ActionEvent actionEvent) throws  SQLException, ClassNotFoundException{
        try{
            Integer roomNum = null;
            String nurse = null;
            if (AdminTxtRoom.getText()!= null){
                roomNum = Integer.parseInt(AdminTxtRoom.getText());
            }
            if (AdminNurseChoice.getSelectionModel().getSelectedItem().toString() != null){
                nurse = AdminNurseChoice.getSelectionModel().getSelectedItem().toString();
            }
            roomDAO.removeRoom(roomNum, nurse);
            fillRoomChoice();
        } catch (SQLException e){
            System.out.println("Error while making room" + e);
        }
    }

    //Receptionist Tab
    @FXML private void updateTable(TableView<ObservableList<String>> table, ResultSet rs)throws SQLException {
        table.getColumns().clear();
        table.getItems().clear();
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
            final int j = i;
            column = new TableColumn<>(rs.getMetaData().getColumnName(i + 1));
            column.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(j)));
            table.getColumns().add(column);
        }
        while (rs.next()) {
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                //Iterate Column
                row.add(rs.getString(i));
            }
            data.add(row);
        }
        table.setItems(data);
    }
    @FXML private void allPatients(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            ResultSet rs = patientDAO.searchPatients();
            updateTable(recTable, rs);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void allDoctors(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            ResultSet rs = docDAO.searchDoctors();
            updateTable(recTable, rs);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void allNurses(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            ResultSet rs = nurseDAO.searchNurses();
            updateTable(recTable, rs);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void recUpdatePat(ActionEvent actionEvent) throws ClassNotFoundException {
        try {
            patientDAO.updateFirstName(recSSN.getText(), recFName.getText());
            patientDAO.updateLastName(recSSN.getText(), recLName.getText());
        } catch (SQLException e){
            System.out.println("Error while updating name" + e);
        }
    }
    @FXML private void recDeletePat(ActionEvent actionEvent) throws  ClassNotFoundException{
        try {
            patientDAO.deletePatient(Integer.parseInt(recSSN.getText()));
        } catch (SQLException e){
            System.out.println("Error while removing Patient of of SSN" + e);
        }
    }
    @FXML private void recAddPat(ActionEvent actionEvent) throws  ClassNotFoundException{
        try {
            patientDAO.addPatient(Integer.parseInt(recSSN.getText()), recFName.getText(), recLName.getText());
        } catch (SQLException e){
            System.out.println("Error while Adding Patient" + e);
        }
    }
    @FXML private void assignDoc2Pat(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            String docName = recAssignDoc.getSelectionModel().getSelectedItem().toString();
            String patName = recPatCombo.getSelectionModel().getSelectedItem().toString();

            Integer docSSN = docDAO.getDocSSN(docName);
            Integer patSSN = patientDAO.getPatientSSN(patName);
            patientDAO.assignDoc2Pat(docSSN, patSSN);
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    @FXML private void recAddAppt(ActionEvent actionEvent) throws ClassNotFoundException{
        try{
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(recDate.getText());
            Integer ssn = Integer.parseInt(recTable.getSelectionModel().getSelectedItem().get(0));
            apptDAO.addAppt(date, ssn, recIssue.getText());
        } catch (SQLException | ParseException e){
            System.out.println(e);
        }
    }
    @FXML private void recUpdateAppt(ActionEvent actionEvent) throws ClassNotFoundException{
        try{
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(recDate.getText());
            Integer ssn = Integer.parseInt(recTable.getSelectionModel().getSelectedItem().get(0));
            apptDAO.updateAppt(date, ssn, recIssue.getText());
        } catch (SQLException | ParseException e){
            System.out.println(e);
        }
    }
    @FXML private void recDeleteAppt(ActionEvent actionEvent) throws ClassNotFoundException{
        try{
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(recDate.getText());
            String ssn = (recTable.getSelectionModel().getSelectedItem().get(0));
            apptDAO.deleteAppt(ssn);
        } catch (SQLException | ParseException e){
            System.out.println(e);
        }
    }

    //Doctor Tab
    @FXML private void docUpdateTable() throws SQLException, ClassNotFoundException{
        try{
            ResultSet rs = apptDAO.searchDocAppointments(Integer.toString(currentDoc.getPerson().getSSN()));
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void docLogin(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            currentDoc = docDAO.searchDoctorName((String)docChoice.getValue());
            docUpdateTable();
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    //Nurse Tab
    @FXML private void nurseLogin (ActionEvent actionEvent) throws SQLException, ClassNotFoundException{

    }
    //Patient Tab
    @FXML private void patLogin(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            String LName = patBox.getSelectionModel().getSelectedItem().toString();
            ResultSet rs = apptDAO.searchAppts(LName);
            updateTable(patTable, rs);
            String ssn = patientDAO.getPatientSSN(LName).toString();
            String FName = patientDAO.getFName(Integer.parseInt(ssn)).toString();
            PatTxtFName.setText(FName);
            PatTxtLName.setText(LName);
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML private void patUpdatePat(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            String LName = patBox.getSelectionModel().getSelectedItem().toString();
            String ssn = patientDAO.getPatientSSN(LName).toString();
            String FName = patientDAO.getFName(Integer.parseInt(ssn));
            patientDAO.updateFirstName(ssn, FName);
            patientDAO.updateLastName(ssn, LName);
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML private void patUpdateAppt(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, ParseException {
        try{
            String LName = patBox.getSelectionModel().getSelectedItem().toString();
            Integer ssn = Integer.parseInt(patientDAO.getPatientSSN(LName).toString());
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(PatDate.getText());
            apptDAO.updateAppt(date, ssn, PatIssue.getText());
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML private void patDeleteAppt(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            String LName = patBox.getSelectionModel().getSelectedItem().toString();
            String ssn = patientDAO.getPatientSSN(LName).toString();
            String FName = patientDAO.getFName(Integer.parseInt(ssn));
            apptDAO.deleteAppt(ssn);
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }

    //Initialize each choiceBox
    @FXML private void fillDoctorChoice() throws SQLException, ClassNotFoundException{
        ArrayList<String> names = new ArrayList<String>();
        try{
            ResultSet rs = docDAO.searchDoctors();
            while (rs.next()) { 
                names.add(rs.getString("lastName"));
            }
            ObservableList<String> docNames = FXCollections.observableArrayList(names);
            docChoice.setItems(docNames);
            recAssignDoc.setItems(docNames);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void fillPrescriptionChoice() throws SQLException, ClassNotFoundException{
        ArrayList<String> names = new ArrayList<String>();
        try{
            ResultSet rs = apptDAO.searchPrescriptions();
            while (rs.next()) {
                names.add(rs.getString("Name"));
            }
            ObservableList<String> prescriptionList = FXCollections.observableArrayList(names);
            docPrescriptionChoice.setItems(prescriptionList);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void fillNurseChoice() throws SQLException, ClassNotFoundException{
        ArrayList<String> names = new ArrayList<String>();
        try{
            ResultSet rs = nurseDAO.searchNurses();
            while (rs.next()) {
                names.add(rs.getString("lastName"));
            }
            ObservableList<String> nurseNames = FXCollections.observableArrayList(names);
            AdminNurseChoice.setItems(nurseNames);
            nurseChoice.setItems(nurseNames);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void fillRoomChoice() throws SQLException, ClassNotFoundException{
        ArrayList<String> roomNames = new ArrayList<String>();
        try{
            ResultSet rs = roomDAO.searchRooms();
            while (rs.next()) {
                roomNames.add(rs.getString("roomID"));
            }
            ObservableList<String> rooms = FXCollections.observableArrayList(roomNames);
            recRoomBox.setItems(rooms);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void fillPatChoice() throws SQLException, ClassNotFoundException{
        ArrayList<String> patNames = new ArrayList<>();
        try {
            ResultSet rs = patientDAO.searchPatients();
            while (rs.next()){
                patNames.add(rs.getString("lastName"));
            }
            ObservableList<String> patients = FXCollections.observableArrayList(patNames);
            recPatCombo.setItems(patients);
            patBox.setItems(patients);
        } catch (SQLException e){
            System.out.println(e);
            throw e;
        }
    }
    @FXML private void initialize() throws SQLException, ClassNotFoundException {
        try{
            fillDoctorChoice();
//            fillPrescriptionChoice();
            fillNurseChoice();
            fillRoomChoice();
            fillPatChoice();
        }catch (SQLException | ClassNotFoundException e){
            throw e;
        }
    }

}