import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] a, b, c, d, latterSum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    Map<Integer, Integer> map = new HashMap<>();
    long count = 0;
    a = new int[n];
    b = new int[n];
    c = new int[n];
    d = new int[n];
    latterSum = new int[n * n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
      c[i] = Integer.parseInt(st.nextToken());
      d[i] = Integer.parseInt(st.nextToken());
    }

    int index = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        latterSum[index++] = c[i] + d[j];
      }
    }

    Arrays.sort(latterSum);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int formerSum = -(a[i] + b[j]);
        int lower = getLower(formerSum);
        int upper = getUpper(formerSum);
        count += upper - lower;
      }
    }

    System.out.println(count);
  }

  static int getLower(int number) {
    int left = 0;
    int right = latterSum.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (latterSum[mid] >= number) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  static int getUpper(int number) {
    int left = 0;
    int right = latterSum.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (latterSum[mid] <= number) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return left;
  }

}