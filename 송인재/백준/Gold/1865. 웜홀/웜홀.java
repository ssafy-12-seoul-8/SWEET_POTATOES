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

  static int INF = 25_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int t = 1; t <= cases; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      int[][] dp = new int[n + 1][n + 1];
      Map<Integer, List<Edge>> graph = new HashMap<>();

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

      for (int i = 0; i < w; i++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from)
            .add(new Edge(to, -weight));
      }

      for (int[] row : dp) {
        Arrays.fill(row, INF);
      }

      for (int i = 1; i <= n; i++) {
        if (!graph.containsKey(i)) {
          continue;
        }

        for (Edge edge : graph.get(i)) {
          if (dp[i][edge.to] > edge.weight) {
            dp[i][edge.to] = edge.weight;
          }
        }
      }

      for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= n; j++) {
            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
          }
        }
      }

      sb.append(isPossible(n, dp))
          .append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static String isPossible(int n, int[][] dp) {
    for (int i = 1; i <= n; i++) {
      if (dp[i][i] < 0) {
        return "YES";
      }
    }

    return "NO";
  }

}
