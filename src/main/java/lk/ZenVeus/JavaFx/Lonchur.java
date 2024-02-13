package lk.ZenVeus.JavaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Lonchur extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    static Stage loginStage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode= FXMLLoader.load(getClass().getResource("/View/LoginPage.fxml"));

        Scene loginScene = new Scene(rootNode);
        loginStage = new Stage();
        loginStage.setScene(loginScene);
        loginStage.setTitle("Login");
        loginStage.show();
    }
    public static Stage getStage(){
        return loginStage;
    }
}
