import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] stuffs = new int[n + 1][2];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      stuffs[i][0] = Integer.parseInt(st.nextToken());
      stuffs[i][1] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[n + 1][k + 1];

    for (int i = 1; i <= n; i++) {
      int weight = stuffs[i][0];
      int value = stuffs[i][1];

      for (int j = 1; j <= k; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

        if (j >= weight) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight] + value);
        }
      }
    }

    System.out.println(dp[n][k]);
  }

}
