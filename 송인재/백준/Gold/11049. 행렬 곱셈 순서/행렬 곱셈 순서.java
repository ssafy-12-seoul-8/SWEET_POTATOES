import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dimensions = new int[n + 1];
    int[][] dp = new int[n + 1][n + 1];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      dimensions[i] = Integer.parseInt(st.nextToken());
      dimensions[i + 1] = Integer.parseInt(st.nextToken());
    }

    for (int l = 1; l < n; l++) {
      for (int i = 1; i <= n - l; i++) {
        int j = i + l;
        dp[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
          int addOn = dimensions[i - 1] * dimensions[k] * dimensions[j];
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + addOn);
        }
      }
    }

    System.out.println(dp[1][n]);
  }

}
