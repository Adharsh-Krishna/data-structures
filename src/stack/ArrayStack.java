package stack;

public class ArrayStack implements Stack {
    int size;
    int[] arr;
    int length = 0;

    public ArrayStack(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    @Override
    public void push(int data) {
        if (this.length >= this.size) {
            throw new IllegalStateException("stack is full");
        }
        this.arr[this.length++] = data;
    }

    @Override
    public void pop() {
        if (this.length == 0) {
            throw new IllegalStateException("stack is empty");
        }
        this.length--;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void print() {
        int i = 0;
        while(i < this.length) {
            System.out.print(String.valueOf(this.arr[i]) + ",");
            i++;
        }
        System.out.println();
    }

    public int top() {
        return this.arr[this.length-1];
    }
}
