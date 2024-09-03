import java.io.*;
import java.util.*;

public class Solution {

  static final int[] dr = { -1, 0, 1, 0 };
  static final int[] dc = { 0, 1, 0, -1 };
  static final int cases = 10;

  static char[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int t = 1; t <= cases; t++) {
      int tc = Integer.parseInt(br.readLine());
      map = new char[16][16];
      int[] start = new int[2];

      for (int i = 0; i < 16; i++) {
        map[i] = br.readLine()
            .toCharArray();

        for (int j = 0; j < 16; j++) {
          if (map[i][j] == '2') {
            start[0] = i;
            start[1] = j;
          }
        }
      }

      System.out.println("#" + tc + " " + (bfs(start) ? 1 : 0));
    }
  }

  static boolean bfs(int[] start) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[16][16];
    visited[start[0]][start[1]] = true;
    boolean escaped = false;

    queue.add(start);

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int row = curr[0];
      int col = curr[1];

      for (int i = 0; i < 4; i++) {
        int newRow = row + dr[i];
        int newCol = col + dc[i];

        if (!isInMap(newRow, newCol) || visited[newRow][newCol] || map[newRow][newCol] == '1') {
          continue;
        }

        visited[newRow][newCol] = true;

        if (map[newRow][newCol] == '3') {
          escaped = true;

          queue.clear();
        } else {
          queue.add(new int[] { newRow, newCol });
        }
      }
    }

    return escaped;
  }

  static boolean isInMap(int row, int col) {
    return row >= 0
        && row < map.length
        && col >= 0
        && col < map[0].length;
  }

}
