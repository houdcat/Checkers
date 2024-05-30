import java.awt.*;
import java.util.ArrayList;

public class Piece {
    private PieceColor color;
    private static Color colorRed = new Color(249, 88, 105);
    private static Color colorBlue = new Color(88, 99, 249);



    public Piece(PieceColor color) {
        this.color = color;
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
        if(this.getPieceColor() == PieceColor.RED){
            side = -1;
        }else{
            side = 1;
        }
        if(Board.isMoveValid(x -1,y + side)){
            moves.add(new Move(x -1,y + side));
        }if(Board.isMoveValid(x + 1,y + side)){
            moves.add(new Move(x + 1,y + side));
        }
        return moves;
    }
}
