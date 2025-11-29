import java.io.*;
import java.util.*;

public class Main {

  static String input;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input = br.readLine();
    dp = new int[input.length() + 1];

    Arrays.fill(dp, 2_500);

    dp[0] = 0;

    for (int i = 0; i < input.length(); i++) {
      findPal(i, i);
      findPal(i, i + 1);
    }

    System.out.println(dp[input.length()]);
  }

  static void findPal(int left, int right) {
    while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
      dp[right + 1] = Math.min(dp[right + 1], dp[left] + 1);
      left--;
      right++;
    }
  }

}
