package w3.stack;

import java.util.Scanner;


public class imp_stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();

        imp_byarr_stack stackByArr = new imp_byarr_stack(size);
        imp_bylinkedlist_stack stackByLinkedList = new imp_bylinkedlist_stack();


        scanner.close();
    }
}

