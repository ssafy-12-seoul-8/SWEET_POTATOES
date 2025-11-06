import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int m;
  static int[][] paper;
  static int[] dr = { 0, 1, 0, -1 };
  static int[] dc = { 1, 0, -1, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    paper = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    boolean allMelted = false;
    int count = 0;

    while (!allMelted) {
      markSurrounded();
      allMelted = melt();
      count++;
    }

    System.out.println(count);
  }

  static boolean melt() {
    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < m - 1; j++) {
        if (paper[i][j] != 1) {
          continue;
        }

        int sum = 0;

        for (int k = 0; k < 4 && sum < 2; k++) {
          int row = i + dr[k];
          int col = j + dc[k];

          if (paper[row][col] != 0) {
            continue;
          }

          sum++;
        }

        if (sum >= 2) {
          paper[i][j] = 3;
        }
      }
    }

    boolean allMelted = true;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (paper[i][j] > 1) {
          paper[i][j] = 0;
        }

        if (allMelted && paper[i][j] == 1) {
          allMelted = false;
        }
      }
    }

    return allMelted;
  }

  static void markSurrounded() {
    boolean[][] visited = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    visited[0][0] = true;
    queue.add(new int[] { 0, 0 });

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int row = current[0];
      int col = current[1];

      for (int i = 0; i < 4; i++) {
        int nextRow = row + dr[i];
        int nextCol = col + dc[i];

        if (isOutOfBox(nextRow, nextCol) || visited[nextRow][nextCol] || paper[nextRow][nextCol] == 1) {
          continue;
        }

        visited[nextRow][nextCol] = true;

        queue.add(new int[] { nextRow, nextCol });
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (paper[i][j] == 1 || visited[i][j]) {
          continue;
        }

        paper[i][j] = 2;
      }
    }
  }

  static boolean isOutOfBox(int row, int col) {
    return row < 0 || row >= n || col < 0 || col >= m;
  }

}
