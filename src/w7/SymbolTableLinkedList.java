package w7;

// Symbol Table không có thứ tự (Unordered) cài đặt bằng Danh sách liên kết (Sequential Search)
public class SymbolTableLinkedList {
    private static class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public SymbolTableLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Thêm cặp (key, value) hoặc cập nhật nếu key đã tồn tại - O(n)
    public void put(String key, int value) {
        if (key == null) return;

        Node cur = head;
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        // Chèn vào đầu danh sách
        head = new Node(key, value, head);
        size++;
    }

    // Lấy giá trị theo key, trả về -1 nếu không tìm thấy - O(n)
    public int get(String key) {
        if (key == null) return -1;

        Node cur = head;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    // Xóa key khỏi Symbol Table - O(n)
    public boolean delete(String key) {
        if (key == null || head == null) return false;

        if (head.key.equals(key)) {
            head = head.next;
            size--;
            return true;
        }

        Node cur = head;
        while (cur.next != null) {
            if (cur.next.key.equals(key)) {
                cur.next = cur.next.next;
                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean contains(String key) {
        return get(key) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printTable() {
        System.out.println("=== Symbol Table (Linked List) ===");
        Node cur = head;
        while (cur != null) {
            System.out.print("[" + cur.key + " : " + cur.value + "] -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
