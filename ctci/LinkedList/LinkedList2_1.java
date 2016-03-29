package ctci.LinkedList;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;

public class LinkedList2_1 {

    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    //remove duplicates from unsorted linkedlist
    void twoDotOne (Node n) {
        HashSet<Integer> hs = new HashSet<>();
        Node prev = null;
        while (n != null) {
            if (hs.contains(n.data)) {
                prev.next = null;
            } else {
                hs.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    @Test
    public void testTwoDotOne() throws Exception {

    }

}
