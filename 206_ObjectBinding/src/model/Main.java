package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
        Author: Schlager Daniela
        Date: 28.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 29.11.2019

 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("..//view/sample.fxml"));
        primaryStage.setTitle("206_ObjectBindings");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
