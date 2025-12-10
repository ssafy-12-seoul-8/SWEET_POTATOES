import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] devices = new int[n];
    Queue<Integer> pq = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      devices[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(devices);

    for (int i = n - 1; i >= 0; i--) {
      if (pq.isEmpty() || pq.size() < m) {
        pq.add(devices[i]);

        continue;
      }

      pq.add(pq.poll() + devices[i]);
    }

    while (pq.size() > 1) {
      pq.poll();
    }

    System.out.println(pq.poll());
  }

}
