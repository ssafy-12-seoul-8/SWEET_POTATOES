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
  static int max;
  static Map<Integer, List<Edge>> graph;
  static Queue<int[]> pq;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    max = 0;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph.putIfAbsent(from, new ArrayList<>());
      graph.get(from)
          .add(new Edge(to, weight));
    }

    int[] fromX = dijkstra(x);
    int max = 0;

    for (int i = 1; i <= n; i++) {
      if (i == x) {
        continue;
      }

      int[] fromI = dijkstra(i);
      max = Math.max(max, fromI[x] + fromX[i]);
    }

    System.out.println(max);
  }

  static int[] dijkstra(int start) {
    int[] distances = new int[n + 1];

    Arrays.fill(distances, 100_000);
    pq.add(new int[] { start, 0 });

    distances[start] = 0;

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int from = current[0];
      int weight = current[1];

      if (!graph.containsKey(from)) {
        continue;
      }

      for (Edge next : graph.get(from)) {
        int nextWeight = weight + next.weight;

        if (distances[next.to] <= nextWeight) {
          continue;
        }

        distances[next.to] = nextWeight;

        pq.add(new int[] { next.to, nextWeight });
      }
    }

    return distances;
  }

}
