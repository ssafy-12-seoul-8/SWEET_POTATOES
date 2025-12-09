import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int m;
  static int[][] map;
  static int[][] prefix;
  static boolean[][] visited;
  static int[] dest;
  static int[] hw;
  static int[] dr = { -1, 0, 1, 0 };
  static int[] dc = { 0, -1, 0, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    prefix = new int[n + 1][m + 1];
    visited = new boolean[n][m];
    dest = new int[2];
    hw = new int[2];
    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        prefix[i][j] = map[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
      }
    }

    st = new StringTokenizer(br.readLine());
    hw[0] = Integer.parseInt(st.nextToken()) - 1;
    hw[1] = Integer.parseInt(st.nextToken()) - 1;
    int r = Integer.parseInt(st.nextToken()) - 1;
    int c = Integer.parseInt(st.nextToken()) - 1;
    dest[0] = Integer.parseInt(st.nextToken()) - 1;
    dest[1] = Integer.parseInt(st.nextToken()) - 1;
    int max = 0;
    visited[r][c] = true;

    queue.add(new int[]{ r, c, 0 });

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int row = current[0];
      int col = current[1];

      for (int i = 0; i < 4; i++) {
        int rowStart = row + dr[i];
        int rowEnd = rowStart + hw[0];
        int colStart = col + dc[i];
        int colEnd = colStart + hw[1];

        if (isOutOfMap(rowStart, colStart) || visited[rowStart][colStart] || isOutOfMap(rowEnd, colEnd)) {
          continue;
        }

        int wallSum = prefix[rowEnd + 1][colEnd + 1]
            - prefix[rowEnd + 1][colStart]
            - prefix[rowStart][colEnd + 1]
            + prefix[rowStart][colStart];

        if (wallSum != 0) {
          continue;
        }

        visited[rowStart][colStart] = true;

        int nextDist = current[2] + 1;

        if (rowStart == dest[0] && colStart == dest[1]) {
          max = nextDist;

          break;
        }

        queue.add(new int[]{ rowStart, colStart, nextDist });
      }

      if (max != 0) {
        break;
      }
    }

    System.out.println(max == 0 ? -1 : max);
  }

  static boolean isOutOfMap(int row, int col) {
    return row < 0 || col < 0 || row >= n || col >= m;
  }

}
