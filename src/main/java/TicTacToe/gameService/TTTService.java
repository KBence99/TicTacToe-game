package TicTacToe.gameService;

import org.tinylog.Logger;

public class TTTService {

    private Logger logger;

    private enum CellState {
        PLAYER1,
        PLAYER2,
        EMPTY
    }

    public enum Player {
        PLAYER1,
        PLAYER2
    }

    private CellState playerToState(Player player){
        if(player == Player.PLAYER1) {
            return CellState.PLAYER1;
        }
        else{
            return CellState.PLAYER2;
        }
    }

    private void nextPlayer(){
        if(currentPlayer==Player.PLAYER1){
            currentPlayer=Player.PLAYER2;
        }
        else{
            currentPlayer=Player.PLAYER1;
        }
    }

    private Player currentPlayer = Player.PLAYER1;
    public Player getcurrentPlayer(){
        return currentPlayer;
    }

    private Boolean isGameFinished = false;

    public CellState[][] board = {
            {CellState.EMPTY, CellState.EMPTY, CellState.EMPTY},
            {CellState.EMPTY, CellState.EMPTY, CellState.EMPTY},
            {CellState.EMPTY, CellState.EMPTY, CellState.EMPTY}
    };

    public TTTService(){
        Logger.info("Starting sudoku game");
        Logger.info("Current player is "+currentPlayer.toString());
    }

    public void placeMarker(int x, int y){
        if(board[x][y] == CellState.EMPTY){
            board[x][y] = playerToState(currentPlayer);
        }
        if(checkState()){
            isGameFinished = Boolean.TRUE;
            Logger.info("Game is finished");
        }
        nextPlayer();
    }

    private boolean checkState(){
        return checkRow() || checkColumn() || checkDiagonal();
    }
    private boolean checkRow(){
        for(int i=0; i<3; i++){
            if((board[i][0] == board[i][1] && board[i][1] == board[i][2]) && board[i][1] != CellState.EMPTY){
                return true;
            }
        }
        return false;
    }
    private boolean checkColumn(){
        for(int i=0; i<3; i++){
            if((board[0][i] == board[1][i] && board[1][i] == board[2][i])&&board[1][i]!= CellState.EMPTY){
                return true;
            }
        }
        return false;
    }
    private boolean checkDiagonal(){
        if(((board[0][0] == board[1][1] && board[1][1] == board[2][2])&&board[1][1]!= CellState.EMPTY)
        || ((board[0][2] == board[1][1] && board[1][1] == board[2][0])&&board[1][1]!= CellState.EMPTY)){
            return true;
        }
        return false;
    }
}
