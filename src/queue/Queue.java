package queue;

public interface Queue {
    public void enqueue(int data);
    public void dequeue();
    public void print();
    public int length();
}
