import java.util.Scanner;

public class Application {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String FILE_DIR =   "";

    public static void main(String[] args) {
        while (true) {
            display();
            System.out.println("Run: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    manualInput();
                    break;
                case 2:
                    values = fileInput();
                    break;
                case 3:
                    bublesort();
                    break;
                case 4:
                    selectionSort();
                    break;
                case 5:
                    insertionSort();
                case 6:
                    searchGreaterValues();
                case 7:
                    searchEqualValue();
                case 0:
                    break;
                default:
                    System.out.println("Please enter a valid option");

            }

        }


    }


    private static void display() {
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