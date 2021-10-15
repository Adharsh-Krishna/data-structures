package linkedlist;

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void appendNode(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node current = this.head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode; 
    }

    public void print() {
        Node current = this.head;
        while(current != null) {
            System.out.print("-> " + String.valueOf(current.data));
            current = current.next;
        }
        System.out.println();
    }

    public void prependNode(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void insertNode(int data, int position) {
        if (position == 0) {
            this.prependNode(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = this.head;
        int pos = 0;

        try {
            while(pos < position - 1) {
                pos++;
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        } catch(Exception e) {
            System.out.println("Invalid operation");
        }
        
    }

    public void removeNode(int position) {
        if (this.head == null) return;
        if (position == 0) {
            this.head = this.head.next;
            return;
        }
        Node current = this.head;
        int pos = 0;

        try {
            while(pos < position - 1) {
                pos++;
                current = current.next;
            }
            current.next = current.next.next;
        } catch( Exception e) {
            System.out.println("Invalid operation");
        }
    }

    public int length() {
        Node current = this.head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}