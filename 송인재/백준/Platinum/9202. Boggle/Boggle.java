import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
  static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
  static int[] scores = { 0, 0, 0, 1, 1, 2, 3, 5, 11 };
  static String[] words;
  static char[][] boggle = new char[4][4];
  static boolean[][] visited = new boolean[4][4];
  static boolean found;
  static int score;
  static Queue<String> pq = new PriorityQueue<>((s1, s2) -> {
    if (s2.length() == s1.length()) {
      return s1.compareTo(s2);
    }

    return s2.length() - s1.length();
  });

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int w = Integer.parseInt(br.readLine());
    words = new String[w];

    for (int i = 0; i < w; i++) {
      words[i] = br.readLine();
    }

    br.readLine();

    int b = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int t = 1; t <= b; t++) {
      score = 0;

      pq.clear();

      for (int i = 0; i < 4; i++) {
        boggle[i] = br.readLine()
            .toCharArray();
      }

      Arrays.stream(words)
              .forEach(Main::search);
      sb.append(score)
          .append(" ")
          .append(pq.peek())
          .append(" ")
          .append(pq.size())
          .append("\n");

      if (t != b) {
        br.readLine();
      }
    }

    System.out.print(sb);
  }

  static void search(String word) {
    found = false;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (boggle[i][j] == word.charAt(0) && !found) {
          visited[i][j] = true;

          backtrack(i, j, word, 1);

          visited[i][j] = false;
        }
      }
    }
  }

  static void backtrack(int row, int col, String word, int length) {
    if (found) {
      return;
    }

    if (word.length() == length) {
      found = true;
      score += scores[length];

      pq.add(word);

      return;
    }

    for (int i = 0; i < 8; i++) {
      int newRow = row + dr[i];
      int newCol = col + dc[i];

      if (!isInMap(newRow, newCol) || visited[newRow][newCol] || boggle[newRow][newCol] != word.charAt(length)) {
        continue;
      }

      visited[newRow][newCol] = true;

      backtrack(newRow, newCol, word, length + 1);

      visited[newRow][newCol] = false;
    }
  }

  static boolean isInMap(int row, int col) {
    return row >= 0
        && row < 4
        && col >= 0
        && col < 4;
  }

}