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

        // Error message disappears when error is corrected
        errorMsgField.setText("");

        scrabbleModel.setInputWord(typedWord);
        historyMsgField.setText(scrabbleModel.formattedArrayList(scrabbleModel.getAllAcceptedWords()));

        // Break long words
        errorMsgField.setWrapText(true);

        // Display error messages
        errorMsgField.setText(scrabbleModel.getErrorMsg());

        // Highlight the input field if the word is valid/not valid
        if(scrabbleModel.getErrorMsg() == ""){
            inputFiled.setStyle("-fx-border-color: green");
        } else {
            inputFiled.setStyle("-fx-border-color: red");
        }

        // Display points
        scoreField.setText(String.valueOf(scrabbleModel.getTotalPoints()));

        System.out.println("Typed " + typedWord);

    }
}
