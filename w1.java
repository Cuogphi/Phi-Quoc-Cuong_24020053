import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class w1 {
    public static long bai1_tinhTong(int[] a, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void bai2_sapXepTangDan(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = temp;
            }
        }
    }

    public static long bai3_tinhGiaiThua(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return Math.abs(a);
    }

    public static void bai4_rutGonPhanSo(long[] frac) {
        if (frac[1] == 0) return;
        long ucln = gcd(frac[0], frac[1]);
        frac[0] /= ucln;
        frac[1] /= ucln;
        if (frac[1] < 0) {
            frac[0] = -frac[0];
            frac[1] = -frac[1];
        }
    }

    public static void bai5_inLonHonBangTB(double[] a, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        double avg = sum / n;
        System.out.println(avg);
        for (int i = 0; i < n; i++) {
            if (a[i] >= avg) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }

    public static void bai6a_xoaPhanTu(List<Integer> list, int k) {
        if (k >= 0 && k < list.size()) {
            list.remove(k);
        }
    }

    public static void bai6b_chenPhanTu(List<Integer> list, int m, int y) {
        if (m >= 0 && m <= list.size()) {
            list.add(m, y);
        }
    }

    public static long bai7a_tinhTong2D(int[][] mat, int n, int m) {
        long total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total += mat[i][j];
            }
        }
        return total;
    }

    public static void bai7b_xoaDong(List<List<Integer>> mat, int r) {
        if (r >= 0 && r < mat.size()) {
            mat.remove(r);
        }

    }

    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(bai1_tinhTong(a, n));


    }    
 
}


    // Bai 1
    // Time: O(N)
    // Memory: O(1)
    // Bai 2
    // Time: O(N^2)
    // Memory: O(1)
    // Bai 4
    // Time: O(1)
    // Memory: O(1)
    // Bai 5
    // Time: O(N)
    // Memory: O(1)
    // Bai 6a
    // Time: Tot nhat O(1), Trung binh / Te nhat O(N)
    // Memory: O(1)
    // Bai 6b
    // Time: Tot nhat O(1), Trung binh / Te nhat O(N)
    // Memory: O(1)
    // Bai 7a
    // Time: O(N * M) O(N^2)
    // Memory: O(1)
    // Bai 7b
    // Time: Tot nhat O(1), Trung binh / Te nhat O(N)
    // Memory: O(1)
