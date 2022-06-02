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

    public void deleteCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DeleteCustomerForm.fxml"))));
        stage.setTitle("Delete Customer");
        stage.show();
    }

    public void updateCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UpdateCustomerForm.fxml"))));
        stage.setTitle("Update Customer");
        stage.show();
    }

    public void loadAllCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoadAllCustomerForm.fxml"))));
        stage.setTitle("Load All Customer");
        stage.show();
    }
}
