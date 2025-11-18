import java.io.*;
import java.util.*;

public class Main {

  static int[][] board = new int[9][9];
  static int[][] answer;
  static int[] blanks;
  static int[] rows = new int[9];
  static int[] cols = new int[9];
  static int[] boxes = new int[9];
  static int DIGIT_FILTER = (1 << 10) - 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int blankCount = 0;

    for (int i = 0; i < 9; i++) {
      String line = br.readLine();

      for (int j = 0; j < 9; j++) {
        board[i][j] = line.charAt(j) - '0';

        if (board[i][j] == 0) {
          blankCount++;
        } else {
          int bit = 1 << board[i][j];

          rows[i] |= bit;
          cols[j] |= bit;
          int boxIndex = i / 3 * 3 + j / 3;
          boxes[boxIndex] |= bit;
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

    backtrack(0);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(answer[i][j]);
      }

      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static void backtrack(int index) {
    if (Objects.nonNull(answer)) {
      return;
    }

    if (index == blanks.length) {
      answer = new int[9][9];

      for (int i = 0; i < 9; i++) {
        answer[i] = Arrays.copyOf(board[i], 9);
      }

      return;
    }

    int blankIndex = blanks[index];
    int row = blankIndex / 9;
    int col = blankIndex % 9;
    int boxIndex = row / 3 * 3 + col / 3;
    int notUsed = ~(rows[row] | cols[col] | boxes[boxIndex]) & DIGIT_FILTER;

    for (int i = notUsed; i != 0; i &= (i - 1)) {
      if (Objects.nonNull(answer)) {
        return;
      }

      int nextBit = i & -i;
      int num = Integer.numberOfTrailingZeros(nextBit);

      board[row][col] = num;
      rows[row] |= nextBit;
      cols[col] |= nextBit;
      boxes[boxIndex] |= nextBit;

      backtrack(index + 1);

      board[row][col] = 0;
      rows[row] ^= nextBit;
      cols[col] ^= nextBit;
      boxes[boxIndex] ^= nextBit;
    }
  }

}
