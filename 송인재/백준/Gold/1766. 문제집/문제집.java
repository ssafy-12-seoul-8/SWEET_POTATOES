import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] ingress = new int[n + 1];
    Queue<Integer> pq = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.putIfAbsent(a, new ArrayList<>());
      graph.get(a)
          .add(b);

      ingress[b]++;
    }

    for (int i = 1; i <= n; i++) {
      if (ingress[i] == 0) {
        pq.add(i);
      }
    }

    while (!pq.isEmpty()) {
      int current = pq.poll();

      sb.append(current)
          .append(" ");

      if (!graph.containsKey(current)) {
        continue;
      }

      for (int next : graph.get(current)) {
        ingress[next]--;

        if (ingress[next] == 0) {
          pq.add(next);
        }
      }
    }

    System.out.println(sb);
  }

}
