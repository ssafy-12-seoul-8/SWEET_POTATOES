import java.util.*;
import java.io.*;

public class Main {

  static final int[] drOdd = { -1, -1, 0, 0, 1, 1 };
  static final int[] dcOdd = { 0, 1, -1, 1, 0, 1 };
  static final int[] drEven = { -1, -1, 0, 0, 1, 1 };
  static final int[] dcEven = { -1, 0, -1, 1, -1, 0 };

  static int h, w;
  static int[][] map, lights;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    map = new int[h + 2][w + 2];
    lights = new int[h + 2][w + 2];
    visited = new boolean[h + 2][w + 2];

    for (int i = 1; i < h + 1; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 1; j < w + 1; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(bfs());
  }

  static int bfs() {
    int sum = 0;
    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[] { 0, 0 });

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int currRow = curr[0];
      int currCol = curr[1];
      boolean isEven = currRow % 2 == 0;

      for (int i = 0; i < 6; i++) {
        int newRow = isEven ? currRow + drEven[i] : currRow + drOdd[i];
        int newCol = isEven ? currCol + dcEven[i] : currCol + dcOdd[i];

        if (!isInMap(newRow, newCol) || visited[newRow][newCol] || lights[newRow][newCol] > 0) {
          continue;
        }

        if (map[newRow][newCol] == 1) {
          lights[currRow][currCol]++;
        } else {
          visited[newRow][newCol] = true;

          queue.add(new int[] { newRow, newCol });
        }
      }

      sum += lights[currRow][currCol];
    }

    return sum;
  }

  static boolean isInMap(int row, int col) {
    boolean isEven = row % 2 == 0;

    return row >= 0
        && row < h + 2
        && col >= 0
        && col < w + 2;
  }

}