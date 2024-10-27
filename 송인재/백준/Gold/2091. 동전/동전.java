import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] coins = { 1, 5, 10, 25 };
    int[] maxCoins = new int[4];
    int[] maxValue = new int[4];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    maxCoins[0] = Integer.parseInt(st.nextToken());
    maxCoins[1] = Integer.parseInt(st.nextToken());
    maxCoins[2] = Integer.parseInt(st.nextToken());
    maxCoins[3] = Integer.parseInt(st.nextToken());
    maxValue[0] = Math.min(maxCoins[0], k);
    int[][] dp = new int[k + 1][5];

    for (int i = 1; i <= maxValue[0]; i++) {
      dp[i][0] = i;
      dp[i][4] = i;
    }

    for (int i = 1; i <= 3; i++) {
      maxValue[i] = Math.min(maxValue[i - 1] + coins[i] * maxCoins[i], k);
    }

    for (int i = 1; i < 4; i++) {
      int start = i == 3 ? 25 : maxValue[i - 1];

      for (int j = start; j <= maxValue[i]; j++) {
        if (j < coins[i] || dp[j][4] >= dp[j - coins[i]][4] + 1) {
          continue;
        }

        if (dp[j - coins[i]][4] == 0) {
          if (j % coins[i] == 0) {
            dp[j][i] = j / coins[i];
            dp[j][4] = j / coins[i];
          }

          continue;
        }

        dp[j] = Arrays.copyOf(dp[j - coins[i]], 5);
        dp[j][i]++;
        dp[j][4]++;
      }
    }

    System.out.println(dp[k][0] + " " + dp[k][1] + " " + dp[k][2] + " " + dp[k][3]);
  }

}