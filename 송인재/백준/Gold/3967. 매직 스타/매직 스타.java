import java.io.*;

public class Main {

  static int[][] starIndex;
  static int[] starNum;
  static char[][] board;
  static boolean[] used;
  static boolean isFilled;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    starIndex = new int[12][2];
    starNum = new int[12];
    board = new char[5][9];
    used = new boolean[27];
    int index = 0;

    for (int i = 0; i < 5; i++) {
      board[i] = br.readLine()
          .toCharArray();

      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != '.') {
          starIndex[index] = new int[]{ i, j };
          starNum[index] = board[i][j] == 'x' ? 0 : board[i][j] - 'A' + 1;
          used[starNum[index]] = true;
          index++;
        }
      }
    }

    combination(0);

    StringBuilder sb = new StringBuilder();

    for (char[] line : board) {
      sb.append(line)
          .append("\n");
    }

    System.out.print(sb);
  }

  static void combination(int index) {
    if (isFilled) {
      return;
    }

    int nextIndex = index;

    while (nextIndex < 12 && starNum[nextIndex] != 0) {
      nextIndex++;
    }

    int first = starNum[1] + starNum[2] + starNum[3] + starNum[4];

    if (nextIndex >= 5 && first != 26) {
      return;
    }

    int second = starNum[0] + starNum[2] + starNum[5] + starNum[7];

    if (nextIndex >= 8 && second != 26) {
      return;
    }

    int third = starNum[0] + starNum[3] + starNum[6] + starNum[10];
    int fourth = starNum[7] + starNum[8] + starNum[9] + starNum[10];

    if (nextIndex >= 11 && (third != 26 || fourth != 26)) {
      return;
    }

    int fifth = starNum[1] + starNum[5] + starNum[8] + starNum[11];
    int sixth = starNum[4] + starNum[6] + starNum[9] + starNum[11];

    if (nextIndex >= 12) {
      if (fifth == 26 && sixth == 26) {
        fill();
        isFilled = true;
      }

      return;
    }

    for (int i = 1; i <= 26; i++) {
      if (used[i]) {
        continue;
      }

      starNum[nextIndex] = i;
      used[i] = true;

      combination(nextIndex + 1);

      starNum[nextIndex] = 0;
      used[i] = false;
    }
  }

  static void fill() {
    for (int i = 0; i < 12; i++) {
      int[] index = starIndex[i];
      board[index[0]][index[1]] = (char) (starNum[i] - 1 + 'A');
    }
  }

}
