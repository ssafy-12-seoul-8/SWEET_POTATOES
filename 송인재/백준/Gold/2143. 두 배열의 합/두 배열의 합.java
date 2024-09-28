import java.util.*;
import java.io.*;

public class Main {

  static int t, n, m;
  static long count;
  static int[] a, b;
  static long[] sumA, sumB;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());
    n = Integer.parseInt(br.readLine());
    a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    m = Integer.parseInt(br.readLine());
    b = new int[m];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    sumA = new long[(n + 1) * n / 2];
    sumB = new long[(m + 1) * m / 2];
    sumA[0] = a[0];
    sumB[0] = b[0];
    int index = 0;

    for (int i = 0; i < n; i++) {
      sumA[index++] = a[i];

      for (int j = i + 1; j < n; j++) {
        sumA[index] = sumA[index - 1] + a[j];
        index++;
      }
    }

    index = 0;

    for (int i = 0; i < m; i++) {
      sumB[index++] = b[i];

      for (int j = i + 1; j < m; j++) {
        sumB[index] = sumB[index - 1] + b[j];
        index++;
      }
    }

    Arrays.sort(sumB);

    for (int i = 0; i < sumA.length; i++) {
      long difference = t - sumA[i];
      int upper = getUpper(difference);
      int lower = getLower(difference);
      count += upper - lower;
    }

    System.out.println(count);
  }

  static int getUpper(long target) {
    int left = 0;
    int right = sumB.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (sumB[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return left;
  }

  static int getLower(long target) {
    int left = 0;
    int right = sumB.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (sumB[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

}