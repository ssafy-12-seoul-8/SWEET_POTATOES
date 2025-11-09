import java.io.*;
import java.util.*;

public class Main {

  static class Edge {
    int from;
    int to;
    int weight;

    Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }

  static int[] rep;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    List<Edge> edges = new ArrayList<>();
    rep = new int[n + 1];
    int sum = 0;
    int count = 0;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      edges.add(new Edge(from, to, weight));
    }

    for (int i = 1; i <= n; i++) {
      rep[i] = i;
    }

    edges.sort(Comparator.comparingInt(e -> e.weight));

    for (int i = 0; i < m; i++) {
      if (count == n - 2) {
        break;
      }
      
      Edge edge = edges.get(i);

      if (union(edge.from, edge.to)) {
        sum += edge.weight;
        count++;
      }
    }

    System.out.println(sum);
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
