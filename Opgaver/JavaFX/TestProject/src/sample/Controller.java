package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public Label lbl1;
    public Button btn1;
    public Button btn2;

    private static int counter = 0;

    public void change(ActionEvent actionEvent) throws IOException {
        handleButtonAction(actionEvent);
    }

    public void goToNewPage(ActionEvent actionEvent) throws IOException {
        handleButtonAction(actionEvent);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;


        if(event.getSource()==btn1){
            //get reference to the button's stage
            stage=(Stage) btn1.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("OtherPage.fxml"));
        }
        else{
            stage=(Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FirstFx.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

}
