import java.io.*;
import java.util.*;

public class Main {

  static int[] dh = { -1, 1, 0, 0, 0, 0 };
  static int[] dr = { 0, 0, -1, 1, 0, 0 };
  static int[] dc = { 0, 0, 0, 0, -1, 1 };

  static int n, m, h, day;
  static int[][][] tomato;
  static Queue<int[]> queue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    tomato = new int[h][n][m];
    queue = new LinkedList<>();

    for (int i = 0; i < h; i++) {
      for (int r = 0; r < n; r++) {
        st = new StringTokenizer(br.readLine());

        for (int c = 0; c < m; c++) {
          tomato[i][r][c] = Integer.parseInt(st.nextToken());
        }
      }
    }

    for (int i = 0; i < h; i++) {
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < m; c++) {
          if (tomato[i][r][c] == 1) {
            queue.add(new int[]{ i, r, c, 0 });
          }
        }
      }
    }

    bfs();

    if (!confirmAllRipe()) {
      day = -1;
    }

    System.out.println(day);
  }

  static boolean confirmAllRipe() {
    for (int i = 0; i < h; i++) {
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < m; c++) {
          if (tomato[i][r][c] == 0) {
            return false;
          }
        }
      }
    }

    return true;
  }

  static void bfs() {
    while (!queue.isEmpty()) {
      int[] next = queue.poll();
      int nextHeight = next[0];
      int nextRow = next[1];
      int nextCol = next[2];
      int nextDay = next[3];

      for (int i = 0; i < 6; i++) {
        int newHeight = nextHeight + dh[i];
        int newRow = nextRow + dr[i];
        int newCol = nextCol + dc[i];
        int newDay = nextDay + 1;

        if (!isInMap(newHeight, newRow, newCol) || tomato[newHeight][newRow][newCol] != 0) {
          continue;
        }

        tomato[newHeight][newRow][newCol] = 1;
        day = Math.max(day, newDay);

        queue.add(new int[]{ newHeight, newRow, newCol, newDay });
      }
    }
  }

  static boolean isInMap(int height, int row, int col) {
    return height >= 0
        && height < h
        && row >= 0
        && row < n
        && col >= 0
        && col < m;
  }

}
