package random;

import java.util.*;

public class Iterators  {

    //implement an iterator for a binary search tree using any traversal

    public static class Node implements Iterable<Node> {

        private int val;
        private Node parent;
        private Node left;
        private Node right;

        public Node (int val, Node parent) {
            this(val, parent, null, null);
        }

        public Node (int val) {
            this(val, null, null, null);
        }

        public Node (int val, Node parent, Node left, Node right) {
            this.val = val;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node getRight() {
            return this.right;
        }

        public Node getLeft() {
            return this.left;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Iterator<Node> iterator() {
            return new NodeIterator(this);
        }

        public String toString() {
            return Integer.toString(this.val);
        }
    }

    public static class NodeIterator implements Iterator<Node> {

        private Node cur;
        private Node last;
        private boolean lastPrinted;

        //inorder
        public NodeIterator(Node root) {
            this.cur = root;
            this.last = root;
            while(this.last.getRight() != null) {
                this.last = this.last.getRight();
            }

            while(this.cur.getLeft() != null) {
                this.cur = this.cur.getLeft();
            }
        }

        public boolean hasNext() {
            return !lastPrinted;
        }

        public Node next() {
            Node ret = this.cur;
            //calculate next one
            if(this.lastPrinted){
                throw new NoSuchElementException();
            }
            if(ret == last){
                this.lastPrinted = true;
            }
            else if(this.cur.getRight() == null) {
                do {
                    if (this.cur.getParent() == null)
                        break;
                    this.cur = this.cur.getParent();
                } while (this.cur.getVal() < ret.getVal());

            }
            else {
                this.cur = this.cur.getRight();
                while (this.cur.getLeft() != null) {
                    this.cur = this.cur.getLeft();
                }
            }
            return ret;
        }

        public void remove() {
            //nothing
        }
    }

    public static void main(String[] args) {

        Node ten = new Node(10);
        Node seven = new Node(7, ten);
        Node three = new Node(3, seven);
        Node nine = new Node(9, seven);
        Node eight = new Node(8, nine);
        Node fifteen = new Node(15, ten);
        Node twenty = new Node(20, fifteen);

        ten.setLeft(seven);
        seven.setLeft(three);
        seven.setRight(nine);
        nine.setLeft(eight);
        ten.setRight(fifteen);
        fifteen.setRight(twenty);


        Iterator i = ten.iterator();
        while(i.hasNext()) {
            System.out.println(i.next().toString());
        }



    }




}
