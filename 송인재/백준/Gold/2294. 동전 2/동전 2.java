import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] coins = new int[n];

    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[k + 1];

    Arrays.fill(dp, Integer.MAX_VALUE - 1);

    dp[0] = 0;

    for (int i = 1; i <= k; i++) {
      for (int j = 0; j < n; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }

    System.out.println(dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[k]);
  }

}
