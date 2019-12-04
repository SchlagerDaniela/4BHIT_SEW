package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {

    @FXML
    private Label labelSayHello;

    @FXML
    private Button buttonSayHello;

    @FXML
    private RadioButton RadioButtonGer;

    @FXML
    private ToggleGroup GroupLang;

    @FXML
    private RadioButton RadioButtonEngl;

    @FXML
    void sayHello(ActionEvent event) {
        if (RadioButtonEngl.isSelected()) {
            labelSayHello.setText("Hello World!");
        }
        if (RadioButtonGer.isSelected()) {
            labelSayHello.setText(("Hallo Welt!"));
        }
    }
}

