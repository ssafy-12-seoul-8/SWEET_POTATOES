import java.io.*;
import java.util.*;

public class Main {

  static int[] rep;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    rep = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      rep[i] = i;
    }

    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      rep[find(b)] = find(a);
    }

    int count = 0;

    for (int i = 2; i <= n; i++) {
      if (find(i) == find(1)) {
        count++;
      }
    }

    System.out.println(count);
  }

  static int find(int x) {
    if (rep[x] != x) {
      rep[x] = find(rep[x]);
    }

    return rep[x];
  }

}
