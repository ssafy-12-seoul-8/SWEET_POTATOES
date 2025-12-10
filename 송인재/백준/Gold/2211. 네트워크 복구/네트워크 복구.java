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

    @Override
    public String toString() {
      return "Edge{" +
          "to=" + to +
          ", weight=" + weight +
          '}';
    }

  }

  static int INF = 10_001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Map<Integer, List<Edge>> graph = new HashMap<>();
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    int[][] dist = new int[n + 1][2];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph.putIfAbsent(from, new ArrayList<>());
      graph.putIfAbsent(to, new ArrayList<>());
      graph.get(from)
          .add(new Edge(to, weight));
      graph.get(to)
          .add(new Edge(from, weight));
    }

    for (int i = 1; i <= n; i++) {
      dist[i][1] = INF;
    }

    pq.add(new int[] { 1, 0 });

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int node = current[0];
      int weight = current[1];

      if (!graph.containsKey(node) || dist[node][1] < weight) {
        continue;
      }

      for (Edge edge : graph.get(node)) {
        int nextWeight = weight + edge.weight;

        if (dist[edge.to][1] <= nextWeight) {
          continue;
        }

        dist[edge.to][0] = node;
        dist[edge.to][1] = nextWeight;

        pq.add(new int[]{ edge.to, nextWeight });
      }
    }

    StringBuilder sb = new StringBuilder()
        .append(n - 1)
        .append("\n");

    for (int i = 2; i <= n; i++) {
      sb.append(dist[i][0])
          .append(" ")
          .append(i)
          .append("\n");
    }

    System.out.print(sb);
  }

}
