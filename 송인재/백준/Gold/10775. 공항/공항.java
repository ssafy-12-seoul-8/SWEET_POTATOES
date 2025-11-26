import java.io.*;
import java.util.*;

public class Main {

  static int[] rep;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int g = Integer.parseInt(br.readLine());
    int p = Integer.parseInt(br.readLine());
    int[] gates = new int[p + 1];
    rep = new int[g + 1];

    for (int i = 1; i <= g; i++) {
      rep[i] = i;
    }

    for (int i = 1; i <= p; i++) {
      gates[i] = Integer.parseInt(br.readLine());
    }

    int count = 0;

    for (int i = 1; i <= p; i++) {
      int repI = find(gates[i]);

      if (repI == 0) {
        break;
      }

      union(repI, repI - 1);

      count = i;
    }

    System.out.println(count);
  }

  static int find(int x) {
    if (rep[x] != x) {
      rep[x] = find(rep[x]);
    }

    return rep[x];
  }

  static void union(int x, int y) {
    int repX = find(x);
    int repY = find(y);

    if (repX == repY) {
      return;
    }

    if (repY > repX) {
      rep[repY] = repX;
    } else {
      rep[repX] = repY;
    }
  }

}
