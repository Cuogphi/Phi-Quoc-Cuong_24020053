package w5;




//time complexity : O(n log n) in best/ average case, O(n^2) in worst case
public class quicksort {

private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition_Lomuto(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition_Lomuto(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private int partition_Hoare(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;

            swap(arr, i, j);
        }
    }



    public void quickSortHoare(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition_Hoare(arr, low, high);

        quickSortHoare(arr, low, pi);      // Lưu ý: low đến pi (chứa cả pi)
        quickSortHoare(arr, pi + 1, high); // pi + 1 đến high
    }
}
}
