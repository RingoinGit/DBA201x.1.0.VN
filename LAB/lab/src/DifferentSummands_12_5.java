import java.util.*;

public class DifferentSummands_12_5 {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int sum = 0; //Tổng của dãy số
        int number = 1; //Số hạng
        //Cộng dồn sum cho đến khi tổng <= n
        while (sum + number <= n) {
            sum += number;
            summands.add(number++);
        }
        //nếu sum + number > n thì xét n - sum và cộng vào phần tử cuối
        int lastNumber = summands.get(summands.size() - 1);
        summands.set(summands.size() - 1, lastNumber + (n - sum));
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

