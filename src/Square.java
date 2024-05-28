import javax.swing.*;

public class Square {

    private final int size = 80;
    private JPanel square;
    private boolean isOccupied;
    private PieceColor occupyingColor;
    private PieceType occupyingType;
    private int x;
    private int y;



    public Square(boolean isOccupied, PieceColor occupyingColor, PieceType occupyingType, int x, int y) {
        this.square.setSize(size,size);
        this.isOccupied = isOccupied;
        this.occupyingColor = occupyingColor;
        this.occupyingType = occupyingType;
        this.x = x;
        this.y = y;
    }
}
