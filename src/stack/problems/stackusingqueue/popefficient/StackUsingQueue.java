package stack.problems.stackusingqueue.popefficient;
import queue.CircularArrayQueue;
import stack.Stack;

public class StackUsingQueue implements Stack {
    int capacity, length;
    CircularArrayQueue q1, q2;

    public StackUsingQueue(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.q1 = new CircularArrayQueue(capacity);
        this.q2 = new CircularArrayQueue(capacity);
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isFull() {
        return this.length == this.capacity;
    }

    @Override
    public void push(int data) {
        if (this.isFull()) {
            throw new IllegalStateException("stack is full");
        }

        q2.enqueue(data);
        while(!q1.isEmpty()) {
            q2.enqueue(q1.getHead());
            q1.dequeue();
        }

        CircularArrayQueue temp = q1;
        q1 = q2;
        q2 = temp;
        this.length++;
    }

    @Override
    public void pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        q1.dequeue();
        this.length--;
    }

    @Override
    public void print() {
        this.q1.print();
    }

    @Override
    public int length() {
        return this.length;
    }
}
