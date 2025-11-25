import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] jewels = new int[n][2];
    int[] bags = new int[k];
    Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    long sum = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      jewels[i][0] = Integer.parseInt(st.nextToken());
      jewels[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < k; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(jewels, Comparator.comparingInt(jewel -> jewel[0]));
    Arrays.sort(bags);

    int jewelIndex = 0;

    for (int i = 0; i < k; i++) {
      int bag = bags[i];

      while (jewelIndex < n && jewels[jewelIndex][0] <= bag) {
        pq.add(jewels[jewelIndex][1]);
        jewelIndex++;
      }

      if (!pq.isEmpty()) {
        sum += pq.poll();
      }
    }

    System.out.println(sum);
  }

}
