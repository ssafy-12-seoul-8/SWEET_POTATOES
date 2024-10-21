import java.io.*;
import java.util.*;

public class Main {

  static int[][] sudoku, answer;
  static List<int[]> zeros;
  static boolean[][] rowCount, colCount;
  static boolean[][][] blockCount;
  static int changeNeeded;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sudoku = new int[9][9];
    answer = new int[9][9];
    zeros = new ArrayList<>();
    rowCount = new boolean[9][10];
    colCount = new boolean[9][10];
    blockCount = new boolean[3][3][10];

    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < 9; j++) {
        int number = Integer.parseInt(st.nextToken());
        sudoku[i][j] = number;
        rowCount[i][number] = true;
        colCount[j][number] = true;
        int blockRow = i / 3;
        int blockCol = j / 3;
        blockCount[blockRow][blockCol][number] = true;

        if (number == 0) {
          changeNeeded++;
          zeros.add(new int[] { i, j });
        }
      }
    }

    backtrack(0);

    StringBuilder sb = new StringBuilder();

    for (int[] a : answer) {
      for (int n : a) {
        sb.append(n)
            .append(" ");
      }

      sb.append("\n");
    }

    System.out.print(sb);
  }

  static void backtrack(int index) {
    if (changeNeeded == 0) {
      return;
    }

    if (index == changeNeeded) {
      for (int i = 0; i < 9; i++) {
        answer[i] = Arrays.copyOf(sudoku[i], 9);
      }

      changeNeeded = 0;

      return;
    }

    int[] zero = zeros.get(index);
    int row = zero[0];
    int col = zero[1];
    int blockRow = row / 3;
    int blockCol = col / 3;

    for (int i = 1; i <= 9; i++) {
      if (isPossible(row, col, blockRow, blockCol, i)) {
        sudoku[row][col] = i;
        rowCount[row][i] = true;
        colCount[col][i] = true;
        blockCount[blockRow][blockCol][i] = true;

        backtrack(index + 1);

        sudoku[row][col] = 0;
        rowCount[row][i] = false;
        colCount[col][i] = false;
        blockCount[blockRow][blockCol][i] = false;
      }
    }
  }

  static boolean isPossible(int row, int col, int blockRow, int blockCol, int newNum) {
    return !rowCount[row][newNum] && !colCount[col][newNum]
        && !blockCount[blockRow][blockCol][newNum];
  }

}
