/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package controller;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteCustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtTitle;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtProvince;
    public TextField txtPostalCode;

    public void txtIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer WHERE custId=?", txtId.getText());
        if (rst.next()) {
            txtTitle.setText(rst.getString(2));
            txtName.setText(rst.getString(3));
            txtAddress.setText(rst.getString(4));
            txtCity.setText(rst.getString(5));
            txtProvince.setText(rst.getString(6));
            txtPostalCode.setText(rst.getString(7));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").showAndWait();
        }
    }

    public void deleteCustomerOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = CrudUtil.execute("DELETE FROM customer WHERE custId=?", txtId.getText());
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted..!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
