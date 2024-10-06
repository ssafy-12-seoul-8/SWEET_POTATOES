import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n];
    Map<Integer, Integer> map = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int[] sorted = Arrays.copyOf(nums, n);

    Arrays.sort(sorted);

    int count = 0;

    for (int i = 0; i < n; i++) {
      if (!map.containsKey(sorted[i])) {
        map.put(sorted[i], count);
        count++;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      sb.append(map.get(nums[i]))
          .append(" ");
    }

    System.out.println(sb);
  }

}
