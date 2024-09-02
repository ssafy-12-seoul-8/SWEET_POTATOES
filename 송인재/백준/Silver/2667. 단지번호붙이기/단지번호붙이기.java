import java.io.*;
import java.util.*;

public class Main {

  static final int[] dr = { -1, 0, 1, 0 };
  static final int[] dc = { 0, 1, 0, -1 };

  static int n;
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();

      for (int j = 0; j < n; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    int houseNumber = 1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          dfs(i, j, houseNumber);

          houseNumber++;
        }
      }
    }

    int[] houseSize = new int[--houseNumber];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] != 0) {
          houseSize[map[i][j] - 1]++;
        }
      }
    }

    Arrays.sort(houseSize);

    StringBuilder sb = new StringBuilder()
        .append(houseNumber)
        .append("\n");

    for (int i = 0; i < houseSize.length; i++) {
      sb.append(houseSize[i]);

      if (i < houseSize.length - 1) {
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }

  static void dfs(int row, int col, int houseNumber) {
    if (!isInMap(row, col) || visited[row][col] || map[row][col] == 0) {
      return;
    }

    visited[row][col] = true;
    map[row][col] = houseNumber;

    for (int i = 0; i < 4; i++) {
      int newRow = row + dr[i];
      int newCol = col + dc[i];

      dfs(newRow, newCol, houseNumber);
    }
  }

  static boolean isInMap(int row, int col) {
    return row >= 0
        && row < n
        && col >= 0
        && col < n;
  }

}
