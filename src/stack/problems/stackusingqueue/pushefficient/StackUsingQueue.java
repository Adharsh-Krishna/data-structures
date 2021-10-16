package stack.problems.stackusingqueue.pushefficient;
import queue.CircularArrayQueue;
import stack.Stack;

public class StackUsingQueue implements Stack {
    int capacity = 0;
    CircularArrayQueue q1, q2;

    public StackUsingQueue(int capacity) {
        this.q1 = new CircularArrayQueue(capacity);
        this.q2 = new CircularArrayQueue(capacity);
        this.capacity = capacity;
    }

    public void push(int data) {
        if (q1.isFull()) {
            throw new IllegalStateException("stack is full");
        }
        q1.enqueue(data);
    }

    public void pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        while (!q1.isLast()) {
            q2.enqueue(q1.getHead());
            q1.dequeue();
        }
        q1.dequeue();

        CircularArrayQueue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int length() {
        return this.q1.length;
    }

    public void print() {
        this.q1.print();
    }

}
