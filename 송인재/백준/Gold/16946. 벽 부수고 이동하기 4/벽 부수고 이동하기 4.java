import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = { -1, 1, 0, 0 };
  static int[] dc = { 0, 0, -1, 1 };
  static int n;
  static int m;
  static int[][] map;
  static int[][] movables;
  static boolean[][] visited;
  static Map<Integer, Integer> counts;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    movables = new int[n][m];
    visited = new boolean[n][m];
    counts = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String line = br.readLine();

      for (int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    int groupNumber = 2;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 0 && !visited[i][j]) {
          bfs(new int[] { i, j }, groupNumber);

          groupNumber++;
        }
      }
    }

    Set<Integer> adjs = new HashSet<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 1) {
          movables[i][j] = 1;

          for (int k = 0; k < 4; k++) {
            int nextRow = i + dr[k];
            int nextCol = j + dc[k];

            if (isOutOfBox(nextRow, nextCol) || map[nextRow][nextCol] == 1 || adjs.contains(map[nextRow][nextCol])) {
              continue;
            }

            adjs.add(map[nextRow][nextCol]);
          }

          for (int adj : adjs) {
            movables[i][j] += counts.get(adj);
          }

          adjs.clear();
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int[] row : movables) {
      for (int num : row) {
        sb.append(num % 10);
      }

      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static void bfs(int[] point, int groupNumber) {
    Queue<int[]> queue = new LinkedList<>();
    visited[point[0]][point[1]] = true;
    map[point[0]][point[1]] = groupNumber;
    int count = 1;

    queue.add(point);

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int currRow = current[0];
      int currCol = current[1];

      for (int i = 0; i < 4; i++) {
        int nextRow = currRow + dr[i];
        int nextCol = currCol + dc[i];

        if (isOutOfBox(nextRow, nextCol) || visited[nextRow][nextCol] || map[nextRow][nextCol] != 0) {
          continue;
        }

        visited[nextRow][nextCol] = true;
        map[nextRow][nextCol] = groupNumber;
        int[] nextPoint = new int[] { nextRow, nextCol };
        count++;

        queue.add(nextPoint);
      }
    }

    counts.put(groupNumber, count);
  }

  static boolean isOutOfBox(int row, int col) {
    return row < 0 || col < 0 || row >= n || col >= m;
  }

}
