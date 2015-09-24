package tournament;

public class BracketNode {

    Player player;
    Player opponent;
    Player winner;

    public BracketNode (Player player, Player opponent, Player winner) {
        this.player = player;
        this.opponent = opponent;
        this.winner = winner;
    }

    public Player getPlayer () {
        return player;
    }

    public void setPlayer (Player p) {
        this.player = p;
    }

    public Player getOpponent ()  {
        return opponent;
    }

    public void setOpponent (Player o) {
        this.opponent = o;
    }

    public Player getWinner () {
        return winner;
    }

    public void setWinner (Player w) {
        this.winner = w;
    }

}