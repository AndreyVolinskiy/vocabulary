package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.factory.ServiceFactory;
import util.Language;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Andrey Volinskiy on 11.02.2018.
 */
public class TranslateController implements Initializable {

    @FXML
    private TextField txtWord;
    @FXML
    private TextField txtTranslation;
    @FXML
    private Button btnTranslate;
    @FXML
    private Text txtField;
    @FXML
    private ComboBox<String> comboFrom;
    @FXML
    private ComboBox<String> comboTo;
    @FXML
    private Button btnExit;

    private ObservableList<String> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        observableList.setAll(Language.ENGLISH, Language.UKRAINIAN);
        comboFrom.setItems(observableList);
        comboTo.setItems(observableList);
        btnExit.setOnAction(event -> exit());
        btnTranslate.setOnAction(event -> translate());
    }

    private void translate() {
        String word = txtWord.getText();
        String translation;
        String itemOne = comboFrom.getSelectionModel().getSelectedItem();
        String itemTwo = comboTo.getSelectionModel().getSelectedItem();
        String langFrom = null;
        String langTo = null;
        switch (itemOne) {
            case Language.UKRAINIAN:
                langFrom = "ukr";
                break;
            case Language.ENGLISH:
                langFrom = "eng";
                break;
        }
        switch (itemTwo) {
            case Language.UKRAINIAN:
                langTo = "ukr";
                break;
            case Language.ENGLISH:
                langTo = "eng";
                break;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ").append(langTo).append(" FROM vocabulary WHERE ").append(langFrom).append(" = '").append(word).append("'");
        try {
            translation = ServiceFactory.getVocabularyService().find(builder);
        } catch (SQLException e) {
            translation = "No such word in dictionary!";
        }

        txtWord.setText("");
        comboTo.setValue(null);
        comboFrom.setValue(null);
        txtTranslation.setText(translation);
        txtField.setText("Success! Enter new words to translate or exit");
    }

    private void exit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
