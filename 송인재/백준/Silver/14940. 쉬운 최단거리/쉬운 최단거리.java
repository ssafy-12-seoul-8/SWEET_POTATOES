import java.util.*;
import java.io.*;

public class Main {
  static int[] dr = { -1, 0, 1, 0 };
  static int[] dc = { 0, 1, 0, -1 };
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];
    int[][] distance = new int[n][m];
    int[] start = new int[3];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 2) {
          start[0] = i;
          start[1] = j;
        }
      }
    }

    boolean[][] visited = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    visited[start[0]][start[1]] = true;
    distance[start[0]][start[1]] = start[2];

    queue.add(start);

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int row = curr[0];
      int col = curr[1];
      int dist = curr[2];

      for (int i = 0; i < 4; i++) {
        int newRow = row + dr[i];
        int newCol = col + dc[i];

        if (!isInMap(newRow, newCol) || visited[newRow][newCol] || map[newRow][newCol] == 0) {
          continue;
        }

        visited[newRow][newCol] = true;
        distance[newRow][newCol] = dist + 1;

        queue.add(new int[] { newRow, newCol, dist + 1 });
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 1 && distance[i][j] == 0) {
          distance[i][j] = -1;
        }

        sb.append(distance[i][j]).append(" ");
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }

  static boolean isInMap(int row, int col) {
    return row >= 0
        && row < n
        && col >= 0
        && col < m;
  }
}