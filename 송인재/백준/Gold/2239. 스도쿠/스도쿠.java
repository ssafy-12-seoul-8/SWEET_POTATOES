import java.io.*;
import java.util.*;

public class Main {

  static int[][] board = new int[9][9];
  static int[][] answer;
  static int[] blanks;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int blankCount = 0;

    for (int i = 0; i < 9; i++) {
      String line = br.readLine();

      for (int j = 0; j < 9; j++) {
        board[i][j] = line.charAt(j) - '0';

        if (board[i][j] == 0) {
          blankCount++;
        }
      }
    }

    blanks = new int[blankCount];
    int index = 0;

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == 0) {
          blanks[index++] = i * 9 + j;
        }
      }
    }

    backtrack(0, blankCount);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(answer[i][j]);
      }

      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static void backtrack(int index, int left) {
    if (Objects.nonNull(answer)) {
      return;
    }

    if (left == 0) {
      answer = new int[9][9];

      for (int i = 0; i < 9; i++) {
        answer[i] = Arrays.copyOf(board[i], 9);
      }

      return;
    }

    int blankIndex = blanks[index];
    int row = blankIndex / 9;
    int col = blankIndex % 9;

    for (int i = 1; i <= 9; i++) {
      if (!checkRow(row, col, i) || !checkCol(row, col, i) || !checkBox(row, col, i)) {
        continue;
      }

      board[row][col] = i;

      backtrack(index + 1, left - 1);

      board[row][col] = 0;
    }
  }

  static boolean checkRow(int row, int col, int num) {
    for (int i = 0; i < 9; i++) {
      if (col != i && board[row][i] == num) {
        return false;
      }
    }

    return true;
  }

  static boolean checkCol(int row, int col, int num) {
    for (int i = 0; i < 9; i++) {
      if (row != i && board[i][col] == num) {
        return false;
      }
    }

    return true;
  }

  static boolean checkBox(int row, int col, int num) {
    int rowStart = (row / 3) * 3;
    int colStart = (col / 3) * 3;

    for (int i = rowStart; i < rowStart + 3; i++) {
      for (int j = colStart; j < colStart + 3; j++) {
        if (row != i && col != j && board[i][j] == num) {
          return false;
        }
      }
    }

    return true;
  }

}
