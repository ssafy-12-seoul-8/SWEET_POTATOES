import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n][n];
    dp[0][0] = Integer.parseInt(br.readLine());
    int max = dp[0][0];

    for (int i = 1; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {
          dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i - 1][j];
        } else if (j == i) {
          dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i- 1][j - 1], dp[i - 1][j]) + Integer.parseInt(st.nextToken());
        }

        if (i == n - 1) {
          max = Math.max(max, dp[i][j]);
        }
      }
    }

    System.out.println(max);
  }

}