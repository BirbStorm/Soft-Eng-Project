package project;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import project.model.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DoctorController {
    //Admin info
    @FXML private TextField AdminTxtFName, AdminTxtLName, AdminTxtSSN, AdminTxtRoom;
    @FXML private RadioButton AdminDocRB, AdminNurseRB;
    @FXML private ChoiceBox AdminNurseChoice;

    //Receptionist info
    @FXML private TextField recDate, recIssue, recFName, recLName, recSSN;
    @FXML private ChoiceBox recAssignDoc;

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
            roomDAO.addRoom(Integer.parseInt(AdminTxtRoom.getText()), ((Person)AdminNurseChoice.getSelectionModel().getSelectedItem()).getSSN());
        }
        catch (SQLException e){
            System.out.println(("Error while making room" + e));
        }
    }
    @FXML private void btnRemoveRoom(ActionEvent actionEvent) throws  SQLException, ClassNotFoundException{
        try{
            roomDAO.removeRoom(Integer.parseInt(AdminTxtRoom.getText()), ((Person)AdminNurseChoice.getSelectionModel().getSelectedItem()).getSSN());
        }
        catch (SQLException e){
            System.out.println(("Error while making room" + e));
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
            ResultSet rs = nurseDAO.searchNurse();
            updateTable(recTable, rs);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML private void recUpdatePat(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            patientDAO.updateFirstName(recSSN.getText(), recFName.getText());
            patientDAO.updateLastName(recSSN.getText(), recLName.getText());
        } catch (SQLException e){
            System.out.println("Error while updating name" + e);
        }
    }
    @FXML private void recDeletePat(ActionEvent actionEvent) throws  SQLException, ClassNotFoundException{
        try {
            patientDAO.deletePatient(Integer.parseInt(recSSN.getText()));
        } catch (SQLException e){
            System.out.println("Error while removing Patient of of SSN" + e);
        }
    }
    @FXML private void recAddPat(ActionEvent actionEvent) throws  SQLException, ClassNotFoundException{
        try {
            patientDAO.addPatient(Integer.parseInt(recSSN.getText()), recFName.getText(), recLName.getText());
        } catch (SQLException e){
            System.out.println("Error while Adding Patient" + e);
        }
    }
    @FXML private void assignDoc2Pat(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{

    }
    @FXML private void recAddApp(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try {
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(recDate.getText());
            Integer ssn = Integer.parseInt(recTable.getSelectionModel().getSelectedItem().get(0));
            apptDAO.addApp(date, ssn, recIssue.getText());
        } catch (SQLException | ParseException e){
            System.out.println(e);
        }
    }


    //    @FXML protected void tableClick(MouseEvent event) throws SQLException, ClassNotFoundException {
//        String text = table.getColumns().get(0).getText();
//        if(event.getClickCount() > 1 && !((text.equals("Num_Movies") || (text.equals("directorName")|| (text.equals("actorName")))))) {
//            ObservableList<String> row = table.getSelectionModel().getSelectedItem();
//            movieTab(row.get(0).toString());
//            tabPane.getSelectionModel().select(1);
//        }
//    }

    //Doctor Tab
    @FXML private void docTable (ActionEvent actionEvent) throws SQLException, ClassNotFoundException{

    }
}