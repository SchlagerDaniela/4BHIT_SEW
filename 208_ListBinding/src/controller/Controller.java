package controller;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/*
    Author: Schlager Daniela
    Erstellt am : 29.11.2019
    Class: 4BHIT
    Zuletzt geändert am: 29.11.2019
 */
public class Controller {
    @FXML
    private Button buttonClickMe;

    @FXML
    private ListView listViewList;

    private List<String> iphones = new ArrayList<>();
    private List<String> otherPhones = new ArrayList<>();
    private ListProperty<String> listProperty = new SimpleListProperty<>();

    Boolean clicked = false;
    @FXML
    public void handleButtonAction(ActionEvent event) {
        if(clicked){
            listProperty.set(FXCollections.observableArrayList(iphones));
            clicked = false;
        }else if(!clicked){
            listProperty.set(FXCollections.observableArrayList(otherPhones));
            clicked = true;
        }
    }

    public void initialize() {
        iphones.add("iPhone4");
        iphones.add("iPhone5");
        iphones.add("iPhone6");
        iphones.add("iPhone7");
        iphones.add("iPhone8");

        otherPhones.add("Xiaomi");
        otherPhones.add("Huawei");
        otherPhones.add("One Plus");
        otherPhones.add("Motorola");
        otherPhones.add("Samsung");
        otherPhones.add("LG");

        listViewList.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(iphones));

    }
}
