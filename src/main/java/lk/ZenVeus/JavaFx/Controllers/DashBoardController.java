package lk.ZenVeus.JavaFx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ZenVeus.JavaFx.Admin.Admin;
import lk.ZenVeus.JavaFx.db.Customer;
import lk.ZenVeus.JavaFx.db.Item;
import lk.ZenVeus.JavaFx.db.Supplier;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class DashBoardController {
    public Text dashUserName;
    public Text morningText;
    public Text timeText;
    /////////////////////////////////
    public Text itemCount;
    public Text vItemName;
    public Text vItemSupId;
    public Text vItemPrice;
    public Text vItemQntity;
    public Text vItemId;
    public Text vSupCount;
    public Text vCustId;
    public Text vCustName;
    public Text vCustEmail;
    public Text vCustAdd;
    public Text vCustPhone;
    public Text vSupId;
    public Text vSupName;
    public Text vSupEmail;
    public Text vSupAdd;
    public Text vSupPhone;
    public Text vCustCount;

    public void initialize(){
        dashUserName.setText(Admin.getuName());

        timeText.setText(createTime().toString());
        morningText.setText(createMorning());

        fillCustomer();
        fillItem();
        fillSupplier();

    }

    private void fillSupplier() {
        LinkedList<Supplier> supplierList = (LinkedList<Supplier>) SupplierController.getSuppilerList();

        // Check if custList is not empty
        if (!supplierList.isEmpty()) {
            // Set the text of itemCount to display the size of custList
            vSupCount.setText(String.valueOf(supplierList.size()));

            // Get the last customer from custList
            int supplierLastIndex = supplierList.size() - 1;
            Supplier lastSupplier = supplierList.get(supplierLastIndex);

            // Fill UI elements with data from the last customer
            vSupId.setText(lastSupplier.getSupplierId());
            vSupName.setText(lastSupplier.supplierName);
            vSupEmail.setText(lastSupplier.supplierEmail);
            vSupAdd.setText(lastSupplier.supplierAddress);
            vSupPhone.setText(lastSupplier.supplierPhone);

        } else {
            System.out.println("no Values");
            vSupId.setText("null");
            vSupName.setText("null");
            vSupEmail.setText("null");
            vSupAdd.setText("null");
            vSupPhone.setText("null");
            vSupCount.setText("0");
        }
    }

    private void fillItem() {
        LinkedList<Item> itemList = (LinkedList<Item>) ItemController.getItemList();

        // Check if custList is not empty
        if (!itemList.isEmpty()) {
            // Set the text of itemCount to display the size of custList
            itemCount.setText(String.valueOf(itemList.size()));

            // Get the last customer from custList
            int itemLastIndex = itemList.size() - 1;
            Item lastItem = itemList.get(itemLastIndex);

            // Fill UI elements with data from the last customer
            vItemId.setText(lastItem.getItemId());
            vItemName.setText(lastItem.itemName);
            vItemSupId.setText(lastItem.itemSupplierId);
            vItemPrice.setText(lastItem.itemPrice);
            vItemQntity.setText(lastItem.itemQntity);

        } else {
            System.out.println("no Values");
            vItemId.setText("null");
            vItemName.setText("null");
            vItemSupId.setText("null");
            vItemPrice.setText("null");
            vItemQntity.setText("null");
            itemCount.setText("0");
        }
    }

    private void fillCustomer() {
        LinkedList<Customer> custList = (LinkedList<Customer>) CustomerController.getCustomerList();

        // Check if custList is not empty
        if (!custList.isEmpty()) {
            // Set the text of itemCount to display the size of custList
            vCustCount.setText(String.valueOf(custList.size()));

            // Get the last customer from custList
            int custLastIndex = custList.size() - 1;
            Customer lastCustomer = custList.get(custLastIndex);

            // Fill UI elements with data from the last customer
            vCustId.setText(lastCustomer.getCustId());
            vCustName.setText(lastCustomer.custName);
            vCustEmail.setText(lastCustomer.custEmail);
            vCustPhone.setText(lastCustomer.custPhone);
            vCustAdd.setText(lastCustomer.custAdd);

        } else {

            System.out.println("no Values");
            vCustId.setText("null");
            vCustName.setText("null");
            vCustEmail.setText("null");
            vCustPhone.setText("null");
            vCustAdd.setText("null");
            vCustCount.setText("0");

            // Handle the case where custList is empty
            // For example, display a message or disable UI elements
        }
    }

    private String createMorning() {
        int hour = LocalTime.now().getHour();

        if (hour >= 6 && hour < 12) {
            return "Good morning";
        } else if (hour >= 12 && hour < 18) {
            return "Good afternoon";
        } else {
            return "Good evening";
        }
    }

    private Object createTime() {
        LocalTime time= LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);

    }

    public void logOutBtn(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) dashUserName.getScene().getWindow();
        stage.close();

        Parent rootNode=FXMLLoader.load(getClass().getResource("/View/LoginPage.fxml"));
        Scene loginScene = new Scene(rootNode);
        Stage loginStage = new Stage();
        loginStage.setScene(loginScene);
        loginStage.setTitle("Login");
        loginStage.show();
    }
    public void customerBtn(ActionEvent actionEvent) throws IOException {

        Parent rootNode= FXMLLoader.load(getClass().getResource("/View/Customer.fxml"));
        Scene custScene = new Scene(rootNode);
        Stage custStage = new Stage();
        custStage.setScene(custScene);
        custStage.setTitle("Customer");
        custStage.show();
    }
    public void itemBtn(ActionEvent actionEvent) throws IOException {
        Parent rootNode= FXMLLoader.load(getClass().getResource("/View/Item.fxml"));
        Scene itemScene = new Scene(rootNode);
        Stage itemStage = new Stage();
        itemStage.setScene(itemScene);
        itemStage.setTitle("Item");
        itemStage.show();
    }
    public void supplierBtn(ActionEvent actionEvent) throws IOException {
        Parent rootNode= FXMLLoader.load(getClass().getResource("/View/Supplier.fxml"));
        Scene supplierScene = new Scene(rootNode);
        Stage supplierStage = new Stage();
        supplierStage.setScene(supplierScene);
        supplierStage.setTitle("Supplier");
        supplierStage.show();
    }


    ///////////////////////////////////////////////////  open Web ////// - test /////////////////////////////////
    public void ShenSingh(ActionEvent actionEvent){

        System.out.println("click");

        try{
            Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
        }
        catch (Exception e)
        {}
    }

    public void refrashBtn(ActionEvent actionEvent) throws IOException {
        // //
        Stage refrashDash= LoginPageController.getStage();

        Parent rootLoding= FXMLLoader.load(getClass().getResource("/View/Loding.fxml"));
        Scene LodingScene = new Scene(rootLoding);

        refrashDash.setScene(LodingScene);//// not set--2 //- LodingPage//--

        //////////////////////////////////////////////////////////////////////////////
        Parent rootNode= FXMLLoader.load(LoginPageController.class.getResource("/View/DashBoard.fxml"));
        Scene DashBoardScene = new Scene(rootNode);
        refrashDash.setScene(DashBoardScene);
        refrashDash.setTitle("DashBoard");
        refrashDash.show();
    }
}