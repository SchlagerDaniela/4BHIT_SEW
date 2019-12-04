package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Entry;
import model.PasswordSafeModel;


/*
        Author: Schlager Daniela
        Date: 15.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 27.11.2019

 */
public class PasswordSafeController {

    Entry entry;
    PasswordSafeModel psm;
    private int condition = 1;

    @FXML
    private Button buttonFirstEntry;

    @FXML
    private Button buttonLastEntry;

    @FXML
    private Button buttonPreviousEntry;

    @FXML
    private Button buttonNextEntry;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonSave;

    @FXML
    private TextField textFieldWebsite;

    @FXML
    private TextField textFieldLink;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private MenuButton menuButtonMenu;

    @FXML
    private MenuItem menuItemNew;

    @FXML
    private MenuItem menuItemEdit;

    @FXML
    private MenuItem menuItemDelete;

    @FXML
    private Button buttonShowPassword;

    @FXML
    private Label labelPassword;

    //Diese Methode wird immer aufgerufen wenn bei alle Felder der Inhalt gelöscht werden soll
    public void clearAll(){
        textFieldWebsite.clear();
        textFieldUsername.clear();
        textFieldPassword.clear();
        textFieldLink.clear();
    }

    //Wenn man auf den nextButton drückt wird der nächste Eintrag angezeigt
    @FXML
    void showNextEntry(ActionEvent event) {
        clearAll();
        entry = psm.getNext();
        textFieldWebsite.appendText(entry.getWebsite());
        textFieldUsername.appendText(entry.getUsername());
        textFieldPassword.appendText(entry.getPassword());
        textFieldLink.appendText(entry.getLink());
    }

    //Wenn man auf den prevButton drückt, wird der vorherige Eintrag angezeigt
    @FXML
    void showPreviousEntry(ActionEvent event) {
        clearAll();
        entry = psm.getPrev();
        textFieldWebsite.appendText(entry.getWebsite());
        textFieldUsername.appendText(entry.getUsername());
        textFieldPassword.appendText(entry.getPassword());
        textFieldLink.appendText(entry.getLink());
    }

    //Das Programm wird geschlossen
    public void ExitProgram(ActionEvent event) {
        System.exit(0);
    }

    //Wenn man auf Save drückt, wird der gesamte Inhalt gespeichert
    @FXML
    void doSave(ActionEvent event) {
        psm.editEntry(textFieldWebsite.getText(), textFieldUsername.getText(), textFieldPassword.getText(), textFieldLink.getText(), condition);
        setEditable(false);
    }

    //Eintrag wird gelöscht
    @FXML
    void deleteEntry(ActionEvent event) {
        psm.deleteEntry();
        showNextEntry(event);
    }

    //Neuen Eintrag erstellen
    @FXML
    void newEntry(ActionEvent event) {
        clearAll();
        if(!textFieldUsername.isEditable()){
            setEditable(true);
            condition = 0;
        }
    }


    public void setEditable(boolean condition){
        textFieldWebsite.setEditable(condition);
        textFieldUsername.setEditable(condition);
        textFieldPassword.setEditable(condition);
        textFieldLink.setEditable(condition);
    }

    //Die textFelder werden auf Editierbar gesetzt wenn sie nicht bereits editierbar sind
    @FXML
    void editEntry(ActionEvent event) {
        if(!textFieldUsername.isEditable()){
            setEditable(true);
            condition = 2;
        }
    }

    public void setPasswordSafeController(PasswordSafeModel psm) {
        this.psm = psm;
    }

}


