package model;
import controller.LoginController;
import controller.PasswordSafeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashSet;
import java.util.Set;

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
            loader.setLocation(getClass().getResource("../view/PasswordSafe.fxml"));
            //Roote node laden
            Parent root = loader.load();

            PasswordSafeController passwordSafeController = loader.getController();
            passwordSafeController.setPasswordSafeController(new PasswordSafeModel());

            primaryStage.setTitle("PasswordSafe");
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
