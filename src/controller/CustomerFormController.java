/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package controller;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import view.tm.CustomerTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerFormController {
    public TextField txtId;
    public TextField txtTitle;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtProvince;
    public TextField txtPostalCode;
    public TableView<CustomerTm> tblCustomer;
    public TableColumn colId;
    public TableColumn colTitle;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colProvince;
    public TableColumn colPostalCode;

    public void txtIdOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?)");
            pstm.setObject(1,txtId.getText());
            pstm.setObject(2,txtTitle.getText());
            pstm.setObject(3,txtName.getText());
            pstm.setObject(4,txtAddress.getText());
            pstm.setObject(1,txtId.getId());
            pstm.setObject(1,txtId.getId());
            pstm.setObject(1,txtId.getId());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
