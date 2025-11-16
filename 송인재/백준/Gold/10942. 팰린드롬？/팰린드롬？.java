import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n + 1];
    int[][] dp = new int[n + 1][n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    int m = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      if (dp[from][to] != -1) {
        sb.append(dp[from][to])
            .append(System.lineSeparator());

        continue;
      }

      int isPal = 1;

      for (int j = from; j <= (from + to) / 2; j++) {
        if (nums[j] != nums[from + to - j]) {
          isPal = 0;

          break;
        }
      }

      sb.append(isPal)
          .append(System.lineSeparator());

      dp[from][to] = isPal;
    }

    System.out.print(sb);
  }

}
