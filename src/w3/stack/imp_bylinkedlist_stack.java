package w3.stack;

public class imp_bylinkedlist_stack {
    private Node top;
    private int size;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
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
