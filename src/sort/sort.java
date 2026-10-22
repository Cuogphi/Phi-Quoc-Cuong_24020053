package sort;

public class sort {
    public static void main(String[] args) {

        int[] arr = { 12, 11, 13, 5, 6, 7 };
        mergesort ms = new mergesort();
        ms.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
