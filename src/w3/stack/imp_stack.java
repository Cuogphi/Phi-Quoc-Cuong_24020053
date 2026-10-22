package w3.stack;

import java.util.Scanner;


public class imp_stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();

        imp_byarr_stack stackByArr = new imp_byarr_stack(size);
        imp_bylinkedlist_stack stackByLinkedList = new imp_bylinkedlist_stack();

        // Example usage of stackByArr
        stackByArr.push(10);
        stackByArr.push(20);
        System.out.println("Top element in array stack: " + stackByArr.peek());
        System.out.println("Popped from array stack: " + stackByArr.pop());

        // Example usage of stackByLinkedList
        stackByLinkedList.push(30);
        stackByLinkedList.push(40);
        System.out.println("Top element in linked list stack: " + stackByLinkedList.peek());
        System.out.println("Popped from linked list stack: " + stackByLinkedList.pop());

        scanner.close();
    }
}

