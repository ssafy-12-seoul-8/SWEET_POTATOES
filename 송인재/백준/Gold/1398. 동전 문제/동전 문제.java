import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    int[] dp = new int[100];
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 99; i++) {
      dp[i] = i;

      if (i >= 10) {
        dp[i] = Math.min(dp[i], dp[i - 10] + 1);
      }

      if (i >= 25) {
        dp[i] = Math.min(dp[i], dp[i - 25] + 1);
      }
    }

    for (int t = 1; t <= cases; t++) {
      long num = Long.parseLong(br.readLine());
      int total = 0;

      while (num > 0) {
        total += dp[(int) (num % 100)];
        num /= 100;
      }

      sb.append(total)
          .append("\n");
    }

    System.out.print(sb);
  }

}
