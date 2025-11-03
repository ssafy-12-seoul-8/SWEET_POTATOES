import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] distances = new int[100_001];
    int maxPossible = Math.abs(k - n);
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    int count = 0;

    Arrays.fill(distances, maxPossible);
    pq.add(new int[] { n, 0 });
    distances[n] = 0;

    if (n == k) {
      count++;
      pq.clear();
    }

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int at = current[0];
      int weight = current[1];

      for (int i = -1; i <= 1; i++) {
        int nextAt = i == 0 ? at * 2 : at + i;
        int nextWeight = weight + 1;

        if (nextWeight > maxPossible || isOutOfBox(nextAt) || distances[nextAt] < nextWeight) {
          continue;
        }

        if (nextAt == k) {
          if (nextWeight == distances[nextAt]) {
            count++;

            continue;
          }

          count = 1;
          distances[nextAt] = nextWeight;

          continue;
        }

        distances[nextAt] = nextWeight;

        pq.add(new int[] { nextAt, nextWeight });
      }
    }

    System.out.println(distances[k]);
    System.out.println(count);
  }

  static boolean isOutOfBox(int num) {
    return num < 0 || num > 100_000;
  }

}
