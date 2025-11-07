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

  static int INF = 1_000 * 100_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    Map<Integer, List<Edge>> graph = new HashMap<>();
    int[] dist = new int[n + 1];
    int[] visitFrom = new int[n + 1];
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

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

    Arrays.fill(dist, INF);
    pq.add(new int[] { start, 0 });

    dist[start] = 0;

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int from = current[0];
      int weight = current[1];

      if (dist[from] < weight || !graph.containsKey(from)) {
        continue;
      }

      for (Edge edge : graph.get(from)) {
        int nextWeight = weight + edge.weight;

        if (nextWeight >= dist[edge.to]) {
          continue;
        }

        dist[edge.to] = nextWeight;
        visitFrom[edge.to] = from;

        pq.add(new int[] { edge.to, nextWeight });
      }
    }

    List<Integer> visits = new ArrayList<>();
    int lastVisit = end;

    while (lastVisit > 0) {
      visits.add(lastVisit);

      lastVisit = visitFrom[lastVisit];
    }

    StringBuilder sb = new StringBuilder()
        .append(dist[end])
        .append(System.lineSeparator())
        .append(visits.size())
        .append(System.lineSeparator());

    for (int i = visits.size() - 1; i >= 0; i--) {
      sb.append(visits.get(i))
          .append(" ");
    }

    System.out.println(sb);
  }

}
