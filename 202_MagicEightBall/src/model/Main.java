package model;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import controller.ChatController;
import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
        Author: Schlager Daniela
        Date: 24.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 07.11.2019
 */

public class Main extends Application {

    private Set<Login> logins = new HashSet<>();
    Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        logins.add(new Login("hansi", "hinterseer"));
        logins.add(new Login("andreas", "gabalier"));
        logins.add(new Login("helene", "fischer"));
        logins.add(new Login("alice", "cooper"));

        //FXML Loader erzeugen
        FXMLLoader loader = new FXMLLoader();
        //Pfad zu FXML setzen
        loader.setLocation(getClass().getResource("../view/login.fxml"));
        //Roote node laden
        Parent root = loader.load();
        //Besorge Referenz auf Controller Objekt
        LoginController loginController = loader.getController();

        loginController.setLoginModel(this);

        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    //Aufruf von LoginController
    public void doLogin(Login login) throws WrongCredentialsException, Exception {
        if(logins.contains(login)){
            System.out.println("richtig");

            //FXML Loader erzeugen
            FXMLLoader loader = new FXMLLoader();
            //Pfad zu FXML setzen
            loader.setLocation(getClass().getResource("../view/chat.fxml"));
            //Roote node laden
            Parent root = loader.load();
            //Besorge Referenz auf Controller Objekt
            ChatController chatController = loader.getController();

            //chatController.setChatModel(new MagicEightBallAnswerGenerator());
            chatController.setChatModel(new MagischeMiesmuschelAnswerGenerator());

            primaryStage.setTitle("Chat");
            primaryStage.setScene(new Scene(root));

        }else{
            System.out.println("falsch");
            throw new WrongCredentialsException("Username or password mismatch");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
