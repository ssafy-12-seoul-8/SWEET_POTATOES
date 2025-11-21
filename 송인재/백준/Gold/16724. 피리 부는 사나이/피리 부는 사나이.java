import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = { -1, 1, 0, 0 };
  static int[] dc = { 0, 0, -1, 1 };
  static int[] rep;
  static int n;
  static int m;
  static char[][] map;
  static boolean[][] visited;
  static Queue<int[]> queue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[n][m];
    rep = new int[n * m];
    visited = new boolean[n][m];
    queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      map[i] = br.readLine()
          .toCharArray();
    }

    for (int i = 0; i < rep.length; i++) {
      rep[i] = i;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j]) {
          bfs(i, j);
        }
      }
    }

    int count = 0;

    for (int i = 0; i < rep.length; i++) {
      if (i == find(i)) {
        count++;
      }
    }

    System.out.println(count);
  }

  static void bfs(int i, int j) {
    queue.add(new int[] { i, j });
    visited[i][j] = true;

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int row = curr[0];
      int col = curr[1];
      int currIndex = row * m + col;
      int direction = convertDirection(map[row][col]);
      int nextRow = row + dr[direction];
      int nextCol = col + dc[direction];

      if (isOutOfBox(nextRow, nextCol)) {
        continue;
      }

      int nextIndex = nextRow * m + nextCol;

      union(nextIndex, currIndex);

      if (visited[nextRow][nextCol]) {
        continue;
      }

      visited[nextRow][nextCol] = true;

      queue.add(new int[] { nextRow, nextCol });
    }
  }

  static int convertDirection(char direction) {
    switch(direction) {
      case 'U': return 0;
      case 'D': return 1;
      case 'L': return 2;
    }

    return 3;
  }

  static boolean isOutOfBox(int row, int col) {
    return row < 0 || col < 0 || row >= n || col >= m;
  }

  static int find(int x) {
    if (rep[x] != x) {
      rep[x] = find(rep[x]);
    }

    return rep[x];
  }

  static void union(int x, int y) {
    int repX = find(x);
    int repY = find(y);

    if (repX == repY) {
      return;
    }

    rep[repY] = repX;
  }

}
