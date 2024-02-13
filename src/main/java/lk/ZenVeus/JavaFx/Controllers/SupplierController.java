package lk.ZenVeus.JavaFx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ZenVeus.JavaFx.db.Supplier;

import java.io.IOException;
import java.util.LinkedList;

public class SupplierController {
    public TextField suppIdText;
    public TextField suppNameText;
    public TextField suppEmailText;
    public TextField suppPhoneText;
    public TextField suppAddText;
    static LinkedList supplierDetails =new LinkedList();


    public void supplierRegBtn(ActionEvent actionEvent) throws IOException {

        if (suppIdText.getText().isEmpty() || suppNameText.getText().isEmpty() || suppEmailText.getText().isEmpty() || suppPhoneText.getText().isEmpty() || suppAddText.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            suppIdText.setText("");
            suppNameText.setText("");
            suppEmailText.setText("");
            suppAddText.setText("");
            suppPhoneText.setText("");
        }else {


            supplierDetails.add(new Supplier(suppIdText.getText(),suppNameText.getText(),suppEmailText.getText(),suppAddText.getText(),suppPhoneText.getText()));

            //////////////////////////////////////////////////////////////
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Customer Registered Successfully");
            alert.showAndWait();
            suppIdText.setText("");
            suppNameText.setText("");
            suppEmailText.setText("");
            suppPhoneText.setText("");
            suppAddText.setText("");


        }
    }


    public static Object getSuppilerList() {
        return supplierDetails;
    }
}
