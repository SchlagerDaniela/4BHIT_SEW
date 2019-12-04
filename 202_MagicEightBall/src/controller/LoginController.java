package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Login;
import model.Main;
import model.WrongCredentialsException;

import java.io.IOException;

/*
        Author: Schlager Daniela
        Date: 24.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 25.10.2019

 */

public class LoginController {

    @FXML
    private TextField textFieldUsername;

    @FXML
    private PasswordField passwordFieldPassword;

    //Referenz auf LoginModel
    private Main loginModel;

    public void setLoginModel(Main loginModel) {
        this.loginModel = loginModel;
    }

    @FXML
    void doLogin(ActionEvent event) {
        //auslesen Username + Passwort => schicke an LoginModel
        try {
            loginModel.doLogin(new Login(textFieldUsername.getText(), passwordFieldPassword.getText()));
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING, "Wrong username or password");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING, "Cannot load application. Goodbye!");
            alert.showAndWait();
            Platform.exit();
        } finally {
            textFieldUsername.clear();
            passwordFieldPassword.clear();
        }
    }

}
