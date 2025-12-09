import java.io.*;

public class Main {

  static int MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[][] dp = new long[Math.max(3, n + 1)][2];
    dp[1][0] = 2;
    dp[2][0] = 7;

    for (int i = 3; i <= n; i++) {
      dp[i][1] = dp[i - 1][1] + dp[i - 3][0] * 2;
      dp[i][1] %= MOD;
      dp[i][0] = dp[i - 1][0] * 2 + dp[i - 2][0] * 3 + dp[i][1] + 2;
      dp[i][0] %= MOD;
    }

    System.out.println(dp[n][0]);
  }
}
