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

public class SaveItemFormController {
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQtyOnHand;

    public void saveItemOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isSaved = CrudUtil.execute("INSERT INTO item VALUES (?,?,?,?,?)", txtCode.getText(), txtDescription.getText(), txtPackSize.getText(), Double.parseDouble(txtUnitPrice.getText()), Integer.parseInt(txtQtyOnHand.getText()));
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved").showAndWait();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").showAndWait();
        }
    }
}
