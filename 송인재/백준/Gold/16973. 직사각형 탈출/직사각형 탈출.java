import java.io.*;
import java.util.*;

public class Main {

  static class Rectangle {
    int r;
    int c;
    int h;
    int w;
    int dist;

    Rectangle(int h, int w, int r, int c, int dist) {
      this.r = r;
      this.c = c;
      this.h = h;
      this.w = w;
      this.dist = dist;
      visited[r][c] = true;
    }

    boolean isValid(int direction) {
      int row = r + dr[direction];
      int col = c + dc[direction];
      
      if (isOutOfMap(row, col) || visited[row][col]) {
        return false;
      }

      if (direction % 2 == 0) {
        int nextRow = direction / 2 == 0 ? row : row + h;

        for (int i = 0; i <= w; i++) {
          int nextCol = col + i;

          if (isOutOfMap(nextRow, nextCol) || map[nextRow][nextCol] == 1) {
            return false;
          }
        }
      } else {
        int nextCol = direction / 2 == 0 ? col : col + w;

        for (int i = 0; i <= h; i++) {
          int nextRow = row + i;

          if (isOutOfMap(nextRow, nextCol) || map[nextRow][nextCol] == 1) {
            return false;
          }
        }
      }

      return true;
    }

    boolean isOutOfMap(int row, int col) {
      return row < 0 || col < 0 || row >= n || col >= m;
    }

    Rectangle move(int direction) {
      int nextRow = r + dr[direction];
      int nextCol = c + dc[direction];

      return new Rectangle(h, w, nextRow, nextCol, dist + 1);
    }

  }

  static int n;
  static int m;
  static int[][] map;
  static boolean[][] visited;
  static int[] dest;
  static int[] dr = { -1, 0, 1, 0 };
  static int[] dc = { 0, -1, 0, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    visited = new boolean[n][m];
    dest = new int[2];
    Queue<Rectangle> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken()) - 1;
    int w = Integer.parseInt(st.nextToken()) - 1;
    int r = Integer.parseInt(st.nextToken()) - 1;
    int c = Integer.parseInt(st.nextToken()) - 1;
    dest[0] = Integer.parseInt(st.nextToken()) - 1;
    dest[1] = Integer.parseInt(st.nextToken()) - 1;
    int max = 0;

    queue.add(new Rectangle(h, w, r, c, 0));

    while (!queue.isEmpty()) {
      Rectangle current = queue.poll();

      for (int i = 0; i < 4; i++) {
        if (!current.isValid(i)) {
          continue;
        }

        Rectangle next = current.move(i);

        if (next.r == dest[0] && next.c == dest[1]) {
          max = next.dist;

          break;
        }

        queue.add(next);
      }

      if (max != 0) {
        break;
      }
    }

    System.out.println(max == 0 ? -1 : max);
  }

}
