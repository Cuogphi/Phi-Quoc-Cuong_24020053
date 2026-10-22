package w2;


public class lL {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public lL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false; // A linked list is never full unless memory is exhausted
    }

    public void insertAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) {
                tail = newNode;
            }
        }
        size++;
    }

    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = head.next;
            if (size == 1) {
                tail = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
        }
        size--;
    }

    public void insertAtHead(int data) {
        insertAt(0, data);
    }

    public void insertAtTail(int data) {
        insertAt(size, data);
    }

    public void deleteHead() {
        deleteAt(0);
    }

    public void deleteTail() {
        deleteAt(size - 1);
    }

    public void search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Found.");
                return;
            }
            current = current.next;
        }
        System.out.println("Not found.");
    }

    public static void main(String[] args) {

    }
}
