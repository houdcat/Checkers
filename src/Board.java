import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Board extends JPanel {

    public static final int BOARDSIZE = 8;
    public static final int TILESIZE = 100;
    private Piece[][] board = new Piece[BOARDSIZE][BOARDSIZE];

    public Piece[][] getBoard() {
        return board;
    }

    private boolean isDark(int x, int y){ //checks if piece is dark
        return (y % 2 == 0) == (x % 2 != 0);
    }

    private void createBoard() {    // initializes board
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
    public static boolean isMoveValid(int x, int y){
        return x < BOARDSIZE && y < BOARDSIZE && x >= 0 && y >= 0;
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
                    if(game.hasSelected && game.selectedx == x && game.selectedy == y){
                        g2.setColor(Color.CYAN);
                    }
                    for(Move move : game.availableMoves ){
                        if(move.getX() == x && move.getY() == y){
                            g2.setColor(Color.YELLOW);
                        }
                    }
                    g2.fillRect(realx, realy, TILESIZE, TILESIZE);
                }
                if(piece != null){
                    int margin = 10;
                    g2.setColor(piece.getColor());
                    g2.fillOval(realx + margin, realy + margin, TILESIZE-(margin*2), TILESIZE-(margin*2));
                    margin = 15;
                    g2.setColor(piece.getColor().darker());
                    g2.fillOval(realx + margin, realy + margin, TILESIZE-(margin*2), TILESIZE-(margin*2));
                }
            }
        }
    }
    Game game;

    public Board(Game game) {
        this.game = game;
        this.setLayout(new GridLayout(BOARDSIZE, BOARDSIZE));
        createBoard();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int boardx = e.getX() / TILESIZE;
                int boardy = e.getY() / TILESIZE;
                Piece piece = board[boardy][boardx];
                if(piece != null){
                    if(piece.getPieceColor() == PieceColor.BLUE && game.blueTurn){
                        game.hasSelected = true;
                        game.selectedx = boardx;
                        game.selectedy = boardy;
                        game.availableMoves = piece.generateMoves(Board.this, boardx, boardy);
                    }
                    else if(piece.getPieceColor() == PieceColor.RED && !game.blueTurn){
                        game.hasSelected = true;
                        game.selectedx = boardx;
                        game.selectedy = boardy;
                        game.availableMoves = piece.generateMoves(Board.this, boardx, boardy);
                    }
                }else{
                    for(Move move : game.availableMoves){
                        if(move.getX() == boardx && move.getY() == boardy){
                            Piece selectedPiece = board[game.selectedy][game.selectedx];
                            board[game.selectedy][game.selectedx] = null;
                            board[move.getY()][move.getX()] = selectedPiece;
                            for(Move deleted : move.deletedPlaces){
                                Piece capturedPiece = board[deleted.getY()][deleted.getX()];
                                board[deleted.getY()][deleted.getX()] = null;
                                if(capturedPiece != null){
                                    if(capturedPiece.getPieceColor() == PieceColor.RED){
                                        game.p1pieces--;
                                        game.p1piecesLabel.setText(game.p1pieces + "");
                                    }else{
                                        game.p2pieces--;
                                        game.p2piecesLabel.setText(game.p2pieces + "");
                                        game.checkVictoryByElimination();
                                    }
                                }
                            }
                            game.availableMoves = new ArrayList<Move>();
                            game.hasSelected = false;
                            game.blueTurn = !game.blueTurn;
                        }
                    }
                }
                Board.this.repaint();
                game.checkVictoryByElimination();


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


}
