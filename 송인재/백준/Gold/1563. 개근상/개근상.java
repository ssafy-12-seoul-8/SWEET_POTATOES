import java.io.*;

public class Main {

  static int MOD = 1_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][][] dp = new int[n + 1][2][3];
    dp[0][0][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 3; j++) {
        dp[i][0][0] += dp[i - 1][0][j];
        dp[i][1][0] += dp[i - 1][1][j] + dp[i - 1][0][j];
        dp[i][0][0] %= MOD;
        dp[i][1][0] %= MOD;
      }

      for (int j = 0; j < 2; j++) {
        dp[i][j][1] += dp[i - 1][j][0];
        dp[i][j][2] += dp[i - 1][j][1];
        dp[i][j][1] %= MOD;
        dp[i][j][2] %= MOD;
      }
    }

    int total = 0;

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        total += dp[n][i][j];
        total %= MOD;
      }
    }

    System.out.print(total);
  }

}
