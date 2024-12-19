import java.util.*;

public class Knapsack_14_2 {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        //Tham khảo trên internet
        int length = w.length;
        int[][] result = new int[length + 1][W + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0; //thỏi vàng 0, sức nặng 0
                } else if (w[i - 1] <= j) {
                    //Thỏi vàng thứ i , có trọng lượng w[i - 1]
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - w[i    - 1]] + w[i-1]);
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        /*for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }*/
        return result[length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

