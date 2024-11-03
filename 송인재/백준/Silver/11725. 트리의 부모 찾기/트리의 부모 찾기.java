import java.io.*;
import java.util.*;

public class Main {

  static int[] parents;
  static boolean[] visited;
  static Map<Integer, List<Integer>> graph = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    visited = new boolean[n + 1];
    parents = new int[n + 1];

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      graph.putIfAbsent(first, new ArrayList<>());
      graph.putIfAbsent(second, new ArrayList<>());
      graph.get(first)
          .add(second);
      graph.get(second)
          .add(first);
    }

    dfs(1);

    StringBuilder sb = new StringBuilder();

    for (int i = 2; i <= n; i++) {
      sb.append(parents[i])
          .append("\n");
    }

    System.out.print(sb);
  }

  static void dfs(int parent) {
    visited[parent] = true;

    if (!graph.containsKey(parent)) {
      return;
    }

    for (int child : graph.get(parent)) {
      if (visited[child]) {
        continue;
      }

      parents[child] = parent;

      dfs(child);
    }
  }

}