import java.io.*;
import java.util.*;

public class Main {

  static boolean[][] dp;
  static int n;
  static int[] nums;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    nums = new int[n + 1];
    dp = new boolean[n + 1][n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= n; i++) {
      findPal(i, i);
      findPal(i, i + 1);
    }

    int m = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      sb.append(dp[from][to] ? 1 : 0)
          .append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static void findPal(int left, int right) {
    while (left > 0 && right <= n && nums[left] == nums[right]) {
      dp[left][right] = true;
      left--;
      right++;
    }
  }

}
