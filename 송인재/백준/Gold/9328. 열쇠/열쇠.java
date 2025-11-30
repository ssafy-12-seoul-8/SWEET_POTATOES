import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = { -1, 1, 0, 0 };
  static int[] dc = { 0, 0, -1, 1 };
  static char[][] map;
  static boolean[][] visited;
  static boolean[] hasKey;
  static Map<Integer, Queue<int[]>> gates;
  static Queue<int[]> queue;
  static int docCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());

    for (int t = 0; t < cases; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      map = new char[n + 2][m + 2];
      visited = new boolean[n + 2][m + 2];
      hasKey = new boolean[26];
      gates = new HashMap<>();
      queue = new LinkedList<>();
      docCount = 0;

      for (int i = 0; i <= n + 1; i++) {
        if (i == 0 || i == n + 1) {
          for (int j = 0; j <= m + 1; j++) {
            map[i][j] = '.';
          }

          continue;
        }

        map[i][0] = '.';
        map[i][m + 1] = '.';
        char[] input = br.readLine()
            .toCharArray();

        for (int j = 1; j <= m; j++) {
          map[i][j] = input[j - 1];
        }
      }

      char[] starters = br.readLine()
          .toCharArray();

      if (starters[0] != '0') {
        for (char starter : starters) {
          int keyIndex = starter - 'a';
          hasKey[keyIndex] = true;
        }
      }

      visited[0][0] = true;

      queue.add(new int[] { 0, 0 });

      while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int row = current[0];
        int col = current[1];

        for (int i = 0; i < 4; i++) {
          int nextRow = row + dr[i];
          int nextCol = col + dc[i];

          if (!canMoveTo(nextRow, nextCol)) {
            continue;
          }

          int[] next = new int[] { nextRow, nextCol };

          if (isGate(nextRow, nextCol)) {
            int keyIndex = map[nextRow][nextCol] - 'A';

            if (!hasKey[keyIndex]) {
              gates.putIfAbsent(keyIndex, new LinkedList<>());
              gates.get(keyIndex)
                  .add(next);

              continue;
            }
          }

          visited[nextRow][nextCol] = true;

          if (isKey(nextRow, nextCol)) {
            int keyIndex = map[nextRow][nextCol] - 'a';
            hasKey[keyIndex] = true;

            if (gates.containsKey(keyIndex)) {
              Queue<int[]> gatePositions = gates.get(keyIndex);

              while (!gatePositions.isEmpty()) {
                int[] gate = gatePositions.poll();
                int gateRow = gate[0];
                int gateCol = gate[1];

                if (visited[gateRow][gateCol]) {
                  continue;
                }

                visited[gateRow][gateCol] = true;

                queue.add(new int[] { gateRow, gateCol });
              }
            }
          }

          if (map[nextRow][nextCol] == '$') {
            docCount++;
          }

          queue.add(next);
        }
      }

      System.out.println(docCount);
    }
  }

  static boolean isKey(int row, int col) {
    return map[row][col] >= 'a' && map[row][col] <= 'z';
  }

  static boolean isGate(int row, int col) {
    return map[row][col] >= 'A' && map[row][col] <= 'Z';
  }

  static boolean canMoveTo(int row, int col) {
    boolean isOutOfMap = row < 0 || col < 0 || row >= map.length || col >= map[0].length;

    return !isOutOfMap && !visited[row][col] && map[row][col] != '*';
  }

}
