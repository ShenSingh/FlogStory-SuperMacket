package lk.ZenVeus.JavaFx.Controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ZenVeus.JavaFx.Admin.Admin;
import lk.ZenVeus.JavaFx.Lonchur;

import java.io.IOException;

public class LoginPageController {
    public PasswordField uPassText;
    public TextField uNameText;
    public AnchorPane logingAnchorPane;
    static Stage DashBoardStage;

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        System.out.println("Login");

        Admin Admin = new Admin();

        if (uNameText.getText().isEmpty() || uPassText.getText().isEmpty()){

            uNameText.setText("");
            uPassText.setText("");
            alert("User Name or User Password is not fill");
        }else {
            if(lk.ZenVeus.JavaFx.Admin.Admin.getuName().equals(uNameText.getText()) && Admin.getuPassword().equals(uPassText.getText())){
                goToDashBoard();
            }else {
                uNameText.setText("");
                uPassText.setText("");
                alert("Invalid User Name or User Password");
            }
        }
    }

    public static void goToDashBoard() throws IOException {
        //
        Lonchur.getStage().hide();

        Parent rootNode= FXMLLoader.load(LoginPageController.class.getResource("/View/DashBoard.fxml"));
        Scene DashBoardScene = new Scene(rootNode);
        DashBoardStage = new Stage();
        DashBoardStage.setScene(DashBoardScene);
        DashBoardStage.setTitle("DashBoard");
        DashBoardStage.show();

    }

    public void alert(String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText(content);

        alert.show();

        int displayDurationMillis = 3000;// 3s

        PauseTransition delay = new PauseTransition(Duration.millis(displayDurationMillis));
        delay.setOnFinished(event -> alert.close());
        delay.play();
    }
    public static Stage getStage(){
        return DashBoardStage;
    }

}
