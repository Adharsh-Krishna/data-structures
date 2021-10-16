package queue;
import linkedlist.*;

public class LinkedListQueue implements Queue {

    LinkedList ll;
    int capacity = 0;
    int length = 0;

    public LinkedListQueue(int capacity) {
        this.ll = new LinkedList();
        this.capacity = capacity;
    }

    @Override
    public void enqueue(int data) {
        if (this.length == this.capacity) {
            throw new IllegalStateException("queue is full");
        }
        this.ll.appendNode(data);
        this.length++;
    }

    @Override
    public void dequeue() {
        if (this.length == 0) {
            throw new IllegalStateException("queue is empty");
        }
        this.ll.removeNode(0);
        this.length--;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void print() {
        this.ll.print();
    }

    public Node head() {
        return this.ll.head;
    }

    public Node tail() {
        Node tail = this.ll.head;
        while (tail.next!=null) {
            tail = tail.next;
        }
        return tail;
    }

}
