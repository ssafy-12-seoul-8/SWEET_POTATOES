import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n + 1];
    int[] dp = new int[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= n; i++) {
      dp[i] = 1;

      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    
    int max = 0;
    
    for (int i = 0; i <= n; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }

}
