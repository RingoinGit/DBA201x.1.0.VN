import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class SortWithStep {
//Copy theo Link tham khảo
    static List<Double[]> bubble(double[] arr) {
        int i, j;
        int n = arr.length;
        double temp;
        boolean swapped;
        List<Double[]> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
            InOut.printArray(arr);
            result.add(DoubleStream.of(arr).boxed().toArray(Double[]::new));
        }
        return result;
    }

    static List<Double[]> selection(double[] arr) {
        int n = arr.length;
        double temp;
        List<Double[]> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {

            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            if (min_idx != i) {
                temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
                InOut.printArray(arr);
                result.add(DoubleStream.of(arr).boxed().toArray(Double[]::new));
            }

        }
        return result;
    }

    static List<Double[]> insert(double[] arr) {
        int n = arr.length;
        List<Double[]> result = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            double key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            InOut.printArray(arr);
            result.add(DoubleStream.of(arr).boxed().toArray(Double[]::new));
        }
        return result;
    }

}
