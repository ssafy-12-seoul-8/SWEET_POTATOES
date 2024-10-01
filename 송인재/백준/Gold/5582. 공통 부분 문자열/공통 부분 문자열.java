import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] first = br.readLine()
        .toCharArray();
    char[] second = br.readLine()
        .toCharArray();
    int[][] dp = new int[first.length + 1][second.length + 1];
    int max = 0;

    for (int i = 1; i <= first.length; i++) {
      for (int j = 1; j <= second.length; j++) {
        if (first[i - 1] != second[j - 1]) {
          continue;
        }
        
        dp[i][j] = dp[i - 1][j - 1] + 1;
        max = Math.max(max, dp[i][j]);
      }
    }

    System.out.println(max);
  }

}
