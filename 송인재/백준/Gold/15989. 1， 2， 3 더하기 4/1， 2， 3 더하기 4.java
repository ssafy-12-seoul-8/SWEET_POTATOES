import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    int[] dp = new int[10_001];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= 10_000; i++) {
      dp[i] = 1 + dp[i - 2];
    }

    for (int i = 3; i <= 10_000; i++) {
      dp[i] += dp[i - 3];
    }

    StringBuilder sb = new StringBuilder();

    for (int t = 0; t < cases; t++) {
      int n = Integer.parseInt(br.readLine());

      sb.append(dp[n])
          .append("\n");
    }

    System.out.print(sb);
  }

}
