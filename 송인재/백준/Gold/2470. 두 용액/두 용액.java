import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    int first = 0;
    int second = 0;

    for (int i = 0; i < n - 1; i++) {
      int left = i + 1;
      int right = n - 1;

      while (left <= right && min != 0) {
        int mid = (left + right) / 2;
        int spec = nums[i] + nums[mid];

        if (Math.abs(spec) < min) {
          min = Math.abs(spec);
          first = nums[i];
          second = nums[mid];
        }

        if (spec < min) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    System.out.println(first + " " + second);
  }

}
