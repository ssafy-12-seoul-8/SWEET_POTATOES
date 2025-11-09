import java.io.*;
import java.util.*;

public class Main {

  static class Edge {
    int from;
    int to;

    Edge(int from, int to) {
      this.from = from;
      this.to = to;
    }
  }

  static int[] rep;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Map<Integer, List<Edge>> weights = new HashMap<>();
    int maxWeight = 0;
    rep = new int[n + 1];
    int sum = 0;
    int count = 0;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      maxWeight = Math.max(maxWeight, weight);

      weights.putIfAbsent(weight, new ArrayList<>());
      weights.get(weight)
          .add(new Edge(from, to));
    }

    for (int i = 1; i <= n; i++) {
      rep[i] = i;
    }

    for(int i = 1; i <= maxWeight; i++) {
      if (count == n - 2 || !weights.containsKey(i)) {
        continue;
      }

      for (Edge edge : weights.get(i)) {
        if (count == n - 2) {
          break;
        }

        if (union(edge.from, edge.to)) {
          sum += i;
          count++;
        }
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
