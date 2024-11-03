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

  static int n, m;
  static int[] weights;
  static Map<Integer, List<Edge>> graph = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    weights = new int[n + 1];

    Arrays.fill(weights, Integer.MAX_VALUE);

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph.putIfAbsent(from, new ArrayList<>());
      graph.get(from)
          .add(new Edge(to, weight));
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    dijkstra(start);
    System.out.println(weights[end]);
  }

  static void dijkstra(int start) {
    weights[start] = 0;
    Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

    pq.add(new Edge(start, 0));

    while (!pq.isEmpty()) {
      Edge current = pq.poll();

      if (!graph.containsKey(current.to) || current.weight > weights[current.to]) {
        continue;
      }

      for (Edge child : graph.get(current.to)) {
        int nextWeight = current.weight + child.weight;

        if (weights[child.to] > nextWeight) {
          weights[child.to] = nextWeight;

          pq.add(new Edge(child.to, nextWeight));
        }
      }
    }
  }

}