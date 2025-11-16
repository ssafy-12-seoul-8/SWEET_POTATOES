import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String first = br.readLine();
    String second = br.readLine();
    int[][] dp = new int[first.length() + 1][second.length() + 1];
    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 1; i <= first.length(); i++) {
      char firstChar = first.charAt(i - 1);

      for (int j = 1; j <= second.length(); j++) {
        char secondChar = second.charAt(j - 1);
        dp[i][j] = firstChar == secondChar ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    int length = dp[first.length()][second.length()];

    StringBuilder sb = new StringBuilder()
        .append(length)
        .append(System.lineSeparator());

    int row = first.length() - 1;
    int col = second.length() - 1;

    if (length == 0) {
      row = 0;
      col = 0;
    }

    while (row >= 0 && col >= 0) {
      if (first.charAt(row) == second.charAt(col)) {
        stack.push(first.charAt(row));

        row--;
        col--;

        continue;
      }

      if (dp[row + 1][col] > dp[row][col + 1]) {
        col--;
      } else {
        row--;
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    System.out.println(sb);
  }

}
