/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemFormController {
    public void saveItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SaveItemForm.fxml"))));
        stage.setTitle("Save Item");
        stage.show();
    }

    public void searchItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SearchItemForm.fxml"))));
        stage.setTitle("Search Item");
        stage.show();
    }

    public void updateItemOnAction(ActionEvent actionEvent) {
    }

    public void deleteItemOnAction(ActionEvent actionEvent) {
    }

    public void loadAllItemOnAction(ActionEvent actionEvent) {
    }
}
