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

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int t = 0; t < tc; t++) {
      List<Edge> edges = new ArrayList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        edges.add(new Edge(from, to, weight));
        edges.add(new Edge(to, from, weight));
      }

      for (int i = 0; i < w; i++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        edges.add(new Edge(from, to, -weight));
      }

      int[] dist = new int[n + 1];

      for (int i = 0; i < n - 1; i++) {
        boolean isUpdated = false;

        for (Edge edge : edges) {
          if (dist[edge.to] > dist[edge.from] + edge.weight) {
            dist[edge.to] = dist[edge.from] + edge.weight;
            isUpdated = true;
          }
        }

        if (!isUpdated) {
          break;
        }
      }

      boolean hasNegative = false;

      for (Edge edge : edges) {
        if (dist[edge.to] > dist[edge.from] + edge.weight) {
          hasNegative = true;

          break;
        }
      }

      sb.append(hasNegative ? "YES" : "NO")
          .append(System.lineSeparator());
    }

    System.out.print(sb);
  }

}
