package project;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import project.model.*;
import java.sql.*;
import java.util.*;

public class DoctorController {
    @FXML private TextArea patientName;
    @FXML private TextArea roomNumber;
    @FXML private TextArea patientInfo;
    @FXML private TextArea symptoms;
    @FXML private TextArea diagnosis;
    @FXML private TextArea medicine;
    @FXML private TableView<ObservableList<String>> recTable, docTable, nurseTable, patTable;
    @FXML private TableColumn<ObservableList<String>, String> column;

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

    @FXML
    private void allPatients(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            ResultSet rs = patientDAO.searchPatients();
            updateTable(recTable, rs);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML
    private void allDoctors(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            ResultSet rs = docDAO.searchDoctors();
            updateTable(recTable, rs);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML
    private void allNurses(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            ResultSet rs = nurseDAO.searchNurse();
            updateTable(recTable, rs);
        }catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
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
}