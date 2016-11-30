package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller {
    public Button loginButton;
    public Button cancelButton;
    public Label messageLabel;
    public Button noButton;

    public void clickLogin(ActionEvent actionEvent) throws IOException {
        handleButtonAction(actionEvent);
    }

    public void clickCancel(ActionEvent actionEvent) throws IOException {
        handleButtonAction(actionEvent);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==loginButton){
            //get reference to the button's stage
            stage=(Stage) loginButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("pageAfterLogin.fxml"));
        }
        else if(event.getSource()==cancelButton){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlertBox.fxml"));
                root = fxmlLoader.load();
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.show();
        }
        else if(event.getSource()==noButton){
            System.exit(0);
        }
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    public void noButton(ActionEvent actionEvent) throws IOException {
        handleButtonAction(actionEvent);
    }
}
