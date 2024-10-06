import java.io.*;
import java.util.*;

public class Main {

  static int[][] paper;
  static int[] colors;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    paper = new int[n][n];
    colors = new int[2];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    backtrack(0, n, 0, n);

    for (int color : colors) {
      System.out.println(color);
    }
  }

  static void backtrack(int rowFrom, int rowTo, int colFrom, int colTo) {
    if (isPaper(rowFrom, rowTo, colFrom, colTo)) {
      return;
    }

    int rowLimit = (rowFrom + rowTo) / 2;
    int colLimit = (colFrom + colTo) / 2;

    backtrack(rowFrom, rowLimit, colFrom, colLimit);
    backtrack(rowFrom, rowLimit, colLimit, colTo);
    backtrack(rowLimit, rowTo, colFrom, colLimit);
    backtrack(rowLimit, rowTo, colLimit, colTo);
  }

  static boolean isPaper(int rowFrom, int rowTo, int colFrom, int colTo) {
    int color = paper[rowFrom][colFrom];

    for (int i = rowFrom; i < rowTo; i++) {
      for (int j = colFrom; j < colTo; j++) {
        if (color != paper[i][j]) {
          return false;
        }
      }
    }

    colors[color]++;

    return true;
  }

}
