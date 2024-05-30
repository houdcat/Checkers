import java.awt.*;

public class Piece {
    private PieceColor color;

    public Piece(PieceColor color) {
        this.color = color;
    }

    public Color getColor() {

        return this.color == PieceColor.RED ? Color.RED : Color.BLUE;
    }
}
