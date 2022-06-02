/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.SQLException;

public class SaveCustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtTitle;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtProvince;
    public TextField txtPostalCode;

    public void saveCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isSaved = CrudUtil.execute("INSERT INTO customer VALUES (?,?,?,?,?,?,?)", txtId.getText(), txtTitle.getText(), txtName.getText(), txtAddress.getText(), txtCity.getText(), txtProvince.getText(), txtPostalCode.getText());
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved").showAndWait();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").showAndWait();
        }
    }
}
