import java.io.*;
import java.util.*;

public class Main {

  static Map<Integer, List<Integer>> graph;
  static long[] sheep;
  static int[] wolf;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    sheep = new long[n + 1];
    wolf = new int[n + 1];

    for (int i = 2; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char type = st.nextToken().charAt(0);
      int a = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      if (type == 'S') {
        sheep[i] += a;
      } else {
        wolf[i] += a;
      }

      graph.putIfAbsent(to, new ArrayList<>());
      graph.get(to)
          .add(i);
    }

    dfs(1);

    System.out.println(sheep[1]);
  }

  static void dfs(int parent) {
    if (!graph.containsKey(parent)) {
      return;
    }

    for (int child: graph.get(parent)) {
      dfs(child);

      sheep[parent] += sheep[child];
    }

    sheep[parent] = Math.max(0, sheep[parent] - wolf[parent]);
  }

}
