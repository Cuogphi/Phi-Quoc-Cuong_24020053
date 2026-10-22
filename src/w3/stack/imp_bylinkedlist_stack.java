package w3.stack;

import java.util.LinkedList;

public class imp_bylinkedlist_stack {
    private LinkedList<Integer> list;

    public imp_bylinkedlist_stack() {
        list = new LinkedList<>();
    }

    public void push(int x) {
        list.addFirst(x);
    }

    public int pop() {
        if (list.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1; // or throw exception
        }
        return list.removeFirst();
    }

    public int peek() {
        if (list.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // or throw exception
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
