import java.io.*;
import java.util.*;

public class Main {

  static class Cleaner {
    int top;
    int bottom;
    int[] topR = { -1, 0, 1, 0 };
    int[] topC = { 0, 1, 0, -1 };
    int[] bottomR = dr;
    int[] bottomC = dc;

    Cleaner(int top, int bottom) {
      this.top = top;
      this.bottom = bottom;
    }

    void sweep() {
      doSweep(top, topR, topC);
      doSweep(bottom, bottomR, bottomC);
    }

    void doSweep(int start, int[] dr, int[] dc) {
      int direction = 0;
      int[] end = new int[] { start + dr[direction], dc[direction] };

      while (end[0] != start || end[1] != 0) {
        int row = end[0];
        int col = end[1];
        int prevRow = row - dr[direction];
        int prevCol = col - dc[direction];

        if (room[row][col] != -1) {
          if (room[prevRow][prevCol] != -1) {
            room[prevRow][prevCol] = room[row][col];
          }

          room[row][col] = 0;
        }

        int nextRow = row + dr[direction];
        int nextCol = col + dc[direction];

        if (isOutOfBox(nextRow, nextCol) || isTurning(start, row, col)) {
          direction = (direction + 1) % 4;
        }

        end[0] = row + dr[direction];
        end[1] = col + dc[direction];
      }
    }

    boolean isTurning(int start, int row, int col) {
      return row == start && (col == 0 || col == c - 1);
    }
  }

  static int[][] room;
  static int r;
  static int c;
  static int[] dr = { 1, 0, -1, 0 };
  static int[] dc = { 0, 1, 0, -1 };
  static Cleaner cleaner;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    room = new int[r][c];

    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < c; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());

        if (room[i][j] == -1 && Objects.isNull(cleaner)) {
          cleaner = new Cleaner(i, i + 1);
        }
      }
    }

    for (int cases = 1; cases <= t; cases++) {
      sparse();
      cleaner.sweep();
    }

    int sum = 0;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        sum += room[i][j];
      }
    }

    System.out.println(sum + 2);
  }

  static void sparse() {
    int[][] accum = new int[r][c];

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (room[i][j] <= 0) {
          continue;
        }

        int sum = 0;

        for (int k = 0; k < 4; k++) {
          int row = i + dr[k];
          int col = j + dc[k];

          if (isOutOfBox(row, col) || room[row][col] == -1) {
            continue;
          }

          accum[row][col] += room[i][j] / 5;
          sum += room[i][j] / 5;
        }

        accum[i][j] -= sum;
      }
    }

    merge(accum);
  }

  static void merge(int[][] accum) {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        room[i][j] += accum[i][j];
      }
    }
  }

  static boolean isOutOfBox(int row, int col) {
    return row < 0 || row >= r || col < 0 || col >= c;
  }

}
