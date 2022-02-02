package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppMainController implements Initializable {

    @FXML
    private TableView<Person> tvData;
    @FXML
    private TableColumn colClass;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colGrades;



    @FXML
    private TableColumn colFinalGrade;

    private ObservableList<Person> tvObservableList = FXCollections.observableArrayList();

    @FXML
    void onOpenDialog(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPersonDialog.fxml"));
        Parent parent = fxmlLoader.load();
        AddPersonDialogController dialogController = fxmlLoader.<AddPersonDialogController>getController();
        dialogController.setAppMainObservableList(tvObservableList);

        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {


        colClass.setCellValueFactory(new PropertyValueFactory<>("classroom"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGrades.setCellValueFactory(new PropertyValueFactory<>("grades"));
       colFinalGrade.setCellValueFactory(new PropertyValueFactory<>("avg"));

        tvData.setItems(tvObservableList);
        tvData.setEditable(true);
        colName.setEditable(true);
     colName.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    @FXML
    void deleteRowFromTable(ActionEvent event) {

        ObservableList<Person> allLocations;
        allLocations = tvData.getItems();
        allLocations .forEach(allLocations::remove);
       // tvData.setItems(tvObservableList).remo(tvData.getSelectionModel().getSelectedItem());
    }
    @FXML
    public void onEditChange(TableColumn.CellEditEvent<Person, String> personStringCellEditEvent) {

        Person person = tvData.getSelectionModel().getSelectedItem();
        person.setName(personStringCellEditEvent.getNewValue());
    }
}