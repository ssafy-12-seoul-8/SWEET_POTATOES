import java.io.*;
import java.util.*;

public class Main {

  static int[] rep;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    rep = new int[n + 1];
    int[] candies = new int[n + 1];
    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      candies[i] = Integer.parseInt(st.nextToken());
      rep[i] = i;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      union(a, b);
    }

    Map<Integer, List<Integer>> friends = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      int repI = find(i);

      friends.putIfAbsent(repI, new ArrayList<>());
      friends.get(repI)
          .add(i);
    }

    int[][] dp = new int[friends.size() + 1][k];
    int[][] groups = new int[friends.size() + 1][2];
    int groupIndex = 1;

    for (int boss : friends.keySet()) {
      int kidCount = friends.get(boss)
          .size();
      int candyCount = 0;

      for (int kid : friends.get(boss)) {
        candyCount += candies[kid];
      }

      groups[groupIndex][0] = kidCount;
      groups[groupIndex][1] = candyCount;
      groupIndex++;
    }

    for (int i = 1; i < dp.length; i++) {
      int[] group = groups[i];

      for (int j = 1; j < k; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

        if (j >= group[0]) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - group[0]] + group[1]);
        }
      }
    }

    System.out.println(dp[dp.length - 1][k - 1]);
  }

  static int find(int x) {
    if (rep[x] != x) {
      rep[x] = find(rep[x]);
    }

    return rep[x];
  }

  static void union(int x, int y) {
    int repX = find(x);
    int repY = find(y);

    if (repX == repY) {
      return;
    }

    rep[repY] = repX;
  }

}
