package controller;

/**
 * @author Andrey Volinskiy on 10.02.2018.
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

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
        btnAdd.setOnMouseClicked(event -> {
            try {
                addWord(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void init() {
        columnUkr.setCellValueFactory(new PropertyValueFactory<>("ukr"));
        columnEng.setCellValueFactory(new PropertyValueFactory<>("eng"));
        load();
    }

    private void load() {
        observableList.clear();
        List<Vocabulary> list = new LinkedList<>();
        list.add(new Vocabulary("Привіт", "Hello"));
        list.add(new Vocabulary("Мова", "Language"));
        observableList.addAll(list);
        table.setItems(observableList);
    }

    private void addWord(MouseEvent event) throws IOException {
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

        stage.setOnHiding(e -> load());
    }
}