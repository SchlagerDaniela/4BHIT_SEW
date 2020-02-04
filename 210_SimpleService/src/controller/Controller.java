package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.MyService;
import model.MyTask;

public class Controller {

    @FXML
    private Button button;

    private MyService service = new MyService(100);

    @FXML
    public void initialize() {
        button.setText("Restart Counting");
        button.opacityProperty().bind(service.progressProperty());
        button.scaleXProperty().bind(service.progressProperty());
        button.scaleYProperty().bind(service.progressProperty());
        button.textProperty().bind(service.messageProperty());

        service.start();
    }

    @FXML
    void handleButton(ActionEvent event) {
        service.reset();
        service.start();
    }
}
