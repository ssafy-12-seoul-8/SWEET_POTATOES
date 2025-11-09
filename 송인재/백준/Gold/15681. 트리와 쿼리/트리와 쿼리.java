import java.io.*;
import java.util.*;

public class Main {

  static int[] count;
  static Map<Integer, List<Integer>> tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    count = new int[n + 1];
    tree = new HashMap<>();

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      tree.putIfAbsent(u, new ArrayList<>());
      tree.putIfAbsent(v, new ArrayList<>());
      tree.get(u)
          .add(v);
      tree.get(v)
          .add(u);
    }

    dfs(r, 0);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < q; i++) {
      int u = Integer.parseInt(br.readLine());

      sb.append(count[u])
          .append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static int dfs(int current, int parent) {
    int sum = 1;

    for (int child : tree.get(current)) {
      if (child == parent) {
        continue;
      }

      sum += dfs(child, current);
    }

    count[current] = sum;

    return sum;
  }

}
