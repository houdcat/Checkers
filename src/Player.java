public class Player {
    private String name;
    private boolean isTurn;
    private boolean winner = false;


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
