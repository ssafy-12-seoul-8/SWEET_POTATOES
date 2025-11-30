import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[][] map;
  static boolean[] rightBottomVisited;
  static boolean[] leftBottomVisited;
  static int[] max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    rightBottomVisited = new boolean[2 * n - 1];
    leftBottomVisited = new boolean[2 * n - 1];
    max = new int[2];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    backtrack(0, 0, 0);
    backtrack(1, 1, 0);
    System.out.println(max[0] + max[1]);
  }

  static void backtrack(int start, int index, int bishopCount) {
    max[start] = Math.max(max[start], bishopCount);

    for (int i = index; i < n * n; i++) {
      int row = i / n;
      int col = i % n;
      int rbIndex = row - col + (2 * n - 1) / 2;
      int lbIndex = row + col;

      if ((row + col) % 2 != start || map[row][col] == 0 || !canPlace(rbIndex, lbIndex)) {
        continue;
      }

      rightBottomVisited[rbIndex] = true;
      leftBottomVisited[lbIndex] = true;

      backtrack(start, i + 1, bishopCount + 1);

      rightBottomVisited[rbIndex] = false;
      leftBottomVisited[lbIndex] = false;
    }
  }

  static boolean canPlace(int rbIndex, int lbIndex) {
    return !rightBottomVisited[rbIndex] && !leftBottomVisited[lbIndex];
  }

}
