import java.util.ArrayList;

public class Move {
    private int x;
    private int y;
    ArrayList<Move> deletedPlaces = new ArrayList<>();

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Move(int x, int y, ArrayList<Move> deletedPlaces) {
        this.x = x;
        this.y = y;
        this.deletedPlaces = deletedPlaces;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
