import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int[] operation;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    operation = new int[m];
    st = new StringTokenizer(br.readLine());
    long left = 0;
    long right = n * 30L;

    for (int i = 0; i < m; i++) {
      operation[i] = Integer.parseInt(st.nextToken());
    }

    if (n <= m) {
      System.out.println(n);

      return;
    }

    while (left <= right) {
      long mid = (left + right) / 2;

      if (isPossible(mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    int totalKids = m;

    for (int i = 0; i < m; i++) {
      totalKids += (int) (right / operation[i]);
    }

    int last = 0;

    for (int i = 0; i < m; i++) {
      if (left % operation[i] == 0) {
        totalKids++;
      }

      if (totalKids == n) {
        last = i + 1;
        break;
      }
    }

    System.out.println(last);
  }

  static boolean isPossible(long time) {
    long sum = m;

    for (int i = 0; i < m; i++) {
      sum += (int) (time / operation[i]);

      if (sum >= n) {
        return true;
      }
    }

    return false;
  }

}
