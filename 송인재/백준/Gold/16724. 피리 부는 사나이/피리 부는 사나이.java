import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = { -1, 1, 0, 0 };
  static int[] dc = { 0, 0, -1, 1 };
  static int n;
  static int m;
  static char[][] map;
  static int[][] state;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[n][m];
    state = new int[n][m];

    for (int i = 0; i < n; i++) {
      map[i] = br.readLine()
          .toCharArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (state[i][j] == 0) {
          dfs(i, j);
        }
      }
    }

    System.out.println(count);
  }

  static void dfs(int row, int col) {
    state[row][col] = 1;

    int direction = convertDirection(map[row][col]);
    int nextRow = row + dr[direction];
    int nextCol = col + dc[direction];

    if (state[nextRow][nextCol] == 1) {
      count++;
    }

    if (state[nextRow][nextCol] == 0) {
      dfs(nextRow, nextCol);
    }

    state[row][col] = 2;
  }

  static int convertDirection(char direction) {
    switch(direction) {
      case 'U': return 0;
      case 'D': return 1;
      case 'L': return 2;
    }

    return 3;
  }

}
