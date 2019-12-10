package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/*
        Author: Schlager Daniela
        Date: 28.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 29.11.2019

 */
public class Controller {

    @FXML
    private TextField textFieldTextfeld;

    @FXML
    private ImageView imageViewImage;


    ImageViewBinding ivb;

    public void initialize(){
        imageViewImage.imageProperty().bind(new ImageViewBinding(textFieldTextfeld.textProperty()));


    }
}
