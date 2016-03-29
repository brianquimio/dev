package fundamentals;

public class MyStack {

    public Node top;
    public int size;

    public MyStack () {
        this.size = 0;
    }

    public class Node {
        public int data;
        public Node next;

        public Node (int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
        size++;
    }

    public int pop() {
        int data= top.data;
        top = top.next;
        size--;
        return data;
    }

    public int peek() {
        return top.data;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(5);
        s.push(1);
        s.peek();   //1
        s.push(6);
        s.peek();   //6
        s.pop();
        s.peek();   //1
        s.pop();
        s.peek();   //5

    }

}