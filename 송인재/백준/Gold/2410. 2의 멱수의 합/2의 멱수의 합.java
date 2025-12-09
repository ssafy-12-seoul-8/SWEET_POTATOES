import java.io.*;

public class Main {

  static int MOD = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[n + 1];
    int num = 1;
    dp[0] = 1;

    while (num <= n) {
      for (int i = num; i <= n; i++) {
        dp[i] += dp[i - num];
        dp[i] %= MOD;
      }

      num *= 2;
    }

    System.out.println(dp[n]);
  }
}
