import java.io.*;
import java.util.*;

public class Main {

  static long sum;
  static int n;
  static long[][] vertices;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    vertices = new long[n][2];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      vertices[i][0] = Long.parseLong(st.nextToken());
      vertices[i][1] = Long.parseLong(st.nextToken());
    }

    calculate(vertices[0], 1);

    System.out.printf("%.1f", (Math.abs(sum) / 2D));
  }

  static void calculate(long[] a, int index) {
    if (index == n - 1) {
      return;
    }

    long[] b = vertices[index];
    long[] c = vertices[index + 1];
    sum += (a[0] * b[1] + b[0] * c[1] + c[0] * a[1]) - (b[0] * a[1] + c[0] * b[1] + a[0] * c[1]);

    calculate(a, index + 1);
  }

}
