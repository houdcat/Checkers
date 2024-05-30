import java.awt.*;

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
}
