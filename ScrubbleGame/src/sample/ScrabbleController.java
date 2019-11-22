package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ScrabbleController {
    @FXML
    TextField inputFiled, scoreField;

    @FXML
    TextArea errorMsgField, historyMsgField;

    @FXML
    private void submit(ActionEvent event){
        String typedWord = inputFiled.getText();
        ScrabbleModel scrabbleModel = new ScrabbleModel(typedWord);
        System.out.println("Typed " + typedWord);
    }
}
