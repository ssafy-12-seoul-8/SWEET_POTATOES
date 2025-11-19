import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[][][] dp = new int[st.countTokens()][5][5];
    int[] steps = new int[st.countTokens() - 1];

    for (int i = 0; i < steps.length; i++) {
      steps[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = steps.length - 1; i >= 0; i--) {
      int step = steps[i];

      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
          int left = dp[i + 1][j][step] + calculate(k, step);
          int right = dp[i + 1][step][k] + calculate(j, step);
          dp[i][j][k] = Math.min(left, right);
        }
      }
    }

    System.out.println(dp[0][0][0]);
  }

  static int calculate(int from, int to) {
    if (from == 0) {
      return 2;
    }

    if (from == to) {
      return 1;
    }

    return Math.abs(from - to) == 2 ? 4 : 3;
  }

}
