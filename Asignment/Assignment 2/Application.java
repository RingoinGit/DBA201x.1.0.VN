import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Application {

    public static final String INPUT_TXT = "INPUT.TXT";
    public static final String OUTPUT1_TXT = "OUTPUT1.TXT";
    public static final String OUTPUT2_TXT = "OUTPUT2.TXT";
    public static final String OUTPUT3_TXT = "OUTPUT3.TXT";
    public static final String OUTPUT4_TXT = "OUTPUT4.TXT";
    public static final String OUTPUT5_TXT = "OUTPUT5.TXT";

    private static double[] a; // Mảng lưu dữ liệu
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = SCANNER.nextInt();
            SCANNER.nextLine(); // Đọc bỏ dòng mới

            switch (choice) {
                case 1:
                    manualInput();
                    break;
                case 2:
                    fileInput();
                    break;
                case 3:
                    bubbleSort();
                    break;
                case 4:
                    selectionSort();
                    break;
                case 5:
                    insertionSort();
                    break;
                case 6:
                    linearSearch();
                    break;
                case 7:
                    binarySearch();
                    break;
                case 0:
                    System.out.println("Thanks!!!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Chức năng 1: Nhập dữ liệu từ bàn phím
    private static void manualInput() {
        System.out.println("Choice 1: Manual Input");
        System.out.print("Please enter the number of elements: ");
        int n = SCANNER.nextInt();
        a = new double[n];
        System.out.print("Please enter the elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = SCANNER.nextDouble();
        }
        InOut.saveDoubleArr(INPUT_TXT, a);
        System.out.println("Data saved to " + INPUT_TXT);
    }

    // Chức năng 2: Đọc dữ liệu từ tệp
    private static void fileInput() {
        System.out.println("Choice 2: File input");
        System.out.print("Please enter the file path: ");
        String filePath = SCANNER.nextLine();
        a = InOut.readArrayFromFile(filePath);
        if (a != null) {
            System.out.print("Input array: ");
            InOut.printArray(a);
        }
    }

    // Chức năng 3: Sắp xếp bằng Bubble Sort
    private static void bubbleSort() {
        System.out.println("Choice 3: Bubble sort");
        if (a == null) {
            System.out.println("No data available. Please input data first.");
            return;
        }
        double[] b = Arrays.copyOf(a, a.length);
        InOut.saveDoubleArrList(OUTPUT1_TXT, SortWithStep.bubble(b));
    }


    // Chức năng 4: Sắp xếp bằng Selection Sort
    private static void selectionSort() {
        System.out.println("Choice 4: Selection sort");
        if (a == null) {
            System.out.println("No data available. Please input data first.");
            return;
        }
        double[] b = Arrays.copyOf(a, a.length);
        InOut.saveDoubleArrList(OUTPUT2_TXT, SortWithStep.selection(b));
    }

    // Chức năng 5: Sắp xếp bằng Insertion Sort
    private static void insertionSort() {
        System.out.println("Choice 5: Insertion sort");
        if (Application.a == null) {
            System.out.println("No data available. Please input data first.");
            return;
        }
        double[] b = Arrays.copyOf(a, a.length);
        InOut.saveDoubleArrList(OUTPUT3_TXT, SortWithStep.insert(b));
    }

    // Chức năng 6: Tìm kiếm tuần tự
    private static void linearSearch() {
        System.out.println("Choice 6: Linear Search");
        if (a == null) {
            System.out.println("No data available. Please input data first.");
            return;
        }
        System.out.print("Please enter the searched value: ");
        double value = SCANNER.nextDouble();
        List<Integer> indices = new ArrayList<>();
        indices = Search.lagerValueLinear(a, value);
        if (indices.isEmpty()) {
            System.out.println("There is no value that satisfies the condition.");
        } else {
            System.out.print("Larger position: ");
            for (int i : indices) {
                System.out.print(i + " ");
            }
            System.out.println();
            InOut.saveIntArrList(OUTPUT4_TXT, indices);
        }
    }

    // Chức năng 7: Tìm kiếm nhị phân
    private static void binarySearch() {
        System.out.println("Choice 7: Binary Search");
        if (a == null) {
            System.out.println("No data available. Please input data first.");
            return;
        }
        double[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        System.out.print("Please enter the searched value: ");
        double value = SCANNER.nextDouble();
        int index = Search.firstValueBinary(b, value);
        if (index >= 0) {
            InOut.saveString(OUTPUT5_TXT,Integer.toString(index));
            System.out.println("The right position: " + index);
        } else {
            System.out.println("The value does not exist!");
        }
    }

    private static void displayMenu() {
        System.out.println(MENU_TEXT);
    }

    private static final String MENU_TEXT = """
            +-------------------Menu------------------+
            
            |      1.Manual Input                     |
            
            |      2.File input                       |
            
            |      3.Bubble sort                      |
            
            |      4.Selection sort                   |
            
            |      5.Insertion sort                   |
            
            |      6.Search > value                   |
            
            |      7.Search = value                   |
            
            |      0.Exit                             |
            
            +-----------------------------------------.+""";


}