package w4;

// Cài đặt Bảng băm dùng Danh sách liên kết giải quyết xung đột (Separate Chaining)
public class hash_table_chaining {
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table;
    private int capacity;
    private int size;

    public hash_table_chaining(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
        this.size = 0;
    }

    // Hàm băm đơn giản: lấy phần dư theo kích thước bảng
    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    // Thêm hoặc cập nhật phần tử
    public void put(int key, int value) {
        int index = hash(key);
        Node cur = table[index];

        // Nếu key đã tồn tại -> cập nhật value
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        // Chèn node mới vào đầu danh sách liên kết tại ô index
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    // Lấy giá trị theo key, trả về -1 nếu không tìm thấy
    public int get(int key) {
        int index = hash(key);
        Node cur = table[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    // Xóa phần tử theo key
    public boolean remove(int key) {
        int index = hash(key);
        Node cur = table[index];
        Node prev = null;

        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) {
                    table[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public boolean containsKey(int key) {
        return get(key) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printTable() {
        System.out.println("=== Hash Table (Chaining) ===");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Node cur = table[i];
            while (cur != null) {
                System.out.print("[" + cur.key + ":" + cur.value + "] -> ");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }
}
