import com.sun.source.tree.DoWhileLoopTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack_12_2 {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0.0;
        int valableCapa = capacity;
        //write your code here
        int lengh = values.length;
        double[][] vPerW = new double[lengh][3];
        for (int i = 0; i < lengh; i++) {
            vPerW[i][0] = values[i];
            vPerW[i][1] = weights[i];
            vPerW[i][2] = (values[i] * 1.0000 / weights[i]);
        }
        Arrays.sort(vPerW, Comparator.comparingDouble(a -> a[2]));
        for (int i = lengh - 1; i >= 0 && valableCapa > 0; i--) {
            if (valableCapa >= vPerW[i][1]) {
                value += vPerW[i][0];
                valableCapa -= vPerW[i][1];
            } else {
                double ratio = valableCapa/vPerW[i][1];
                value += (ratio * vPerW[i][0]);
                break;
            }
        }
        return Math.round(value * 10000.0) / 10000.0;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 