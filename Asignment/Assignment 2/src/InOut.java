import java.io.*;
import java.util.List;

public class InOut {

    // Đọc mảng từ tệp
    public static double[] readArrayFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            double[] array = new double[parts.length];
            for (int i = 0; i < parts.length; i++) {
                array[i] = Double.parseDouble(parts[i]);
            }
            return array;
        } catch (IOException e) {
            System.out.println("Lỗi đọc tệp: " + e.getMessage());
            return new double[0];
        }
    }

    // Hiển thị mảng double
    public static void printArray(double[] array) {
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Lưu mảng vào tệp
    public static void saveDoubleArr(String fileName, double[] array) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (double num : array) {
                bw.write(num + " ");
            }
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Lưu List Mảng Số Thực vào tệp
    public static void saveDoubleArrList(String fileName, List<Double[]> array) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Double[] arr : array) {
                for (double num : arr) {
                    bw.write(num + " ");
                }
                bw.newLine();
            }
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Lưu List Mảng Số Nguyên vào tệp
    public static void saveIntArrList(String fileName, List<Integer> array) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (int num : array) {
                bw.write(num + " ");
            }
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Lưu chuỗi vào tệp
    public static void saveString(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
