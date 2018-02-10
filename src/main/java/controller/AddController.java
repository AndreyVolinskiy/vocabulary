package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.factory.ServiceFactory;
import util.Language;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Andrey Volinskiy on 10.02.2018.
 */
public class AddController implements Initializable {
    @FXML
    private Button btnExit;
    @FXML
    private Text txtField;
    @FXML
    private ComboBox comboTwo;
    @FXML
    private ComboBox comboOne;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField txtWordTwo;
    @FXML
    private TextField txtWordOne;

    private ObservableList<String> comboList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboList.setAll(Language.ENGLISH, Language.UKRAINIAN);
        comboOne.setItems(comboList);
        comboTwo.setItems(comboList);
        btnAdd.setOnMouseClicked(event -> {
            addWord(event);
        });
        btnExit.setOnAction(event -> exit());
    }

    private void exit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    private void addWord(MouseEvent event) {
        String wordOne = txtWordOne.getText();
        String wordTwo = txtWordTwo.getText();
        String itemOne = (String) comboOne.getSelectionModel().getSelectedItem();
        String itemTwo = (String) comboTwo.getSelectionModel().getSelectedItem();
        String langOne = null;
        String langTwo = null;
        String ukrWord = null;
        String engWord = null;
        switch (itemOne) {
            case Language.UKRAINIAN:
                langOne = "ukr";
                ukrWord = wordOne;
                break;
            case Language.ENGLISH:
                langOne = "eng";
                engWord = wordOne;
                break;
        }
        switch (itemTwo) {
            case Language.UKRAINIAN:
                langTwo = "ukr";
                ukrWord = wordTwo;
                break;
            case Language.ENGLISH:
                langTwo = "eng";
                engWord = wordTwo;
                break;
        }
        ServiceFactory.getVocabularyService().add(ukrWord, engWord);
        comboOne.setValue(null);
        comboTwo.setValue(null);
        txtWordOne.setText("");
        txtWordTwo.setText("");
        txtField.setText("Success! Enter new words to add or exit");
    }
}
