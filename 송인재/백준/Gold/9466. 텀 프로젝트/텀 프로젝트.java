import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int t = 0; t < cases; t++) {
      int n = Integer.parseInt(br.readLine());
      int[] ingress = new int[n + 1];
      Map<Integer, List<Integer>> graph = new HashMap<>();
      Queue<Integer> queue = new LinkedList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int count = 0;

      for (int i = 1; i <= n; i++) {
        int desire = Integer.parseInt(st.nextToken());

        graph.putIfAbsent(i, new ArrayList<>());
        graph.get(i)
            .add(desire);

        ingress[desire]++;
      }

      for (int i = 1; i <= n; i++) {
        if (ingress[i] == 0) {
          queue.add(i);
        }
      }

      count += queue.size();

      while (!queue.isEmpty()) {
        int current = queue.poll();

        if (!graph.containsKey(current)) {
          continue;
        }

        for (int next : graph.get(current)) {
          ingress[next]--;

          if (ingress[next] == 0) {
            queue.add(next);
            count++;
          }
        }
      }

      sb.append(count)
          .append(System.lineSeparator());
    }

    System.out.print(sb);
  }

}
