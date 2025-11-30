import java.io.*;
import java.util.*;

public class Main {

  static class Position {
    int row;
    int col;

    Position(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  static int[] dr = { -1, 1, 0, 0 };
  static int[] dc = { 0, 0, -1, 1 };
  static char[][] map;
  static boolean[][] visited;
  static Set<Character> keys;
  static Map<Character, List<Position>> gates;
  static List<Position> entries;
  static int docCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());

    for (int t = 0; t < cases; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      map = new char[n][m];
      visited = new boolean[n][m];
      keys = new HashSet<>();
      gates = new HashMap<>();
      entries = new ArrayList<>();
      docCount = 0;

      for (int i = 0; i < n; i++) {
        map[i] = br.readLine()
            .toCharArray();

        if (i == 0 || i == n - 1) {
          for (int j = 1; j < m - 1; j++) {
            handleEntry(i, j);
          }
        }

        handleEntry(i, 0);
        handleEntry(i, m - 1);
      }

      char[] starters = br.readLine()
          .toCharArray();

      if (starters[0] != '0') {
        for (char starter : starters) {
          keys.add(starter);
        }
      }

      for (Position entry : entries) {
        bfs(entry);
      }

      while (hasGate()) {
        ArrayList<Character> gateCodes = new ArrayList<>(gates.keySet());

        for (char gateCode : gateCodes) {
          char gateKey = Character.toLowerCase(gateCode);

          if (!keys.contains(gateKey)) {
            continue;
          }

          List<Position> gatePositions = gates.get(gateCode);

          if (gatePositions.isEmpty()) {
            continue;
          }

          gates.put(gateCode, new ArrayList<>());

          for (Position position : gatePositions) {
            map[position.row][position.col] = '.';

            bfs(position);
          }
        }
      }

      System.out.println(docCount);
    }
  }

  static void bfs(Position entry) {
    Queue<Position> queue = new LinkedList<>();
    visited[entry.row][entry.col] = true;

    queue.add(entry);

    while (!queue.isEmpty()) {
      Position current = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nextRow = current.row + dr[i];
        int nextCol = current.col + dc[i];
        Position next = new Position(nextRow, nextCol);

        if (!canMoveTo(nextRow, nextCol)) {
          continue;
        }

        visited[nextRow][nextCol] = true;

        if (isGate(nextRow, nextCol)) {
          saveGate(nextRow, nextCol);

          continue;
        }

        handleCell(nextRow, nextCol);
        queue.add(next);
      }
    }
  }

  static boolean hasGate() {
    for (char gateCode : gates.keySet()) {
      char gateKey = Character.toLowerCase(gateCode);

      if (!keys.contains(gateKey)) {
        continue;
      }

      if (!gates.get(gateCode).isEmpty()) {
        return true;
      }
    }

    return false;
  }

  static void saveGate(int row, int col) {
    gates.putIfAbsent(map[row][col], new ArrayList<>());
    gates.get(map[row][col])
        .add(new Position(row, col));
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

  static void handleCell(int row, int col) {
    if (isKey(row, col)) {
      keys.add(map[row][col]);
    }

    if (map[row][col] == '$') {
      docCount++;
      map[row][col] = '.';
    }
  }

  static void handleEntry(int row, int col) {
    if (map[row][col] == '*') {
      return;
    }

    if (isGate(row, col)) {
      saveGate(row, col);

      return;
    }

    Position entry = new Position(row, col);

    entries.add(entry);
    handleCell(row, col);
  }

}
