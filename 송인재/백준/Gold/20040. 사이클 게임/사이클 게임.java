import java.io.*;
import java.util.*;

public class Main {

  static int[] rep;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    rep = new int[n];
    int round = 0;

    for (int i = 0; i < n; i++) {
      rep[i] = i;
    }

    for (int i = 1; i <= m && round == 0; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (!union(x, y)) {
        round = i;
      }
    }

    System.out.println(round);
  }

  static int find(int x) {
    if (rep[x] != x) {
      rep[x] = find(rep[x]);
    }

    return rep[x];
  }

  static boolean union(int x, int y) {
    int repX = find(x);
    int repY = find(y);

    if (repX == repY) {
      return false;
    }

    rep[repY] = repX;

    return true;
  }

}
