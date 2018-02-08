package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.factory.ServiceFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public class TranslatorController implements Initializable{

    @FXML
    public TextField txtEnterWord;
    @FXML
    public TextField txtTranslatedWord;
    @FXML
    public Button btnTranslate;
    @FXML
    public Button btnOK;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnTranslate.setOnAction(event -> translate());
        btnOK.setOnAction(event -> clear());
    }

    private void clear() {
        txtEnterWord.clear();
        txtTranslatedWord.clear();
    }

    private void translate() {
        String s = txtEnterWord.getText();
        txtTranslatedWord.setText(ServiceFactory.getVocabularyService().translate(s));
    }
}
