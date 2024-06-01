import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest{

    private Piece redPiece;
    private Piece bluePiece;
    private Board board;

    @Before
    public void setUp() {
        redPiece = new Piece(PieceColor.RED);
        bluePiece = new Piece(PieceColor.BLUE);
        board = new Board(new Game(new Lobby()));
    }

    @Test
    public void testGenerateMovesEmptyBoard() {
        ArrayList<Move> moves = redPiece.generateMoves(board, 4, 4);
        assertEquals(2, moves.size());
        assertTrue(moves.contains(new Move(3, 3)));
        assertTrue(moves.contains(new Move(5, 3)));

        moves = bluePiece.generateMoves(board, 4, 4);
        assertEquals(2, moves.size());
        assertTrue(moves.contains(new Move(3, 5)));
        assertTrue(moves.contains(new Move(5, 5)));
    }

}