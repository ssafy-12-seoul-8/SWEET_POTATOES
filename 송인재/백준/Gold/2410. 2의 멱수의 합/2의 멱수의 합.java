import java.io.*;

public class Main {

  static int MOD = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1];

      if ((i & 1) == 0) {
        dp[i] += dp[i / 2];
        dp[i] %= MOD;
      }
    }

    System.out.println(dp[n]);
  }
}
