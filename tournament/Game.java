package tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        String name;

        System.out.println("-----Tournament Mode-----\n");

        System.out.print("How many players? ");
        int numPlayers = scan.nextInt();
        scan.nextLine();

        ArrayList<Player> players = new ArrayList<Player>();
        for (int i=1; i<=numPlayers; i++) {
            System.out.print("Player " + i + " name: ");
            name = scan.nextLine();
            players.add(new Player(name));
        }

        //odd number of Players, add bye
        if (numPlayers % 2 == 1) {
            players.add(new Player());
        }

        System.out.println("Shuffling...");
        Collections.shuffle(players);

        for (Player player : players ) {
            System.out.println(player.getName());
        }

        //Num nodes = numPlayers*2 - 1
        //sleep between games //Thread.sleep()

    }

    public static void buildBracket (int numPlayers, ArrayList<Player> players) {

        int emptyNodes = numPlayers - 1;
        BracketNode winner = new BracketNode(null, null, null);
        BracketNode final1 = new BracketNode(players.get(0), players.get(1), winner.getPlayer());
        BracketNode final2 = new BracketNode(players.get(1), players.get(0), winner.getPlayer());

    }

    public static void printBracket (ArrayList<Player> players) {

    }


}
