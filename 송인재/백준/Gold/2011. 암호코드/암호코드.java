import java.io.*;

public class Main {

  static int MOD = 1_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] code = br.readLine().toCharArray();
    int[] dp = new int[code.length + 1];
    dp[0] = 1;

    for (int i = 1; i <= code.length; i++) {
      if (code[i - 1] != '0') {
        dp[i] = dp[i - 1] % MOD;
      }

      if (i == 1 || code[i - 2] == '0') {
        continue;
      }

      int twoDigit = (code[i - 2] - '0') * 10 + (code[i - 1] - '0');

      if (twoDigit <= 26) {
        dp[i] += dp[i - 2];
        dp[i] %= MOD;
      }
    }

    System.out.println(dp[code.length]);
  }

}
