import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = { -1, 0, 1, 0 };
  static int[] dc = { 0, 1, 0, -1 };
  static int n, m, k;
  static boolean[][] map, visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());

    for (int t = 1; t <= cases; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      map = new boolean[n][m];
      visited = new boolean[n][m];

      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        map[row][col] = true;
      }

      int count = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (map[i][j] && !visited[i][j]) {
            dfs(i, j);

            count++;
          }
        }
      }

      System.out.println(count);
    }
  }

  static void dfs(int row, int col) {
    visited[row][col] = true;

    for (int i = 0; i < 4; i++) {
      int newRow = row + dr[i];
      int newCol = col + dc[i];

      if (!isInMap(newRow, newCol) || !map[newRow][newCol] || visited[newRow][newCol]) {
        continue;
      }

      dfs(newRow, newCol);
    }
  }

  static boolean isInMap(int row, int col) {
    return row >= 0
        && row < n
        && col >= 0
        && col < m;
  }

}
