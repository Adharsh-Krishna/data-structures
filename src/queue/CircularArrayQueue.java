package queue;

public class CircularArrayQueue implements Queue {
    int capacity = 0;
    int[] arr;
    int head, tail;
    int length = 0;

    public CircularArrayQueue(int capacity) {
        this.head = this.tail = -1;
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }

    @Override
    public void enqueue(int data) {
        if ((this.tail+1) % this.capacity == this.head) {
            throw new IllegalStateException("Queue is full");
        }
        this.length++;
        if (this.head == -1) {
            this.tail ++;
            this.head ++;
            this.arr[this.head] = data;
            return;
        }
        this.tail = (this.tail + 1) % this.capacity;
        this.arr[this.tail] = data;
    }

    @Override
    public void dequeue() {
        if (this.head == -1) {
            throw new IllegalStateException("Queue is empty");
        }
        this.length--;
        if (this.head == this.tail) {
            this.head = this.tail = -1;
            return;
        }
        this.head = (this.head + 1) % this.capacity;
    }

    @Override
    public void print() {
        if (this.head == -1) return;

        int i = this.head;
        while (i < this.capacity && i != this.tail) {
            System.out.print(String.valueOf(this.arr[i]) + ",");
            i = (i+1) % this.capacity;
        }
        System.out.print(String.valueOf(this.arr[this.tail]) + ",");
        System.out.println();
    }

    @Override
    public int length() {
        return this.length;
    }

    public int head() {
        return this.head == -1 ? this.head : this.arr[this.head];
    }

    public int tail() {
        return this.tail == -1 ? this.tail : this.arr[this.tail];
    }
}
