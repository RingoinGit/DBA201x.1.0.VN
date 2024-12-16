import java.util.Formattable;
import java.util.Scanner;

public class FractionalKnapsack_12_2 {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
int lengh = values.length;
int[] vPerW = new int[lengh];
        for (int i = 0; i < lengh; i++) {
            vPerW[i] = values[i]/weights[i];
        }
        
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số Vật Phẩm: ");
        int n = scanner.nextInt();
        System.out.println("Sức chứa của túi: ");
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Giá trị vật phẩm %d: ", i + 1);
            values[i] = scanner.nextInt();
            System.out.printf("Trọng lượng vật phẩm %d: ", i + 1);
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 