import java.io.*;
import java.util.*;

public class Main {

  static String input;
  static boolean[][] pal;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input = br.readLine();
    pal = new boolean[input.length()][input.length()];
    int[] dp = new int[input.length() + 1];

    for (int i = 0; i < input.length(); i++) {
      findPal(i, i);
      findPal(i, i + 1);
    }

    Arrays.fill(dp, 2_500);

    dp[0] = 0;

    for (int i = 0; i < input.length(); i++) {
      for (int j = 0; j <= i; j++) {
        if (pal[j][i]) {
          dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
        }
      }
    }

    System.out.println(dp[input.length()]);
  }

  static void findPal(int left, int right) {
    while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
      pal[left][right] = true;
      left--;
      right++;
    }
  }

}
