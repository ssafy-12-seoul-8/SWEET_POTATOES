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

  static Map<Integer, List<Edge>> graph;
  static int[][] dist;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    dist = new int[n + 1][n + 1];

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph.putIfAbsent(from, new ArrayList<>());
      graph.get(from)
          .add(new Edge(to, weight));
    }

    for (int i = 1; i <= n; i++) {
      dijkstra(i);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        sb.append(dist[i][j] == 10_000_001 ? 0 : dist[i][j])
            .append(" ");
      }

      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static void dijkstra(int start) {
    int[] distances = new int[n + 1];
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

    Arrays.fill(distances, 10_000_001);

    pq.add(new int[] { start, 0 });

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int from = current[0];
      int distance = current[1];

      if (!graph.containsKey(from)) {
        continue;
      }

      for (Edge next : graph.get(from)) {
        int nextDistance = distance + next.weight;

        if (distances[next.to] <= nextDistance || next.to == start) {
          continue;
        }

        distances[next.to] = nextDistance;
        pq.add(new int[] { next.to, nextDistance });
      }
    }

    dist[start] = distances;
  }

}
