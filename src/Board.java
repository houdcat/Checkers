import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public static final int BOARDSIZE = 8;
    public static final int TILESIZE = 100;
    private Piece[][] board = new Piece[BOARDSIZE][BOARDSIZE];

    private boolean isDark(int x, int y){ //checks if piece is dark
        return (y % 2 == 0) == (x % 2 != 0);
    }

    private void createBoard() {    // initializes board
        boolean dark;
        for (int y = 0; y < BOARDSIZE; y++) {
            for (int x = 0; x< BOARDSIZE; x++) {
                if(y <= 2 && isDark(x,y)){
                    board[y][x] = new Piece(PieceColor.BLUE);
                }else if(y >= BOARDSIZE -3 && isDark(x,y)){
                    board[y][x] = new Piece(PieceColor.RED);
                }

            }
        }
    }
    private void createPieces(){
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, getWidth(), getHeight());
        for(int y = 0; y < BOARDSIZE; y++){
            for(int x = 0; x < BOARDSIZE; x++){
                Piece piece = board[y][x];
                int realx = x*TILESIZE;
                int realy = y*TILESIZE;
                if(isDark(x,y)){
                    g2.setColor(Color.DARK_GRAY);
                    g2.fillRect(realx, realy, TILESIZE, TILESIZE);
                }
                if(piece != null){
                    g2.setColor(piece.getColor());
                }

            }
        }
    }


    public Board() {
        this.setLayout(new GridLayout(BOARDSIZE, BOARDSIZE));
        createBoard();
    }


}
