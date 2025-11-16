import java.io.*;
import java.util.*;

public class Main {

  static int[] nums;
  static int min = 100_000;
  static int s;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    nums = new int[n + 1];
    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      int num = Integer.parseInt(st.nextToken());
      nums[i] = nums[i - 1] + num;
    }

    if (nums[n] < s) {
      System.out.println(0);

      return;
    }

    for (int i = 1; i <= n; i++) {
      if (nums[i] < s) {
        continue;
      }

      lowerBound(i);
    }

    System.out.println(min);
  }

  static void lowerBound(int index) {
    int target = nums[index] - s;

    if (target < 0) {
      return;
    }

    int left = 0;
    int right = index - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    min = Math.min(min, index - right);
  }

}
