public class Excercise_11 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Bài 1
    boolean isPrime(int n) {
        if (n ==2 || n == 3 || n == 5 || n == 7 || n == 11) return true;
        if (n < 2 || n%2 == 0 || n%3 == 0 || n%5 == 0 || n%7 == 0 || n%11 == 0) return false;
        double j = Math.sqrt(n);
        for (int i = 13; i <= j; i++)
            if (n%i == 0)
                return false;
        return true;
    }

    // Bài 2
    int factorSum(int n) {
        while (n != solve(n))
            n = solve(n);
        return n;
    }

    int solve(int n) {
        int sum = 0;
        int j = 2;
        while(n>1 ){
            if(isPrime(j)){
                while(n>1 && n%j == 0) {
                    sum += j;
                    n /= j;
                }
            }
            j++;
        }
        return sum;
    }

}