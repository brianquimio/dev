package tournament;

public class Player {

    private String name;
    private int numPlayers;

    public Player () {
        this.name = "bye";
    }

    public Player(String name) {
        this.name = name;
        numPlayers++;
    }

    public String getName() {
        return name;
    }

    public int getNumPlayers() {
        return numPlayers;
    }
    
}

