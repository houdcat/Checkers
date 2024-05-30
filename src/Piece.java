import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Piece {
    private PieceColor color;
    private boolean isKing;
    private static Color colorRed = new Color(249, 88, 105);
    private static Color colorBlue = new Color(88, 99, 249);

    public void setKing(boolean king) {
        isKing = king;
    }

    public boolean isKing() {
        return isKing;
    }

    public Piece(PieceColor color) {
        this.color = color;
        this.isKing = false;
    }

    public Color getColor() {
        if(this.color == PieceColor.RED){
            return colorRed;
        }else{
            return colorBlue;
        }
    }
    public PieceColor getPieceColor(){
        return this.color;
    }
    public ArrayList<Move> generateMoves(Board board, int x, int y){
        int side;
        ArrayList<Move> moves = new ArrayList<>();
        PieceColor currentPieceColor = this.getPieceColor();
        if(currentPieceColor == PieceColor.RED){
            side = -1;
        }else{
            side = 1;
        }
        if(Board.isMoveValid(x -1,y + side)&&board.getBoard()[y + side][x - 1] ==null){ // checks if the tile exists on the board and if it's empty
            moves.add(new Move(x -1,y + side));
        }else if(
                Board.isMoveValid(x -1,y + side) && board.getBoard()[y + side][x - 1] != null &&
                Board.isMoveValid(x -2,y + side * 2) && board.getBoard()[y + side * 2][x - 2] == null &&
                board.getBoard()[y + side][x - 1].getPieceColor() != currentPieceColor){
            moves.add(new Move(x -2,y + side * 2, new ArrayList<>(List.of(new Move(x -1,y + side)))));
        }

        if(Board.isMoveValid(x + 1,y + side)&&board.getBoard()[y + side][x + 1] ==null){
            moves.add(new Move(x + 1,y + side));
        }else if(
                Board.isMoveValid(x +1,y + side) && board.getBoard()[y + side][x + 1] != null &&
                Board.isMoveValid(x +2,y + side * 2) && board.getBoard()[y + side * 2][x + 2] == null &&
                board.getBoard()[y + side][x + 1].getPieceColor() != currentPieceColor
        ){
            moves.add(new Move(x + 2,y + side * 2, new ArrayList<>(List.of(new Move(x + 1,y + side)))));
        }
        return moves;
    }
}
