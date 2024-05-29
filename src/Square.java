import javax.swing.*;
import java.awt.*;

public class Square {
    private Piece piece;
    private static final int SIZE = 80;
    private JPanel square;
    private int x;
    private int y;
    private boolean darkSquare;

    public boolean isDarkSquare() {
        return darkSquare;
    }

    public Square(int x, int y, boolean darkSquare) {
        this.x = x;
        this.y = y;
        this.darkSquare = darkSquare;
        this.square = new JPanel();
        this.square.setPreferredSize(new Dimension(SIZE, SIZE));
        if(this.isDarkSquare()){
            this.square.setBackground(Color.DARK_GRAY);
        }else{
            this.square.setBackground(Color.LIGHT_GRAY);
        }
        this.square.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public JPanel getSquare() {
        return square;
    }
}
