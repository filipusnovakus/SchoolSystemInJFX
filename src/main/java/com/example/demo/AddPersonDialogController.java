package com.example.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Locale;

public class AddPersonDialogController  {

    @FXML
    private TextField tfClass;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfGrades;

    private ObservableList<Person> appMainObservableList;

    @FXML
    void btnAddPersonClicked(ActionEvent event) {
        System.out.println("btnAddPersonClicked");
        String classroom = tfClass.getText().trim().toUpperCase(Locale.ROOT);
        String name = tfName.getText().trim();
        String[] grades = tfGrades.getText().trim().split(" ");

        int[] totalGrade = new int[grades.length];
        for(int i = 0;i < grades.length;i++)
        {

          totalGrade[i] = Integer.parseInt(grades[i]);
        }
        int sum = 0;
        for (int j = 0; j < totalGrade.length; j++) {
            sum += totalGrade[j];
        }

      double avg = sum / totalGrade.length;

        Person data = new Person(classroom, name, grades, avg);
        appMainObservableList.add(data);

        closeStage(event);
    }

    public void setAppMainObservableList(ObservableList<Person> tvObservableList) {
        this.appMainObservableList = tvObservableList;

    }

    private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

}