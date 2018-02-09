package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Andrey Volinskiy on 10.02.2018.
 */
public class WelcomeController implements Initializable {
    @FXML
    private Button btnExit;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnExit.setOnAction(event -> exit());
        btnDelete.setOnAction(event -> goDeleteWindow());
        btnAdd.setOnAction(event -> goAddWindow());
        btnView.setOnAction(event -> {
            try {
                goViewWindow(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void goViewWindow(ActionEvent event) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/table.fxml"));
        Parent parent = fxmlLoader.load();
        final Stage stage = new Stage();
        Scene value = new Scene(parent);
        stage.setScene(value);
        stage.initModality(Modality.WINDOW_MODAL);
        Window window = ((Node) event.getSource()).getScene().getWindow();
        stage.initOwner(window);
        stage.show();

//        stage.setOnHiding(e -> load());
    }

    private void goAddWindow() {

    }

    private void goDeleteWindow() {
    }

    private void exit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
