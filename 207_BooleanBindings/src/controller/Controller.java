package controller;

import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/*
    Author: Schlager Daniela
    Erstellt am : 29.11.2019
    Class: 4BHIT
    Zuletzt geändert am: 29.11.2019
 */
public class Controller {

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private Button buttonSubmit;

    @FXML
    private CheckBox checkBoxJavaFx;

    @FXML
    private CheckBox checkBoxPerformanceTuning;

    @FXML
    private CheckBox checkBoxJavaSpecialistMasterCourse;

    public void initialize() {
        BooleanBinding nameEntered = textFieldFirstName.textProperty()
                .isNotEmpty()
                .and(textFieldFirstName.textProperty().length().greaterThan(3))
                .and(textFieldLastName.textProperty().isNotEmpty())
                .and(textFieldLastName.textProperty().length().greaterThan(3));
        BooleanBinding courseSelected = checkBoxPerformanceTuning.selectedProperty()
                .or(checkBoxJavaFx.selectedProperty()
                .or(checkBoxJavaSpecialistMasterCourse.selectedProperty()));
        buttonSubmit.disableProperty().bind(courseSelected.and(nameEntered).not());
    }
}
