/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package controller;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
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
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?)");
        pstm.setObject(1, txtId.getText());
        pstm.setObject(2, txtTitle.getText());
        pstm.setObject(3, txtName.getText());
        pstm.setObject(4, txtAddress.getText());
        pstm.setObject(5, txtCity.getText());
        pstm.setObject(6, txtProvince.getText());
        pstm.setObject(7, txtPostalCode.getText());
        if (pstm.executeUpdate() > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved").showAndWait();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").showAndWait();
        }
    }
}
