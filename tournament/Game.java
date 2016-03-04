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

        ArrayList<BracketNode> nodes = new ArrayList<>();
        for (int i=1; i<=numPlayers; i++) {
            System.out.print("Player " + i + " name: ");
            name = scan.nextLine();
            Player p = new Player(name);
            BracketNode node = new BracketNode(p);
            nodes.add(node);
        }

        //odd number of Players, add bye
        if (numPlayers % 2 == 1) {
            Player bye = new Player();
            BracketNode byeNode = new BracketNode(bye);
            nodes.add(byeNode);
        }

        System.out.println("Shuffling...");
        Collections.shuffle(nodes);

        for (BracketNode n : nodes ) {
            System.out.println(n.getPlayer().getName());
        }

        //Num nodes = numPlayers*2 - 1

        ArrayList<BracketNode> a = buildFirstRound(nodes);
        buildOtherRounds(a);

        System.out.println("Done.");

    }

    public static ArrayList<BracketNode> buildFirstRound (ArrayList<BracketNode> bn) {
        int numPlayers = bn.size();

        ArrayList<BracketNode> winners = new ArrayList<>();
        // map bottom level
        for (int i = 0; i < numPlayers; i += 2) {
            BracketNode playerOneNode = bn.get(i);
            BracketNode playerTwoNode = bn.get(i + 1);
            BracketNode winner = new BracketNode(null);

            BracketNode.map(playerOneNode, playerTwoNode, winner);
            winners.add(winner);
        }

        return winners;

    }

    public static void buildOtherRounds (ArrayList<BracketNode> winners) {
        int levelSize = winners.size();
        int levels = (int)(Math.log(levelSize)/Math.log(2)) + 1;

        ArrayList<BracketNode> nodes = winners;
        ArrayList<BracketNode> temp = new ArrayList<>();
        for(int i=0; i<levels; i++) {
            for(int n=0; n<levelSize; n+= 2) {
                BracketNode one = nodes.get(n);
                BracketNode two = nodes.get(n+1);

                BracketNode winner = new BracketNode(null);
                BracketNode.map(one, two, winner);

                temp.add(winner);
            }
            nodes = temp;
            levelSize /= 2;
        }

    }



}
