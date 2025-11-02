import java.io.*;

public class Main {

  static int n;
  static char[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new char[n][2 * n - 1];

    for (int i = 0; i < board.length; i++) {
      board[i] = " ".repeat(board[0].length)
          .toCharArray();
    }

    mark(0, n - 1, n);

    for (char[] row : board) {
      System.out.println(String.valueOf(row));
    }
  }

  static void mark(int row, int col, int degree) {
    if (degree == 3) {
      board[row][col] = '*';
      board[row + 1][col + 1] = '*';
      board[row + 1][col - 1] = '*';

      for (int i = col - 2; i <= col + 2; i++) {
        board[row + 2][i] = '*';
      }

      return;
    }

    mark(row, col, degree / 2);
    mark(row + degree / 2, col - degree / 2, degree / 2);
    mark(row + degree / 2, col + degree / 2, degree / 2);
  }

}
