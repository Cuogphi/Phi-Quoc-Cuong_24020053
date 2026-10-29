package w4;

// Cài đặt Bảng băm dùng Thăm dò tuyến tính (Linear Probing)
public class hash_table_linear_probing {
    private int[] keys;
    private int[] values;
    private boolean[] occupied; // Đánh dấu ô đang có phần tử
    private int capacity;
    private int size;

    public hash_table_linear_probing(int capacity) {
        this.capacity = capacity;
        this.keys = new int[capacity];
        this.values = new int[capacity];
        this.occupied = new boolean[capacity];
        this.size = 0;
    }

    // Hàm băm cơ bản
    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    // Thêm hoặc cập nhật phần tử
    public void put(int key, int value) {
        if (size >= capacity) {
            System.out.println("Bảng băm đã đầy!");
            return;
        }

        int index = hash(key);

        // Nếu ô đã bị chiếm, dò tuyến tính ô kế tiếp
        while (occupied[index]) {
            if (keys[index] == key) {
                values[index] = value;
                return;
            }
            index = (index + 1) % capacity;
        }

        keys[index] = key;
        values[index] = value;
        occupied[index] = true;
        size++;
    }

    // Tìm giá trị theo key, trả về -1 nếu không có
    public int get(int key) {
        int index = hash(key);
        int count = 0;

        while (occupied[index] && count < capacity) {
            if (keys[index] == key) {
                return values[index];
            }
            index = (index + 1) % capacity;
            count++;
        }
        return -1;
    }

    // Xóa phần tử theo key
    public boolean remove(int key) {
        int index = hash(key);
        int count = 0;

        while (occupied[index] && count < capacity) {
            if (keys[index] == key) {
                occupied[index] = false;
                size--;
                return true;
            }
            index = (index + 1) % capacity;
            count++;
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
        System.out.println("=== Hash Table (Linear Probing) ===");
        for (int i = 0; i < capacity; i++) {
            if (occupied[i]) {
                System.out.println("Slot " + i + ": [" + keys[i] + ":" + values[i] + "]");
            } else {
                System.out.println("Slot " + i + ": empty");
            }
        }
    }
}
