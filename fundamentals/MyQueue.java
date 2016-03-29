package fundamentals;

public class MyQueue {

    public class Node {
        public int data;
        public Node next;

        public Node (int data) {
            this.data = data;
        }
    }

    public Node first;
    public Node last;
    public int size;

    public MyQueue() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(int data) {
        Node n = new Node(data);
        if (last != null) {
            last.next = n;
        }
        last = n;
        if (first == null) {
            first = last;
        }
        size++;
    }

    public int dequeue() {
        int data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        System.out.println(data);
        return data;

    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(5);
        q.enqueue(6);
        q.dequeue();
        q.dequeue();
    }


}
