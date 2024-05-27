public class Player {
    private String name;
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

    Player p1 = new Player("", false);
    Player p2 = new Player("", false);
}
