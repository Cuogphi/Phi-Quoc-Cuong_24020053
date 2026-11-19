package w7;

// Symbol Table có thứ tự (Ordered) cài đặt bằng Mảng sắp xếp + Tìm kiếm nhị phân (Binary Search)
public class SymbolTableBinarySearch {
    private String[] keys;
    private int[] values;
    private int size;

    public SymbolTableBinarySearch(int capacity) {
        keys = new String[capacity];
        values = new int[capacity];
        size = 0;
    }

    // Tìm vị trí của key (hoặc vị trí nên chèn) bằng Binary Search - O(log n)
    public int rank(String key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    // Thêm cặp (key, value) vào đúng thứ tự tăng dần của key - O(n)
    public void put(String key, int value) {
        if (key == null) return;

        int i = rank(key);
        // Nếu key đã tồn tại -> cập nhật value
        if (i < size && keys[i].equals(key)) {
            values[i] = value;
            return;
        }

        if (size == keys.length) {
            System.out.println("Symbol Table is full!");
            return;
        }

        // Dịch các phần tử lớn hơn sang phải 1 bước
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    // Tìm kiếm nhị phân theo key, trả về -1 nếu không có - O(log n)
    public int get(String key) {
        if (key == null || isEmpty()) return -1;

        int i = rank(key);
        if (i < size && keys[i].equals(key)) {
            return values[i];
        }
        return -1;
    }

    // Xóa key khỏi Symbol Table - O(n)
    public boolean delete(String key) {
        if (key == null || isEmpty()) return false;

        int i = rank(key);
        if (i == size || !keys[i].equals(key)) {
            return false; // Không tìm thấy
        }

        for (int j = i; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[size] = null;
        return true;
    }

    public String min() {
        return isEmpty() ? null : keys[0];
    }

    public String max() {
        return isEmpty() ? null : keys[size - 1];
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
        System.out.println("=== Symbol Table (Binary Search - Ordered) ===");
        for (int i = 0; i < size; i++) {
            System.out.println("[" + keys[i] + " : " + values[i] + "]");
        }
    }
}
