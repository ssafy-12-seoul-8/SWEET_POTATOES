import java.io.*;
import java.util.*;

public class Solution {

  static class Node {
    int row;
    int col;
    int weight;

    Node(int row, int col, int weight) {
      this.row = row;
      this.col = col;
      this.weight = weight;
    }
  }

  static final int INF = Integer.MAX_VALUE;
  static final Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
  static final int[] dr = { -1, 0, 1, 0 };
  static final int[] dc = { 0, 1, 0, -1 };

  static int n;
  static int[][] map;
  static int[][] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());

    for (int t = 1; t <= cases; t++) {
      n = Integer.parseInt(br.readLine());
      map = new int[n][n];
      distance = new int[n][n];

      for (int i = 0; i < n; i++) {
        String line = br.readLine();

        for (int j = 0; j < n; j++) {
          map[i][j] = line.charAt(j) - '0';
        }
      }

      dijkstra();
      System.out.println("#" + t + " " + distance[n - 1][n - 1]);
    }
  }

  static void dijkstra() {
    for (int i = 0; i < n; i++) {
      Arrays.fill(distance[i], INF);
    }

    distance[0][0] = 0;
    pq.add(new Node(0, 0, 0));

    while (!pq.isEmpty()) {
      Node current = pq.poll();

      if (distance[current.row][current.col] < current.weight) {
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int newRow = current.row + dr[i];
        int newCol = current.col + dc[i];

        if (!isInMap(newRow, newCol)) {
          continue;
        }

        int nextWeight = current.weight + map[newRow][newCol];

        if (nextWeight < distance[newRow][newCol]) {
          distance[newRow][newCol] = nextWeight;

          pq.add(new Node(newRow, newCol, nextWeight));
        }
      }
    }
  }

  static boolean isInMap(int row, int col) {
    return row >= 0
        && row < n
        && col >= 0
        && col < n;
  }

}
