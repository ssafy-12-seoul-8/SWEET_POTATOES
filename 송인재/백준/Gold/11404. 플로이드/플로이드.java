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

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    Map<Integer, List<Edge>> graph = new HashMap<>();
    int[][] distances = new int[n + 1][n + 1];

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
      Arrays.fill(distances[i], 10_000_001);
      distances[i][i] = 0;
    }

    for (int i = 1; i <= n; i++) {
      if (!graph.containsKey(i)) {
        continue;
      }

      for (Edge next : graph.get(i)) {
        if (distances[i][next.to] > next.weight) {
          distances[i][next.to] = next.weight;
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int k = 1; k <= n; k++) {
          distances[j][k] = Math.min(distances[j][k], distances[j][i] + distances[i][k]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (distances[i][j] == 10_000_001) {
          distances[i][j] = 0;
        }

        sb.append(distances[i][j])
            .append(" ");
      }

      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

}
