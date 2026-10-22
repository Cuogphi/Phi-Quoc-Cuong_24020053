package w3.queue;

public class imp_bylinkedlist_queue {
    private Node front;
    private Node rear;
    private int size;

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = newNode;
        }
        else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = front.data;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    private static class Node {
        private final int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }
}
