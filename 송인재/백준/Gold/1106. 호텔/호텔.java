import java.io.*;
import java.util.*;

public class Main {

  static int MAX = 100_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int c = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[][] ad = new int[n + 1][2];
    int[][] dp = new int[n + 1][c + 1];

    Arrays.fill(dp[0], MAX);

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      ad[i][0] = Integer.parseInt(st.nextToken());
      ad[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= n; i++) {
      int[] city = ad[i];
      int cost = city[0];
      int customers = city[1];

      for (int j = 1; j <= c; j++) {
        dp[i][j] = ((int) Math.ceil(j / (double) customers)) * cost;
        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

        if (j >= customers) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j - customers] + cost);
        }
      }
    }

    System.out.println(dp[n][c]);
  }

}
