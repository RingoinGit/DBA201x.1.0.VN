import java.util.Scanner;

public class Fibonacci_11_1 {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  public static void main(String args[]) {
    System.out.println("Nhập vào thứ tự số fibonacci :  ");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
