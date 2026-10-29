package w4;

public class imp_hash_table {
    public static void main(String[] args) {
        System.out.println("===== 1. TEST HASH TABLE CHAINING (DANH SÁCH LIÊN KẾT) =====");
        hash_table_chaining chaining = new hash_table_chaining(5);

        // Thêm các số vào bảng băm (5 và 10 sẽ đụng độ vì chia 5 đều dư 0)
        chaining.put(1, 100);
        chaining.put(5, 500);
        chaining.put(10, 1000); // Đụng độ với 5 tại Bucket 0
        chaining.put(7, 700);

        chaining.printTable();

        System.out.println("\nTìm key 5: " + chaining.get(5));
        System.out.println("Tìm key 10: " + chaining.get(10));
        System.out.println("Xóa key 5: " + chaining.remove(5));
        System.out.println("Tìm lại key 5 sau khi xóa: " + chaining.get(5));
        chaining.printTable();

        System.out.println("\n===== 2. TEST HASH TABLE LINEAR PROBING (THĂM DÒ TUYẾN TÍNH) =====");
        hash_table_linear_probing linear = new hash_table_linear_probing(5);

        linear.put(2, 20);
        linear.put(7, 70);   // 7 % 5 = 2 (đụng độ với 2 -> nhảy sang slot 3)
        linear.put(12, 120); // 12 % 5 = 2 (đụng độ -> nhảy tiếp sang slot 4)

        linear.printTable();

        System.out.println("\nTìm key 7: " + linear.get(7));
        System.out.println("Xóa key 7: " + linear.remove(7));
        linear.printTable();
    }
}
