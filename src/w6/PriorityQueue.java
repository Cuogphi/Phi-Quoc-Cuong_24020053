package w6;

// Hàng đợi ưu tiên (Priority Queue) cài đặt dựa trên Heap
// Mặc định: Min-Priority Queue (số nhỏ hơn có độ ưu tiên cao hơn)
public class PriorityQueue {
    private MinHeap minHeap;
    private MaxHeap maxHeap;
    private boolean isMinPriority;

    // Constructor mặc định dùng Min-Priority Queue
    public PriorityQueue(int capacity) {
        this(capacity, true);
    }

    // isMinPriority = true -> ưu tiên số nhỏ nhất; false -> ưu tiên số lớn nhất
    public PriorityQueue(int capacity, boolean isMinPriority) {
        this.isMinPriority = isMinPriority;
        if (isMinPriority) {
            this.minHeap = new MinHeap(capacity);
        } else {
            this.maxHeap = new MaxHeap(capacity);
        }
    }

    // Thêm phần tử vào hàng đợi ưu tiên - O(log n)
    public void enqueue(int value) {
        if (isMinPriority) {
            minHeap.insert(value);
        } else {
            maxHeap.insert(value);
        }
    }

    // Lấy và xóa phần tử có độ ưu tiên cao nhất - O(log n)
    public int dequeue() {
        if (isMinPriority) {
            return minHeap.extractMin();
        } else {
            return maxHeap.extractMax();
        }
    }

    // Xem phần tử có độ ưu tiên cao nhất mà không xóa - O(1)
    public int peek() {
        if (isMinPriority) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

    public boolean isEmpty() {
        return isMinPriority ? minHeap.isEmpty() : maxHeap.isEmpty();
    }

    public boolean isFull() {
        return isMinPriority ? minHeap.isFull() : maxHeap.isFull();
    }

    public int size() {
        return isMinPriority ? minHeap.size() : maxHeap.size();
    }

    public void printQueue() {
        if (isMinPriority) {
            System.out.print("PriorityQueue (Min) -> ");
            minHeap.printHeap();
        } else {
            System.out.print("PriorityQueue (Max) -> ");
            maxHeap.printHeap();
        }
    }
}
