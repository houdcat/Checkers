import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private int boardSize = 8;
    private Square[][] board = new Square[8][8];

    private void createBoard() {
        boolean dark;
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x< boardSize; x++) {
                dark = (y % 2 == 0) == (x % 2 != 0);
                Square square = new Square(x, y, dark);
                board[x][y] = square;
                this.add(square.getSquare());
            }
        }
    }
    private void createPieces(){

    }

    public Board() {
        this.setLayout(new GridLayout(boardSize, boardSize));
        createBoard();
    }

}
