import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] wines = new int[n + 1];
    int[][] dp = new int[n + 1][2];

    for (int i = 1; i <= n; i++) {
      wines[i] = Integer.parseInt(br.readLine());
    }

    dp[1][1] = wines[1];
    int max = wines[1];

    if (n >= 2) {
      dp[2][0] = wines[1];
      dp[2][1] = wines[1] + wines[2];
      max = Math.max(max, dp[2][1]);
    }

    for (int i = 3; i <= n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = Math.max(dp[i - 2][0] + wines[i - 1], dp[i - 1][0]) + wines[i];
      max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
    }

    System.out.println(max);
  }

}
