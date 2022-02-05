package TicTacToe.javafx.controller;

import TicTacToe.gameService.TTTService;
import TicTacToe.javafx.TTTButton;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import org.tinylog.Logger;

import java.awt.*;

public class GameController {

    private TTTService tttService = new TTTService();

    private TTTButton[][] board = new TTTButton[3][3];

    private char currentSymbol;

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private Label player1;

    @FXML
    private Label player2;

    @FXML
    private GridPane gameGrid;

    @FXML
    public void initialize(){
        Logger.info("Initializing grid");
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                TTTButton button = new TTTButton(j,i);
                button.setPrefWidth(gameGrid.getPrefWidth()/3);
                button.setPrefHeight(gameGrid.getPrefHeight()/3);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        var source = (TTTButton)actionEvent.getSource();
                        buttonClick(source.getxPos(), source.getyPos());
                    }
                });
                gameGrid.add(button,i,j);
                board[i][j] = button;
            }
        }
    }

    private void buttonClick(int x, int y){
        Logger.info("Button"+x+":"+y+" pressed.");

        if(tttService.getcurrentPlayer() == TTTService.Player.PLAYER1){
            currentSymbol = 'X';
        }
        else{
            currentSymbol = 'O';
        }
        tttService.placeMarker(x,y);
        board[y][x].setText(currentSymbol+"");
        board[y][x].setDisable(true);
    }

    public void setPlayerName(String Player1, String Player2){
        player1.setText(Player1);
        player2.setText(Player2);
    }
}
