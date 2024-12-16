import java.util.Scanner;

public class DoiTien_12_1 {
    private static int getChange(int m) {
        //write your code here
        int n = m/10;
        m = m%10;
        n += m/5;
        m = m%5;
        n += m;
        m = n;
        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
