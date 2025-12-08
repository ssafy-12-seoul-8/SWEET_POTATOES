import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[][] xa = new long[n][2];
    long total = 0;

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      xa[i][0] = Integer.parseInt(st.nextToken());
      xa[i][1] = Integer.parseInt(st.nextToken());
      total += xa[i][1];
    }

    long sum = 0;

    Arrays.sort(xa, Comparator.comparingLong(x -> x[0]));

    for (int i = 0; i < n; i++) {
      sum += xa[i][1];

      if (sum >= (total + 1) / 2) {
        System.out.println(xa[i][0]);

        return;
      }
    }
  }

}
