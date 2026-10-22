package sort;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class mergesort {
    public void merge (int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // or mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
// explain the merge sort algorithm in detail
    public void explainMergeSort() {
        System.out.println("Merge Sort is a divide-and-conquer algorithm that divides the input array into two halves, recursively sorts them, and then merges the sorted halves.");
        System.out.println("1. Divide: The array is divided into two halves until each sub-array contains a single element.");
        System.out.println("2. Conquer: Each sub-array is sorted recursively.");
        System.out.println("3. Combine: The sorted sub-arrays are merged to produce the final sorted array.");
        System.out.println("The time complexity of Merge Sort is O(n log n) in all cases (best, average, worst).");
        System.out.println("It is a stable sort and works well for large datasets.");
    }
}


