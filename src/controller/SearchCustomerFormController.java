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
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchCustomerFormController {

    public TextField txtId;
    public TextField txtName;
    public TextField txtTitle;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtProvince;
    public TextField txtPostalCode;

    public void searchCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer WHERE custId=?");
        stm.setObject(1, txtId.getText());
        ResultSet rst = stm.executeQuery();
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
}