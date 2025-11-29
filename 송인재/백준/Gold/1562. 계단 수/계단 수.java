import java.io.*;
import java.util.*;

public class Main {

  static int MOD = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][][] dp = new int[n + 1][10][1 << 10];

    for (int i = 1; i <= 9; i++) {
      int state = 1 << i;
      dp[1][i][state] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int k = 0; k < (1 << 10); k++) {
          if (j > 0) {
            int next = j - 1;
            int nextState = k | (1 << next);
            dp[i + 1][next][nextState] += dp[i][j][k];
            dp[i + 1][next][nextState] %= MOD;
          }

          if (j < 9) {
            int next = j + 1;
            int nextState = k | (1 << next);
            dp[i + 1][next][nextState] += dp[i][j][k];
            dp[i + 1][next][nextState] %= MOD;
          }
        }
      }
    }

    int allVisited = (1 << 10) - 1;
    int sum = 0;

    for (int i = 0; i <= 9; i++) {
      sum += dp[n][i][allVisited];
      sum %= MOD;
    }

    System.out.println(sum);
  }

}
