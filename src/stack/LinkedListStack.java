package stack;
import linkedlist.*;

public class LinkedListStack implements Stack {
    private LinkedList ll;
    int size;

    public LinkedListStack(int size) {
        this.ll = new LinkedList();
        this.size = size;
    }

    @Override
    public void push(int data) {
        if (this.length() >= this.size) {
            throw new IllegalStateException("stack is full");
        }
        ll.appendNode(data);
    }

    @Override
    public void pop() {
        if (this.ll.head == null) {
            throw new IllegalStateException("stack is empty");
        }
        ll.removeLast();
    }

    @Override
    public void print() {
        ll.print();
    }

    @Override
    public int length() {
        return ll.length();
    }

    public Node top() {
        Node current = this.ll.head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
}
