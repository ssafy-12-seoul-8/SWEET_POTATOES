import java.io.*;
import java.util.*;

public class Main {

  static Map<Integer, List<Integer>> graph;
  static boolean[] visited;
  static Deque<Integer> stack;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    visited = new boolean[n + 1];
    stack = new ArrayDeque<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int front = Integer.parseInt(st.nextToken());
      int back = Integer.parseInt(st.nextToken());

      graph.putIfAbsent(front, new ArrayList<>());
      graph.get(front)
          .add(back);
    }

    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs(i);
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      sb.append(stack.pop())
          .append(" ");
    }

    System.out.println(sb);
  }

  static void dfs(int current) {
    visited[current] = true;

    if (graph.containsKey(current)) {
      for (int next : graph.get(current)) {
        if (visited[next]) {
          continue;
        }

        dfs(next);
      }
    }

    stack.push(current);
  }

}
