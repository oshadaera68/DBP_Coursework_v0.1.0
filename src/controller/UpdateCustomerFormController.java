/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package controller;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtTitle;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtProvince;
    public TextField txtPostalCode;

    public void txtIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
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

    public void updateCustomerOnAction(ActionEvent actionEvent) {
        Customer c = new Customer(txtId.getText(), txtTitle.getText(), txtName.getText(), txtAddress.getText(), txtCity.getText(), txtProvince.getText(), txtPostalCode.getText());

        try {
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE customer SET custTitle=?,custName=?,custAddress=?,city=?,province=?,postalCode=? WHERE custId=?");
            stm.setObject(1, c.getTitle());
            stm.setObject(2, c.getName());
            stm.setObject(3, c.getAddress());
            stm.setObject(4, c.getCity());
            stm.setObject(5, c.getProvince());
            stm.setObject(6, c.getPostalCode());
            stm.setObject(7, c.getId());

            if (stm.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
