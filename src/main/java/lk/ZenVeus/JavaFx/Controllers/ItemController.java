package lk.ZenVeus.JavaFx.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ZenVeus.JavaFx.db.Item;

import java.util.LinkedList;

public class ItemController {

    public TextField itemIdText;
    public TextField itemNameText;
    public TextField itemSupIdText;
    public TextField itemQuantityText;
    public TextField itemPriceText;
    static LinkedList itemDetails = new LinkedList();

    public void itemRegBtn(ActionEvent actionEvent){
        if (itemIdText.getText().isEmpty() || itemNameText.getText().isEmpty() || itemSupIdText.getText().isEmpty() || itemQuantityText.getText().isEmpty() || itemPriceText.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            itemIdText.setText("");
            itemNameText.setText("");
            itemSupIdText.setText("");
            itemQuantityText.setText("");
            itemPriceText.setText("");
        }else{


            itemDetails.add(new Item(itemIdText.getText(),itemNameText.getText(),itemSupIdText.getText(),itemPriceText.getText(),itemQuantityText.getText()));

            ////////////////////////////////////////////////////////
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Customer Registered Successfully");
            alert.showAndWait();
            itemIdText.setText("");
            itemNameText.setText("");
            itemSupIdText.setText("");
            itemQuantityText.setText("");
            itemPriceText.setText("");
        }
    }
    public static Object getItemList(){
        return itemDetails;
    }
}
