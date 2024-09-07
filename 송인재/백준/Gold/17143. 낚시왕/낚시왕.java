import java.util.*;
import java.io.*;

public class Main {

  static class Shark {
    int row;
    int col;
    int direction;
    int size;
    int velocity;

    Shark(int row, int col, int direction, int size, int velocity) {
      this.row = row;
      this.col = col;
      this.direction = direction;
      this.size = size;
      this.velocity = velocity;
    }

    void move() {
      int newRow = row + dr[direction] * velocity;
      int newCol = col + dc[direction] * velocity;

      while (!isInMap(newRow, newCol)) {
        int diff = newRow < 0 ? newRow : newCol;

        if (newRow >= r) {
          diff = newRow - r + 1;
        }

        if (newCol >= c) {
          diff = newCol - c + 1;
        }

        if (newRow < 0 || newRow >= r) {
          newRow -= 2 * diff;
        }

        if (newCol < 0 || newCol >= c) {
          newCol -= 2 * diff;
        }

        changeDirection();
      }

      row = newRow;
      col = newCol;
    }

    void changeDirection() {
      if (direction % 2 == 0) {
        direction++;
      } else {
        direction--;
      }
    }
  }

  static final int[] dr = { -1, 1, 0, 0 };
  static final int[] dc = { 0, 0, 1, -1 };

  static int r, c, m, sum;
  static int[][] currentSharks;
  static Shark[] sharks;
  static boolean[] caught;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    sharks = new Shark[m];
    caught = new boolean[m];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int row = Integer.parseInt(st.nextToken()) - 1;
      int col = Integer.parseInt(st.nextToken()) - 1;
      int velocity = Integer.parseInt(st.nextToken());
      int direction = Integer.parseInt(st.nextToken()) - 1;
      int size = Integer.parseInt(st.nextToken());
      sharks[i] = new Shark(row, col, direction, size, velocity);
    }

    locateSharks();

    for (int i = 0; i < c; i++) {
      catchShark(i);

      for (int j = 0; j < m; j++) {
        if (!caught[j]) {
          sharks[j].move();
        }
      }

      locateSharks();
    }

    System.out.println(sum);
  }

  static void catchShark(int column) {
    for (int i = 0; i < r; i++) {
      int currentShark = currentSharks[i][column];

      if (currentShark != -1) {
        if (caught[currentShark]) {
          continue;
        }

        caught[currentShark] = true;
        sum += sharks[currentShark].size;

        return;
      }
    }
  }

  static void locateSharks() {
    currentSharks = new int[r][c];

    for (int i = 0; i < r; i++) {
      Arrays.fill(currentSharks[i], -1);
    }

    for (int i = 0; i < m; i++) {
      if (caught[i]) {
        continue;
      }

      Shark shark = sharks[i];
      int currentShark = currentSharks[shark.row][shark.col];

      if (currentShark == -1) {
        currentSharks[shark.row][shark.col] = i;

        continue;
      }

      if (sharks[currentShark].size < shark.size) {
        caught[currentShark] = true;
        currentSharks[shark.row][shark.col] = i;
      } else {
        caught[i] = true;
      }
    }
  }

  static boolean isInMap(int row, int col) {
    return row >= 0
        && row < r
        && col >= 0
        && col < c;
  }

}