import java.io.*;
import java.util.*;

public class Main {

  static class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static int n;
  static Map<Integer, List<Edge>> graph;
  static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    max = 0;

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());

      while (true) {
        int to = Integer.parseInt(st.nextToken());

        if (to == -1) {
          break;
        }

        int weight = Integer.parseInt(st.nextToken());

        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from)
            .add(new Edge(to, weight));
      }
    }

    dfs(1, 0);

    System.out.println(max);
  }

  static int dfs(int current, int parent) {
    if (!graph.containsKey(current)) {
      return 0;
    }

    int firstMax = 0;
    int secondMax = 0;

    for (Edge edge : graph.get(current)) {
      if (edge.to == parent) {
        continue;
      }

      int subMax = dfs(edge.to, current) + edge.weight;

      if (subMax > firstMax) {
        secondMax = firstMax;
        firstMax = subMax;

        continue;
      }

      secondMax = Math.max(secondMax, subMax);
    }

    max = Math.max(max, firstMax + secondMax);

    return firstMax;
  }

}
