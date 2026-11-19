package w7;

public class imp_symbol_table {
    public static void main(String[] args) {
        System.out.println("===== 1. TEST SYMBOL TABLE (LINKED LIST) =====");
        SymbolTableLinkedList stList = new SymbolTableLinkedList();
        stList.put("Cuong", 9);
        stList.put("An", 8);
        stList.put("Binh", 7);
        stList.put("An", 10); // Cập nhật giá trị của "An"
        stList.printTable();

        System.out.println("Get 'An': " + stList.get("An"));
        System.out.println("Contains 'Binh': " + stList.contains("Binh"));
        System.out.println("Delete 'Binh': " + stList.delete("Binh"));
        stList.printTable();

        System.out.println("\n===== 2. TEST SYMBOL TABLE (BINARY SEARCH - ORDERED) =====");
        SymbolTableBinarySearch stBin = new SymbolTableBinarySearch(10);
        stBin.put("Cuong", 9);
        stBin.put("An", 8);
        stBin.put("Dung", 10);
        stBin.put("Binh", 7);
        stBin.printTable(); // Sẽ tự động sắp xếp theo thứ tự bảng chữ cái: An -> Binh -> Cuong -> Dung

        System.out.println("Min key: " + stBin.min());
        System.out.println("Max key: " + stBin.max());
        System.out.println("Get 'Cuong': " + stBin.get("Cuong"));
        System.out.println("Delete 'Binh': " + stBin.delete("Binh"));
        stBin.printTable();
    }
}
