public class Player {
    private String name;
    private boolean isTurn;
    private int piecesCount;
    private boolean winner;

    public int getPiecesCount() {
        return piecesCount;
    }

    public void setPiecesCount(int piecesCount) {
        this.piecesCount = piecesCount;
    }


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
