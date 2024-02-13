package lk.ZenVeus.JavaFx.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ZenVeus.JavaFx.db.Customer;

import java.util.LinkedList;

public class CustomerController {
    public TextField custIdText;
    public TextField custNameText;
    public TextField custEmailText;
    public TextField custPhoneText;
    public TextField costAddtext;

    static LinkedList customerDetails = new LinkedList();

    public void custRegBtn(ActionEvent actionEvent){

        if (custIdText.getText().isEmpty() || custNameText.getText().trim().isEmpty() || custEmailText.getText().trim().isEmpty() || custPhoneText.getText().trim().isEmpty() || costAddtext.getText().trim().isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            custIdText.setText("");
            custNameText.setText("");
            custEmailText.setText("");
            custPhoneText.setText("");
            costAddtext.setText("");
        }else {

            customerDetails.add( new Customer(custNameText.getText(),custIdText.getText(),custEmailText.getText(),costAddtext.getText(),custPhoneText.getText()));

            System.out.println(customerDetails.size());
            ////////////////////////////////////////////////////////////
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Customer Registered Successfully");
            alert.showAndWait();
            custIdText.setText("");
            custNameText.setText("");
            custEmailText.setText("");
            custPhoneText.setText("");
            costAddtext.setText("");
        }

    }
    public static Object getCustomerList(){
        return customerDetails;
    }
}
