package w6;

public class imp_heap {
    public static void main(String[] args) {
        System.out.println("===== 1. TEST MAX HEAP =====");
        MaxHeap maxHeap = new MaxHeap(10);
        int[] data = { 2, 1, 8, 5, 4, 10, 9, 11 };
        for (int x : data) {
            maxHeap.insert(x);
        }
        maxHeap.printHeap();
        System.out.println("Peek max: " + maxHeap.peek());
        System.out.println("Extract max: " + maxHeap.extractMax());
        maxHeap.printHeap();

        System.out.println("\n===== 2. TEST MIN HEAP =====");
        MinHeap minHeap = new MinHeap(10);
        minHeap.buildHeap(data);
        minHeap.printHeap();
        System.out.println("Peek min: " + minHeap.peek());
        System.out.println("Extract min: " + minHeap.extractMin());
        minHeap.printHeap();

        System.out.println("\n===== 3. TEST PRIORITY QUEUE (MIN-PRIORITY) =====");
        PriorityQueue pqMin = new PriorityQueue(10);
        pqMin.enqueue(30);
        pqMin.enqueue(10);
        pqMin.enqueue(50);
        pqMin.enqueue(20);
        pqMin.printQueue();
        System.out.print("Dequeue theo thứ tự ưu tiên (nhỏ -> lớn): ");
        while (!pqMin.isEmpty()) {
            System.out.print(pqMin.dequeue() + " ");
        }
        System.out.println();

        System.out.println("\n===== 4. TEST PRIORITY QUEUE (MAX-PRIORITY) =====");
        PriorityQueue pqMax = new PriorityQueue(10, false);
        pqMax.enqueue(30);
        pqMax.enqueue(10);
        pqMax.enqueue(50);
        pqMax.enqueue(20);
        pqMax.printQueue();
        System.out.print("Dequeue theo thứ tự ưu tiên (lớn -> nhỏ): ");
        while (!pqMax.isEmpty()) {
            System.out.print(pqMax.dequeue() + " ");
        }
        System.out.println();
    }
}
