import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long[] dp = new long[64 - Long.numberOfLeadingZeros(b) + 1];

    for (int i = 1; i < dp.length; i++) {
      long twoPower = 1L << (i - 1);
      dp[i] = 2 * dp[i - 1] + twoPower;
    }

    System.out.println(countOnes(b, dp) - countOnes(a - 1, dp));
  }

  static long countOnes(long num, long[] dp) {
    if (num == 0) {
      return 0;
    }

    long maxTwoPower = Long.highestOneBit(num);
    int maxBit = Long.numberOfTrailingZeros(maxTwoPower);

    return dp[maxBit] + num - maxTwoPower + 1 + countOnes(num - maxTwoPower, dp);
  }

}
