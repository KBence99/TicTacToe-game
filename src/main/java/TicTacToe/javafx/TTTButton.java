package TicTacToe.javafx;

import javafx.scene.control.Button;

public class TTTButton extends Button {
    private int xPos;
    private int yPos;

    public TTTButton(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }

    public int getxPos() {
        return xPos;
    }
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
