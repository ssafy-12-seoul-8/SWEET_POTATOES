import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());
    int[] b = new int[m];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    int aIndex = 0;
    int bIndex = 0;
    List<Integer> common = new ArrayList<>();
    int largest = 1;

    while (largest > 0) {
      largest = findCommonMax(a, b, aIndex, bIndex);

      if (largest != 0) {
        common.add(largest);
      }

      aIndex = findFirstIndex(a, largest, aIndex) + 1;
      bIndex = findFirstIndex(b, largest, bIndex) + 1;
    }

    StringBuilder sb = new StringBuilder()
        .append(common.size())
        .append(System.lineSeparator());

    for (int element : common) {
      sb.append(element)
          .append(" ");
    }

    System.out.print(sb);
  }

  static int findCommonMax(int[] a, int[] b, int aIndex, int bIndex) {
    int max = 0;

    for (int i = aIndex; i < a.length; i++) {
      for (int j = bIndex; j < b.length; j++) {
        if (a[i] == b[j]) {
          max = Math.max(max, a[i]);
        }
      }
    }

    return max;
  }

  static int findFirstIndex(int[] arr, int number, int start) {
    for (int i = start; i < arr.length; i++) {
      if (arr[i] == number) {
        return i;
      }
    }

    return arr.length;
  }

}
