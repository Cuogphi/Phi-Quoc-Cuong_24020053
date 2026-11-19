package w6;

// Cài đặt Min Heap dùng mảng (phần tử nhỏ nhất luôn nằm ở đỉnh heap[0])
public class MinHeap {
    private int[] arr;
    private int size;

    public MinHeap(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Thêm phần tử mới vào Min Heap
    public void insert(int value) {
        if (size == arr.length) {
            System.out.println("Heap is full");
            return;
        }
        arr[size] = value;
        size++;
        siftUp(size - 1);
    }

    // Đẩy phần tử lên để đảm bảo tính chất Min Heap (cha <= con)
    private void siftUp(int index) {
        if (index == 0) {
            return;
        }
        int parentIndex = parent(index);
        if (arr[index] < arr[parentIndex]) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    // Lấy và xóa phần tử nhỏ nhất (ở đỉnh heap)
    public int extractMin() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        int min = arr[0];
        arr[0] = arr[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    // Đẩy phần tử xuống để khôi phục tính chất Min Heap
    private void siftDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            siftDown(smallest);
        }
    }

    // Xem phần tử nhỏ nhất nhưng không xóa
    public int peek() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        return arr[0];
    }

    // Xây dựng Min Heap từ một mảng có sẵn - O(n)
    public void buildHeap(int[] input) {
        if (input.length > arr.length) {
            arr = new int[input.length];
        }
        for (int i = 0; i < input.length; i++) {
            arr[i] = input[i];
        }
        size = input.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public int size() {
        return size;
    }

    public void printHeap() {
        System.out.print("MinHeap: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
