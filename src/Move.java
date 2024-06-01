import java.util.ArrayList;

/**Manages moves*/
public class Move {
    /**x coordinate of a move*/
    private int x;
    /**y coordinate of a move*/
    private int y;
    /**Keeps track of places which may be captured by a move*/
    ArrayList<Move> deletedPlaces = new ArrayList<>();

    /**Initializes a move
     @param x x coordinate of a move
     @param y y coordinate of a move
     * */
    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**Initializes a move that may result in a capture
     @param x x coordinate of a move
     @param y y coordinate of a move
     @param deletedPlaces places that may be captured
     * */
    public Move(int x, int y, ArrayList<Move> deletedPlaces) {
        this.x = x;
        this.y = y;
        this.deletedPlaces = deletedPlaces;
    }
    /**@return x*/
    public int getX() {
        return x;
    }
    /**@return y*/
    public int getY() {
        return y;
    }
}
