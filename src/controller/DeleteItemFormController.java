package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

public class DeleteItemFormController {
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQtyOnHand;

    public void txtCodeOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM item WHERE itemCode=?", txtCode.getText());
        if (rst.next()) {
            txtDescription.setText(rst.getString(2));
            txtPackSize.setText(rst.getString(3));
            txtUnitPrice.setText(rst.getString(4));
            txtQtyOnHand.setText(rst.getString(5));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").showAndWait();
        }
    }

    public void deleteItemOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = CrudUtil.execute("DELETE FROM item WHERE itemCode=?", txtCode.getText());
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
