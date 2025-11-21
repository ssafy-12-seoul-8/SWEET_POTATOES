import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = { -1, 1, 0, 0 };
  static int[] dc = { 0, 0, -1, 1 };
  static int[] rep;
  static int n;
  static int m;
  static char[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[n][m];
    rep = new int[n * m];

    for (int i = 0; i < n; i++) {
      map[i] = br.readLine()
          .toCharArray();
    }

    for (int i = 0; i < rep.length; i++) {
      rep[i] = i;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int currIndex = i * m + j;
        int direction = convertDirection(map[i][j]);
        int nextRow = i + dr[direction];
        int nextCol = j + dc[direction];
        int nextIndex = nextRow * m + nextCol;

        union(nextIndex, currIndex);
      }
    }

    int count = 0;

    for (int i = 0; i < rep.length; i++) {
      if (rep[i] == i) {
        count++;
      }
    }

    System.out.println(count);
  }

  static int convertDirection(char direction) {
    switch(direction) {
      case 'U': return 0;
      case 'D': return 1;
      case 'L': return 2;
    }

    return 3;
  }

  static int find(int x) {
    if (rep[x] != x) {
      rep[x] = find(rep[x]);
    }

    return rep[x];
  }

  static void union(int x, int y) {
    int repX = find(x);
    int repY = find(y);

    if (repX == repY) {
      return;
    }

    rep[repY] = repX;
  }

}
