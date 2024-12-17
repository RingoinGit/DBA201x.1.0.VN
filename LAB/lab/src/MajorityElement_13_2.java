import java.util.*;
import java.io.*;

public class MajorityElement_13_2 {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }
        //write your code here
        //Chia 2 mang
        int mid = left + (right - left) / 2;
        int leftMajor = getMajorityElement(a, left, mid);
        int rightMajor = getMajorityElement(a, mid + 1, right);

        //Nếu 2 mảng có cùng giá trị
        if (leftMajor == rightMajor) {
            return leftMajor;
        }

        //Nếu không, kiểm tra 1 trong hai giá trị có thỏa mãn điều kiện đa số không
        int leftCount = countNumber(a, left, right, leftMajor);
        int rightCount = countNumber(a, left, right, rightMajor);
        if (leftCount > (right - left + 1) / 2) {
            return leftMajor;
        } else if (rightCount > (right - left + 1) / 2) {
            return rightMajor;
        }
        return -1;
    }

    // Hàm đếm số lần xuất hiện của một phần tử trong mảng
    public static int countNumber(int[] array, int left, int right, int x) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (array[i] == x) {
                count++;
            }
        }
        return count;
    }

    //Tìm hiểu thêm về sử dụng Thuật toán Boyer-Moore Voting để giải bài này
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

