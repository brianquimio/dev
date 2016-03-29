package interviews;

import java.util.HashMap;

public class VMware2 {

    public static boolean anagram(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        HashMap<Character, Integer> ret = new HashMap<Character, Integer>();

        for(char c : w1) {
            if(!ret.containsKey(c))
                ret.put(c, 1);
            else
                ret.put(c, ret.get(c) + 1);
        }

        for(char c : w2) {
            if(ret.containsKey(c)) {
                ret.put(c, ret.get(c) - 1);
            }
            else {
                return false;
            }

        }

        int count;
        for(char key : ret.keySet()) {
            count = ret.get(key);
            if(count != 0) {
                return false;
            }
        }

        return true;

    }

    public class myLinkedList {
        public class Node {
            public Node next;
            public int data;
            public Node(int data) {
                this.data = data;
            }

        }

        Node head;
        public myLinkedList() {
            head = null;
        }

        public void add(Node n) {
            if(head == null) {
                head = n;
                head.next = null;
            }
            else {
                Node t = head;
                while(t.next != null) {
                    t = t.next;
                }

                t.next = n;
            }
        }

        public void out() {
            Node n = head;
            while(n.next != null) {
                System.out.print(n.data + " ");
                n = n.next;
            }

        }

        public void reverse(Node head) {

            Node prev = null;
            Node cur = head;
            Node next = cur.next;
            Node temp = cur;

            while(cur.next != null) {
                temp.next = prev;       //1 -> null
                next.next = cur;        //2 -> 1
                prev = cur;             //prev = 1
                temp = cur.next;        //temp = 2

                cur = cur.next;
            }

        }

    }

    public static void main(String[] args){

        myLinkedList l = new VMware2().new myLinkedList();
        myLinkedList.Node one = l.new Node(1);
        myLinkedList.Node two = l.new Node(2);
        myLinkedList.Node three = l.new Node(3);
        myLinkedList.Node four = l.new Node(4);
        l.add(one);
        l.add(two);
        l.add(three);
        l.add(four);

        l.reverse(one);
        l.out();
    }



}
