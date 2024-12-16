import java.util.*;

public class FibonacciLastDigit_11_2 {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current ;
            current = (tmp_previous + current) % 10; // start code : current = (tmp_previous + current)
        }

        return current; // start code return curent%10
    }
    
    public static void main(String[] args) {
        System.out.println("Nhập vào thứ tự số fibonacci :  ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

