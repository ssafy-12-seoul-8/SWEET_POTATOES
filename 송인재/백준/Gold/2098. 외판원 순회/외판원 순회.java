import java.io.*;
import java.util.*;

public class Main {

  static int INF = 17_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] w = new int[n][n];
    int[][] dp = new int[1 << n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        w[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int[] cities : dp) {
      Arrays.fill(cities, INF);
    }

    dp[1][0] = 0;

    for (int i = 0; i < (1 << n); i++) {
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) == 0 || dp[i][j] == INF) {
          continue;
        }

        for (int k = 0; k < n; k++) {
          if (w[j][k] == 0 || (i & (1 << k)) != 0) {
            continue;
          }

          int nextState = i | (1 << k);
          dp[nextState][k] = Math.min(dp[nextState][k], dp[i][j] + w[j][k]);
        }
      }
    }

    int allVisited = (1 << n) - 1;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      if (w[i][0] == 0) {
        continue;
      }

      min = Math.min(min, dp[allVisited][i] + w[i][0]);
    }

    System.out.println(min);
  }

}
