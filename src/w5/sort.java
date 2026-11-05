package w5;

import java.util.Arrays;

public class sort {
    public static void printArray(String name, int[] arr) {
        System.out.println(name + ": " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] original = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Mảng ban đầu: " + Arrays.toString(original));
        System.out.println("----------------------------------------------");

        // 1. Bubble Sort
        int[] arr1 = original.clone();
        bubble_sort bs = new bubble_sort();
        bs.bubbleSort(arr1);
        printArray("1. Bubble Sort   ", arr1);

        // 2. Selection Sort
        int[] arr2 = original.clone();
        selection_sort ss = new selection_sort();
        ss.selectionSort(arr2);
        printArray("2. Selection Sort", arr2);

        // 3. Insertion Sort
        int[] arr3 = original.clone();
        insertion_sort is = new insertion_sort();
        is.insertionSort(arr3);
        printArray("3. Insertion Sort", arr3);

        // 4. Merge Sort
        int[] arr4 = original.clone();
        mergesort ms = new mergesort();
        ms.mergeSort(arr4, 0, arr4.length - 1);
        printArray("4. Merge Sort    ", arr4);

        // 5. Quick Sort
        int[] arr5 = original.clone();
        quicksort qs = new quicksort();
        qs.quickSort(arr5, 0, arr5.length - 1);
        printArray("5. Quick Sort    ", arr5);
    }
}
