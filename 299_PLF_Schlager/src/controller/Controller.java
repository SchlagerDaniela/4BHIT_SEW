package controller;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.MyService;

import java.io.File;

public class Controller {

    @FXML
    private Button buttonChoose;

    @FXML
    private TextField textfieldFilename;

    @FXML
    private ProgressBar progressbar;

    @FXML
    private Label labelProzent;

    @FXML
    private Label labelMessage;

    @FXML
    private Button buttonGenerate;


    @FXML
    private Spinner<Integer> lengthSpinner;

    private FileChooser fileChooser;
    File otpFile;
    private MyService service;

    @FXML
    public void initialize() {

        MyService service = new MyService();
        lengthSpinner.setEditable(true);
        lengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(100, 10000));

        progressbar.progressProperty().bind(service.progressProperty());
        labelMessage.textProperty().bind(service.messageProperty());
        //buttonGenerate.disableProperty().bind(textfieldKeylength.textProperty().isEmpty().or(textfieldFilename.textProperty().isEmpty()));
        buttonGenerate.disableProperty().bind(textfieldFilename.textProperty().isEmpty());
    }


    @FXML
    void onChoose(ActionEvent event) {
        // generate FileChooser Dialog
        fileChooser = new FileChooser();

        // get current Stage from an GUI Element - in this case use the TextField "fileNameTextField"
        Stage stage = (Stage) textfieldFilename.getScene().getWindow();

        // Title for FileChooser Dialog
        fileChooser.setTitle("Save OTP Key");
        // set Filter for Files
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        // show the FileChooser Dialog and get the chosen File as "File-Object"
        otpFile = fileChooser.showSaveDialog(stage);

        // sets the Textfield with the
        textfieldFilename.setText(otpFile.getName());
    }

    @FXML
    void onGenerate(ActionEvent event) {
        MyService service = new MyService(otpFile,lengthSpinner.getValue());

        if (service.getState() == Worker.State.READY)
            service.start();
        else
            service.restart();
    }

}
