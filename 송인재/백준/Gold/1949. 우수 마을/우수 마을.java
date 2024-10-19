import java.io.*;
import java.util.*;

public class Main {

  static int[] pops;
  static Map<Integer, List<Integer>> tree;
  static boolean[] visited;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    pops = new int[n + 1];
    visited = new boolean[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      pops[i] = Integer.parseInt(st.nextToken());
    }

    tree = new HashMap<>();

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());

      tree.putIfAbsent(parent, new ArrayList<>());
      tree.putIfAbsent(child, new ArrayList<>());
      tree.get(parent)
          .add(child);
      tree.get(child)
          .add(parent);
    }

    dp = new int[n + 1][2];

    for (int i = 1; i <= n; i++) {
      dp[i][0] = pops[i];
    }

    dfs(0, 1);
    System.out.println(Math.max(dp[0][0], dp[0][1]));
  }

  static void dfs(int parent, int current) {
    visited[current] = true;

    if (tree.containsKey(current)) {
      for (int child : tree.get(current)) {
        if (visited[child]) {
          continue;
        }
        
        dfs(current, child);
      }
    }

    dp[parent][0] += dp[current][1];
    dp[parent][1] += Math.max(dp[current][0], dp[current][1]);
  }

}
