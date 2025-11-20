import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] liquids = new long[n];
    long[] answer = new long[3];
    long min = 3_000_000_001L;
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      liquids[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(liquids);

    for (int i = 0; i < n; i++) {
      long first = liquids[i];
      int left = i + 1;
      int right = n - 1;

      while (left < right) {
        long sum = first + liquids[left] + liquids[right];

        if (Math.abs(sum) < min) {
          min = Math.abs(sum);
          answer[0] = first;
          answer[1] = liquids[left];
          answer[2] = liquids[right];
        }

        if (sum == 0) {
          break;
        }

        if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for (long elem : answer) {
      sb.append(elem)
          .append(" ");
    }

    System.out.println(sb);
  }

}
