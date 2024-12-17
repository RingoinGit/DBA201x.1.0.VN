import java.util.*;

public class PrimitiveCalculator_14_1 {
    private static List<Integer> optimal_sequence(int n) {
        /*
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        */

        // Sử dụng phương pháp bottom-up
        //Tạo mảng lưu các phép toán
        int[] cal = new int[n + 1];
        // Tạo mảng lưu các giá trị
        int[] num = new int[n + 1];

        cal[1] = 0;
        // Tính toán cho từng số từ 2 đến n
        for (int i = 2; i <= n; i++) {
            cal[i] = cal[i - 1] + 1; // Ban đầu giả sử sử dụng phép cộng 1
            num[i] = i - 1; // Lưu số trước đó

            // Nếu i chia hết cho 2, cập nhật phép tính
            if (i % 2 == 0 && cal[i / 2] + 1 < cal[i]) {
                cal[i] = cal[i / 2] + 1;
                num[i] = i / 2;
            }

            // Nếu i chia hết cho 3, cập nhật phép tính
            if (i % 3 == 0 && cal[i / 3] + 1 < cal[i]) {
                cal[i] = cal[i / 3] + 1;
                num[i] = i / 3;
            }
        }

        // Truy vết để tìm dãy các số từ 1 đến n
        List<Integer> sequence = new ArrayList<>();
        for (int at = n; at >= 1; at = num[at]) {
            sequence.add(at);
        }
        // Đảo ngược dãy để có thứ tự từ 1 đến n
        Collections.reverse(sequence);

        return sequence;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

