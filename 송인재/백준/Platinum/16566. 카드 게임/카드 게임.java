import java.io.*;
import java.util.*;

public class Main {

  static int[] actual;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] ms = new int[m];
    int[] cs = new int[k];
    actual = new int[m + 1];
    StringBuilder sb = new StringBuilder();
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      ms[i] = Integer.parseInt(st.nextToken());
      actual[i] = i;
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < k; i++) {
      cs[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(ms);

    for (int i = 0; i < k; i++) {
      int card = cs[i];
      int left = 0;
      int right = m - 1;

      while (left <= right) {
        int mid = (left + right) / 2;

        if (ms[mid] <= card) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      int actualIndex = find(left);

      sb.append(ms[actualIndex])
          .append(System.lineSeparator());

      union(actualIndex + 1, actualIndex);
    }

    System.out.print(sb);
  }

  static int find(int x) {
    if (actual[x] != x) {
      actual[x] = find(actual[x]);
    }

    return actual[x];
  }

  static void union(int x, int y) {
    int actualX = find(x);
    int actualY = find(y);

    if (actualX == actualY) {
      return;
    }

    actual[actualY] = actualX;
  }

}
