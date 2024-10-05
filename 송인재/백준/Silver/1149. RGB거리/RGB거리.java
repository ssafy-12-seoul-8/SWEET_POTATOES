import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n + 1][3];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int red = Integer.parseInt(st.nextToken());
    int green = Integer.parseInt(st.nextToken());
    int blue = Integer.parseInt(st.nextToken());
    dp[1][0] = red;
    dp[1][1] = green;
    dp[1][2] = blue;

    for (int i = 2; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      red = Integer.parseInt(st.nextToken());
      green = Integer.parseInt(st.nextToken());
      blue = Integer.parseInt(st.nextToken());
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green;
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;
    }

    System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
  }

}
