import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n + 1];
    int max = 0;
    int[] scores = new int[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, nums[i]);
    }

    int[] index = new int[max + 1];

    for (int i = 1; i <= n; i++) {
      index[nums[i]] = i;
    }

    for (int i = 1; i <= max; i++) {
      if (index[i] == 0) {
        continue;
      }

      for (int j = i * 2; j <= max; j += i) {
        if (index[j] == 0 || j % i != 0) {
          continue;
        }

        scores[index[i]]++;
        scores[index[j]]--;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      sb.append(scores[i])
          .append(" ");
    }

    System.out.println(sb);
  }

}
