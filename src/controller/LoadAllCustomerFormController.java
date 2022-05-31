/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadAllCustomerFormController {
    public TableView<Customer> tblCustomer;
    public TableColumn colCusId;
    public TableColumn colTitle;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colProvince;
    public TableColumn colPostalCode;

    public void initialize() {
        try {
            loadAllCustomers();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    private void loadAllCustomers() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer");
        ResultSet rst = stm.executeQuery();
        ObservableList<Customer> list = FXCollections.observableArrayList();
        while (rst.next()) {
            list.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7)));
        }
        tblCustomer.setItems(list);
    }
}
