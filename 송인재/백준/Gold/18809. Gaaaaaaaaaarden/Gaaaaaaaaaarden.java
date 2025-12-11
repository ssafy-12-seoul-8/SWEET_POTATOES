import java.io.*;
import java.util.*;

public class Main {

  static class Seed {
    int row;
    int col;
    boolean isRed;

    Seed(int row, int col, boolean isRed) {
      this.row = row;
      this.col = col;
      this.isRed = isRed;
    }
  }

  static int[] dr = { -1, 0, 1, 0 };
  static int[] dc = { 0, -1, 0, 1 };
  static int n;
  static int m;
  static int g;
  static int r;
  static int[][] map;
  static int[][] possibles;
  static int possiblesMax;
  static Seed[] seeds;
  static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    possibles = new int[10][2];
    seeds = new Seed[g + r];
    max = 0;
    possiblesMax = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 2) {
          possibles[possiblesMax++] = new int[]{ i, j };
        }
      }
    }

    combination(0, 0, 0, 0);

    System.out.println(max);
  }

  static void combination(int index, int seedIndex, int redCount, int greenCount) {
    if (seedIndex == r + g) {
      bfs();

      return;
    }

    for (int i = index; i < possiblesMax; i++) {
      int[] position = possibles[i];

      if (redCount < r) {
        seeds[seedIndex] = new Seed(position[0], position[1], true);

        combination(i + 1, seedIndex + 1, redCount + 1, greenCount);
      }

      if (greenCount < g) {
        seeds[seedIndex] = new Seed(position[0], position[1], false);

        combination(i + 1, seedIndex + 1, redCount, greenCount + 1);
      }
    }
  }

  static void bfs() {
    Queue<Seed> queue = new LinkedList<>();
    Queue<Seed> temp = new LinkedList<>();
    int[][] visited = new int[n][m];
    int count = 0;

    for (int i = 0; i < r + g; i++) {
      Seed seed = seeds[i];

      queue.add(seed);

      visited[seed.row][seed.col] = 1;
    }

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Seed current = queue.poll();

        for (int j = 0; j < 4; j++) {
          int nextRow = current.row + dr[j];
          int nextCol = current.col + dc[j];

          if (isOutOfMap(nextRow, nextCol) || map[nextRow][nextCol] == 0 || visited[nextRow][nextCol] % 2 == 1) {
            continue;
          }

          boolean redVisited = visited[nextRow][nextCol] == 2;
          boolean greenVisited = visited[nextRow][nextCol] == 4;

          if ((current.isRed && redVisited) || (!current.isRed && greenVisited)) {
            continue;
          }

          if ((current.isRed && greenVisited) || (!current.isRed && redVisited)) {
            visited[nextRow][nextCol] = 3;
          } else {
            visited[nextRow][nextCol] = current.isRed ? 2 : 4;
          }

          temp.add(new Seed(nextRow, nextCol, current.isRed));
        }
      }

      while (!temp.isEmpty()) {
        Seed candidate = temp.poll();
        boolean isFlower = visited[candidate.row][candidate.col] == 3;

        if (isFlower) {
          count++;
          visited[candidate.row][candidate.col] = 1;
        }

        if (visited[candidate.row][candidate.col] == 1) {
          continue;
        }

        visited[candidate.row][candidate.col] = 1;

        queue.add(candidate);
      }
    }

    max = Math.max(max, count);
  }

  static boolean isOutOfMap(int row, int col) {
    return row < 0 || col < 0 || row >= n || col >= m;
  }

}
