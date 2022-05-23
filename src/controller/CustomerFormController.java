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

public class CustomerFormController {
    public void saveCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SaveCustomerForm.fxml"))));
        stage.setTitle("Save Customer");
        stage.show();
    }

    public void searchCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SearchCustomerForm.fxml"))));
        stage.setTitle("Search Customer");
        stage.show();
    }
}
