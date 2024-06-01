/**One of two players*/
public class Player {
    /**The name of a player*/
    private String name;
    /**Determines if it is the player's turn*/
    private boolean isTurn;


    public Player(String name, boolean isTurn) {
        this.name = name;
        this.isTurn = isTurn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }
}
