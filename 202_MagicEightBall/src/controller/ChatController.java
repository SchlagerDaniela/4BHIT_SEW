package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.AnswerGenerator;
import model.MagicEightBallAnswerGenerator;
import model.Main;

/*
        Author: Schlager Daniela
        Date: 25.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 07.11.2019

 */

public class ChatController {

    private AnswerGenerator chatModel;

    @FXML
    private TextArea textAreaChat;

    @FXML
    private TextField textFieldQuestion;


    public void setChatModel(AnswerGenerator chatModel) {
        this.chatModel = chatModel;
    }

    @FXML
    void onAsk(ActionEvent event) {
        textAreaChat.appendText(textFieldQuestion.getText()+"\n");
        textFieldQuestion.clear();
        textAreaChat.appendText(chatModel.answer()+"\n");

    }

}
