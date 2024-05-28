import javax.swing.*;
import java.awt.*;
import java.sql.SQLInput;

public class Board extends JPanel {

    Square[][] board = new Square[8][8];

    public void createBoard(){
        int colorIndicator = 1;
        for(int i = 1; i < 9; i++){
            for(int j = 1; j < 9; j++){
                if(colorIndicator % 2 == 1){
                    new Square(false, PieceColor.NONE, PieceType.NONE, j,i); // Create white squares
                }
                else if(colorIndicator % 2 == 0){
                    if(i == 1 || i == 2 || i == 3){
                        new Square(true, PieceColor.BLUE, PieceType.MAN, j,i); // Create dark squares for blue
                    }
                    else if(i == 6 || i == 7 || i == 8){
                        new Square(true, PieceColor.RED, PieceType.MAN, j,i); // Create dark squares for red
                    }
                    else if(i == 4 || i == 5){
                        new Square(false,PieceColor.NONE,PieceType.NONE, j, i);
                    }
                }
            }
        }
    }
}
