package controller;

/**
 * @author Andrey Volinskiy on 10.02.2018.
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Vocabulary;
import service.factory.ServiceFactory;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private Button btnExit;
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<Vocabulary> table;
    @FXML
    private TableColumn<Vocabulary, String> columnUkr;
    @FXML
    private TableColumn<Vocabulary, String> columnEng;

    private ObservableList<Vocabulary> observableList = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {

        init();
        load();
        ServiceFactory.getVocabularyService().getAll();
        btnExit.setOnAction(event -> exit());
        btnAdd.setOnAction(event -> {
            try {
                goAddWindow(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void exit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    private void init() {
        columnUkr.setCellValueFactory(new PropertyValueFactory<>("ukr"));
        columnEng.setCellValueFactory(new PropertyValueFactory<>("eng"));
        load();
    }

    private void load() {
        List<Vocabulary> list = ServiceFactory.getVocabularyService().getAll();
        observableList.clear();
        observableList.addAll(list);
        table.setItems(observableList);
    }

        private void goAddWindow(ActionEvent event) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/add.fxml"));
        Parent parent = fxmlLoader.load();
        final Stage stage = new Stage();
        Scene value = new Scene(parent);
        stage.setScene(value);
        stage.initModality(Modality.WINDOW_MODAL);
        Window window = ((Node) event.getSource()).getScene().getWindow();
        stage.initOwner(window);
        stage.show();
        stage.setOnHiding();
    }
}
