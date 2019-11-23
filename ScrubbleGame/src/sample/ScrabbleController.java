package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ScrabbleController {
    @FXML
    TextField inputFiled, scoreField;

    @FXML
    TextArea errorMsgField, historyMsgField;

    @FXML
    Button submit_button;

    @FXML
    Group groupA, groupB, groupC, groupD, groupE,
            groupF, groupG, groupH, groupI, groupJ,
            groupK, groupL, groupM, groupN, groupO,
            groupP, groupQ, groupR, groupS, groupT,
            groupU, groupV, groupW, groupX, groupY,
            groupZ;

    @FXML
    private void submit(ActionEvent event){

        String typedWord = inputFiled.getText();
        ScrabbleModel scrabbleModel = new ScrabbleModel(typedWord);

        // Error message disappears when error is corrected
        errorMsgField.setText("");

        scrabbleModel.setInputWord(typedWord);
        historyMsgField.setText(scrabbleModel.formattedArrayList(scrabbleModel.getAllAcceptedWords()));

        // Break long words
        historyMsgField.setWrapText(true);

        // Display error messages
        errorMsgField.setText(scrabbleModel.getErrorMsg());

        // Highlight the input field if the word is valid/not valid
        if(scrabbleModel.getErrorMsg().equals("")){
            inputFiled.setStyle("-fx-border-color: green");
        } else {
            inputFiled.setStyle("-fx-border-color: red");
        }

        // Display points
        scoreField.setText(String.valueOf(scrabbleModel.getTotalPoints()));

        // Display Game Over Msg is the game is over
        if(scrabbleModel.isGameOver()){
            submit_button.setDisable(true);
        }
        System.out.println("Typed " + typedWord);

        if(!scrabbleModel.getBag().containsKey('a')){
            groupA.setStyle("visibility: hidden");
        }

        if(!scrabbleModel.getBag().containsKey('b')){
            groupB.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('c')){
            groupC.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('d')){
            groupD.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('e')){
            groupE.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('f')){
            groupF.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('g')){
            groupG.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('h')){
            groupH.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('i')){
            groupI.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('j')){
            groupJ.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('k')){
            groupK.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('l')){
            groupL.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('m')){
            groupM.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('n')){
            groupN.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('o')){
            groupO.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('p')){
            groupP.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('q')){
            groupQ.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('r')){
            groupR.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('s')){
            groupS.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('t')){
            groupT.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('u')){
            groupU.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('v')){
            groupV.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('w')){
            groupW.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('x')){
            groupX.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('y')){
            groupY.setStyle("visibility: hidden");
        }
        if(!scrabbleModel.getBag().containsKey('z')){
            groupZ.setStyle("visibility: hidden");
        }





    }
}
