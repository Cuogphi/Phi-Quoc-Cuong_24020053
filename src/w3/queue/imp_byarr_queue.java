package w3.queue;

import java.util.Scanner;

public class imp_byarr_queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    public imp_byarr_queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    public void enqueue(int x) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[++rear] = x;
    }

    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return -1; // or throw exception
        }


        return arr[front++];
    }

    public int peek() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return -1; // or throw exception
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public int size() {
        return rear - front + 1;
    }
}
