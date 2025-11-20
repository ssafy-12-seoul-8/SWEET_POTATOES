import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] ingress = new int[n + 1];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int size = Integer.parseInt(st.nextToken());
      int from = Integer.parseInt(st.nextToken());

      for (int j = 0; j < size - 1; j++) {
        int to = Integer.parseInt(st.nextToken());

        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from)
            .add(to);

        ingress[to]++;
        from = to;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (ingress[i] == 0) {
        queue.add(i);
        sb.append(i)
            .append(System.lineSeparator());
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();

      if (!graph.containsKey(current)) {
        continue;
      }

      for (int next : graph.get(current)) {
        ingress[next]--;

        if (ingress[next] == 0) {
          queue.add(next);
          sb.append(next)
              .append(System.lineSeparator());
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      if (ingress[i] != 0) {
        sb = new StringBuilder()
            .append(0);

        break;
      }
    }

    System.out.print(sb);
  }

}
