import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  static int r;
  static int c;
  static char[][] board;
  static boolean[][] visited;
  static Set<Character> set;
  static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    board = new char[r][c];
    visited = new boolean[r][c];
    set = new HashSet<>();

    for (int i = 0; i < r; i++) {
      board[i] = br.readLine()
          .toCharArray();
    }

    set.add(board[0][0]);
    visited[0][0] = true;
    max = 1;

    combination(0, 0, 1);

    System.out.println(max);
  }

  static void combination(int row, int col, int current) {
    if (max == 26) {
      return;
    }

    for (int i = 0; i < 4; i++) {
      int newRow = row + dr[i];
      int newCol = col + dc[i];

      if (isOutOfBox(newRow, newCol) || visited[newRow][newCol] || set.contains(board[newRow][newCol])) {
        continue;
      }

      visited[newRow][newCol] = true;
      set.add(board[newRow][newCol]);
      max = Math.max(max, current + 1);

      combination(newRow, newCol, current + 1);

      visited[newRow][newCol] = false;
      set.remove(board[newRow][newCol]);
    }
  }

  static boolean isOutOfBox(int row, int col) {
    return row < 0 || row >= r || col < 0 || col >= c;
  }

}
