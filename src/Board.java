import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/** Contains most of the logic for creating and drawing the board and its pieces*/
public class Board extends JPanel {
    /** The size of the board*/
    public static final int BOARDSIZE = 8;
    /** The size of each individual board tile in pixels*/
    public static final int TILESIZE = 100;
    /** A 2D array which represents the board*/
    private Piece[][] board = new Piece[BOARDSIZE][BOARDSIZE];
    /** Returns board*/
    public Piece[][] getBoard() {
        return board;
    }
    /**Checks if piece is dark*/
    private boolean isDark(int x, int y){
        return (y % 2 == 0) == (x % 2 != 0);
    }
    /** Initializes the board and puts pieces on it*/
    private void createBoard() {
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
    /** Checks if a move is within the bounds of the board
     @return boolean of whether the move is valid or not
     * */
    public static boolean isMoveValid(int x, int y){
        return x < BOARDSIZE && y < BOARDSIZE && x >= 0 && y >= 0;
    }
    /** Gives pieces and squares their shape and color*/
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
                    if(piece.isKing()){
                        margin = 38;
                        g2.setColor(Color.BLACK);
                        g2.fillOval(realx + margin, realy + margin, TILESIZE - (margin*2), TILESIZE - (margin*2));
                    }
                }
            }
        }
    }
    Game game;

    /** Initializes the board
     * Ensures that the right pieces have their moves generated when they are clicked on
     * Counts the amount of pieces left of each player
     * Ensures the right player's turn*/
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

                if (piece != null) {
                    if (piece.getPieceColor() == PieceColor.BLUE && game.blueTurn && !piece.isKing()) { // generate moves for normal blue pieces
                        game.hasSelected = true;
                        game.selectedx = boardx;
                        game.selectedy = boardy;
                        game.availableMoves = piece.generateMoves(Board.this, boardx, boardy);
                    } else if (piece.getPieceColor() == PieceColor.RED && !game.blueTurn&& !piece.isKing()) { // generate moves for normal red pieces
                        game.hasSelected = true;
                        game.selectedx = boardx;
                        game.selectedy = boardy;
                        game.availableMoves = piece.generateMoves(Board.this, boardx, boardy);
                    } else if (piece.getPieceColor() == PieceColor.BLUE && game.blueTurn && piece.isKing()) {// generate moves for king blue pieces
                        game.hasSelected = true;
                        game.selectedx = boardx;
                        game.selectedy = boardy;
                        game.availableMoves = piece.generateKingMoves(Board.this, boardx, boardy);
                    } else if (piece.getPieceColor() == PieceColor.RED && !game.blueTurn && piece.isKing()) { // generate moves for king red pieces
                        game.hasSelected = true;
                        game.selectedx = boardx;
                        game.selectedy = boardy;
                        game.availableMoves = piece.generateKingMoves(Board.this, boardx, boardy);
                    }

                } else {
                    for (Move move : game.availableMoves) {
                        if (move.getX() == boardx && move.getY() == boardy) {
                            Piece selectedPiece = board[game.selectedy][game.selectedx];
                            board[game.selectedy][game.selectedx] = null;
                            board[move.getY()][move.getX()] = selectedPiece;

                            if ((move.getY() == 0 && selectedPiece.getPieceColor() == PieceColor.RED) || // if a piece reaches the other side of the board it becomes a king
                                    (move.getY() == BOARDSIZE - 1 && selectedPiece.getPieceColor() == PieceColor.BLUE)) {
                                selectedPiece.setKing(true);
                            }
                            for (Move deleted : move.deletedPlaces) {
                                Piece capturedPiece = board[deleted.getY()][deleted.getX()];
                                board[deleted.getY()][deleted.getX()] = null;
                                if (capturedPiece != null) { // captures a piece and deducts amount of pieces from opposing player
                                    if (capturedPiece.getPieceColor() == PieceColor.RED) {
                                        game.p1pieces--;
                                        game.p1piecesLabel.setText(game.p1pieces + "");
                                    } else {
                                        game.p2pieces--;
                                        game.p2piecesLabel.setText(game.p2pieces + "");
                                    }
                                }
                            }
                                game.availableMoves = new ArrayList<Move>();
                                game.hasSelected = false;
                                game.blueTurn = !game.blueTurn;
                                game.switchTurns();
                            }
                        }
                    }
                    Board.this.repaint();
                    game.checkVictoryByElimination();
                    game.checkVictoryByNoMoves();
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
