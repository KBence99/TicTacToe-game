package TicTacToe.javafx.controller;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.stage.Stage;
import org.tinylog.Logger;

public class WelcomeController {

    Logger logger;

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private TextField player1;

    @FXML
    private TextField player2;

    @FXML
    private Label errorLabel;

    public void StartGame(javafx.event.ActionEvent actionEvent) throws IOException{
        if(!(player1.getText().isEmpty()) && !(player2.getText().isEmpty())){
            Logger.info("Player1 is "+player1.getText());
            Logger.info("Player2 is "+player2.getText());

            Logger.info("Starting game");

            fxmlLoader = new FXMLLoader(WelcomeController.class.getResource("/fxml/Game.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<GameController>getController().setPlayerName(player1.getText(),player2.getText());
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("TicTacToe");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        }
        else
        {
            errorLabel.setText("One or both fields are empty");
        }
    }
}
