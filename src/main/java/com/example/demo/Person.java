package com.example.demo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Arrays;

public class Person {

    private SimpleStringProperty classroom;
    private SimpleStringProperty name;
    private SimpleStringProperty grades;
    private SimpleDoubleProperty avg;




    public Person(String classroom, String name, String[] grades, double avg)  {
        this.classroom = new SimpleStringProperty(classroom);
        this.name = new SimpleStringProperty(name);
        this.grades = new SimpleStringProperty(Arrays.toString(grades));
        this.avg = new SimpleDoubleProperty(avg);
    }

    public String getClassroom() {
        return classroom.get();
    }

    public void setClassroom(String classroom) {
        this.classroom.set(classroom);
    }

    public String getName() {
        return name.get();
    }


    public SimpleStringProperty classroomProperty() {
        return classroom;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty gradesProperty() {
        return grades;
    }

    public double getAvg() {
        return avg.get();
    }

    public SimpleDoubleProperty avgProperty() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg.set(avg);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGrades() {
        return grades.get();
    }

    public void setGrades(String grades) {
        this.grades.set(grades);
    }

    @Override
    public String toString() {
        return "class: " + classroom.get() + " - " + "name: " + name.get()+ "grade: "+ grades.get();
    }

}