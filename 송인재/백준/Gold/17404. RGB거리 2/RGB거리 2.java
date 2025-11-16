import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] rgb = new int[n + 1][3];
    int min = 1_000_001;

    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      rgb[i][0] = Integer.parseInt(st.nextToken());
      rgb[i][1] = Integer.parseInt(st.nextToken());
      rgb[i][2] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < 3; i++) {
      int[][] dp = new int[n + 1][3];

      Arrays.fill(dp[1], 1_000_001);

      dp[1][i] = rgb[1][i];

      for (int j = 2; j <= n; j++) {
        dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + rgb[j][0];
        dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + rgb[j][1];
        dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + rgb[j][2];
      }

      for (int j = 0; j < 3; j++) {
        if (i == j) {
          continue;
        }

        min = Math.min(min, dp[n][j]);
      }
    }

    System.out.println(min);
  }

}
