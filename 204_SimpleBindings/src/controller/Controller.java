package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.MyBean;

/*
    Author: Schlager Daniela
    Erstellt am : 22.11.2019
    Class: 4BHIT
    Zuletzt geändert am: 27.11.2019
 */

public class Controller {

    @FXML
    private Label labelText;

    @FXML
    private TextField TextfieldTextfield;

    MyBean mb = new MyBean();

    @FXML
    public void initialize(){

        labelText.textProperty().bind(mb.sampleProperty());
        mb.sampleProperty().bind(TextfieldTextfield.textProperty()) ;

    }
}

