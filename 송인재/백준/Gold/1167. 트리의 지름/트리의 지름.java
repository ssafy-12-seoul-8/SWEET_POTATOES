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
  static Queue<int[]> pq;
  static int INF = 100_000 * 10_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

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

    int[] first = dijkstra(1);
    int[] second = dijkstra(first[1]);

    System.out.println(second[0]);
  }

  static int[] dijkstra(int start) {
    int[] dist = new int[n + 1];

    Arrays.fill(dist, INF);
    pq.add(new int[] { start, 0 });

    dist[start] = 0;

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int from = current[0];
      int weight = current[1];

      if (weight > dist[from] || !graph.containsKey(from)) {
        continue;
      }

      for (Edge edge : graph.get(from)) {
        int nextWeight = weight + edge.weight;

        if (dist[edge.to] <= nextWeight) {
          continue;
        }

        dist[edge.to] = nextWeight;

        pq.add(new int[] { edge.to, nextWeight });
      }
    }

    int max = 0;
    int maxIndex = 0;

    for (int i = 1; i <= n; i++) {
      if (i == start) {
        continue;
      }

      if (max < dist[i]) {
        max = dist[i];
        maxIndex = i;
      }
    }

    return new int[] { max, maxIndex };
  }

}
