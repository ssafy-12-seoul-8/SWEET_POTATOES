import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int[] nums = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    int min = 100_000;

    for (int i = 1; i <= n; i++) {
      int num = Integer.parseInt(st.nextToken());
      nums[i] = nums[i - 1] + num;
    }

    if (nums[n] < s) {
      System.out.println(0);

      return;
    }

    int left = 0;
    int right = 0;

    while (right <= n) {
      if (nums[right] < nums[left] + s) {
        right++;
      } else {
        min = Math.min(min, right - left++);
      }
    }

    System.out.println(min);
  }

}
