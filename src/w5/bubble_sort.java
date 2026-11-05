package w5;

// logic for bubble sort :
// 1. Compare adjacent elements and swap them if they are in the wrong order.
// 2. Repeat this process for each element in the array until the entire array is sorted
// time complexity : O(n^2) in worst case and O(n) in best case
public class bubble_sort {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
