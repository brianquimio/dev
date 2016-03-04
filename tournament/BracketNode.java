package tournament;

public class BracketNode {

    private Player player;
    private Player opponent;
    private BracketNode winner;

    public BracketNode(Player player) {
        this(player, null, null);
    }

    public BracketNode(Player player, Player opponent, BracketNode winner) {
        this.player = player;
        this.opponent = opponent;
        this.winner = winner;
    }

    public static void map (BracketNode playerNode, BracketNode opponentNode, BracketNode winner) {
        playerNode.setOpponent(opponentNode.getPlayer());
        opponentNode.setOpponent(playerNode.getPlayer());

        playerNode.setWinner(winner);
        opponentNode.setWinner(winner);
    }

    public Player getPlayer () {
        return player;
    }

    public void setPlayer (Player p) {
        this.player = p;
    }

    public Player getOpponent ()  { return opponent; }

    public void setOpponent (Player o) { this.opponent = o; }

    public BracketNode getWinner() { return winner; }

    public void setWinner(BracketNode w) { this.winner = w;}

}