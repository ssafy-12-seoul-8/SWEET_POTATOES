import java.io.*;
import java.util.*;

public class Main {

  static class CCTV {
    int row;
    int col;
    int direction;
    int current;
    int max;

    CCTV(int row, int col, int direction) {
      this.row = row;
      this.col = col;
      this.direction = direction;
      max = getMax();
    }

    int getMax() {
      switch (direction) {
        case 2:
          return 2;
        case 5:
          return 1;
      }

      return 4;
    }

    int fill(int[][] temp) {
      int count = 0;

      switch (direction) {
        case 1:
          count += monitor(temp, 0);
          break;
        case 2:
          count += monitor(temp, 0);
          count += monitor(temp, 2);
          break;
        case 3:
          count += monitor(temp, 0);
          count += monitor(temp, 1);
          break;
        case 4:
          count += monitor(temp, 0);
          count += monitor(temp, 1);
          count += monitor(temp, 2);
          break;
        case 5:
          count += monitor(temp, 0);
          count += monitor(temp, 1);
          count += monitor(temp, 2);
          count += monitor(temp, 3);
      }

      return count;
    }

    int monitor(int[][] temp, int offset) {
      int count = 0;
      int index = (current + offset) % 4;
      int startRow = row + dr[index];
      int startCol = col + dc[index];

      while (isInMap(startRow, startCol) && map[startRow][startCol] != 6) {
        if (temp[startRow][startCol] == 0) {
          temp[startRow][startCol] = 9;
          count++;
        }

        startRow += dr[index];
        startCol += dc[index];
      }

      return count;
    }

    @Override
    public String toString() {
      return "CCTV{" +
          "row=" + row +
          ", col=" + col +
          ", direction=" + direction +
          ", current=" + current +
          ", max=" + max +
          '}';
    }

  }

  static int[] dr = { -1, 0, 1, 0 };
  static int[] dc = { 0, 1, 0, -1 };
  static int n, m, total;
  static int[][] map;
  static List<CCTV> cctvs = new ArrayList<>();
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 0) {
          total++;
        }

        if (map[i][j] > 0 && map[i][j] < 6) {
          cctvs.add(new CCTV(i, j, map[i][j]));
        }
      }
    }

    backtrack(0);
    System.out.println(min);
  }

  static void backtrack(int index) {
    if (min == 0) {
      return;
    }

    countBlinds();

    if (index == cctvs.size()) {
      return;
    }

    CCTV cctv = cctvs.get(index);

    for (int i = 0; i < cctv.max; i++) {
      cctv.current = i;

      backtrack(index + 1);

      cctv.current = 0;
    }
  }

  static void countBlinds() {
    int[][] temp = new int[n][m];

    for (int i = 0; i < map.length; i++) {
      temp[i] = Arrays.copyOf(map[i], map[i].length);
    }

    int blind = 0;

    for (CCTV cctv : cctvs) {
      blind += cctv.fill(temp);
    }

    min = Math.min(min, total - blind);
  }

  static boolean isInMap(int row, int col) {
    return row >= 0
        && row < n
        && col >= 0
        && col < m;
  }

}