import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        BigInteger result = fibo(n);
        System.out.println(result);
    }
    
    static BigInteger fibo(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return BigInteger.ONE;
        }
        
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;
        dp[3] = BigInteger.ONE;

        for (int i = 4; i <= n; i++)
            dp[i] = dp[i - 1].add(dp[i - 3]);

        return dp[n];
    }
}