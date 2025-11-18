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
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int front = Integer.parseInt(st.nextToken());
      int back = Integer.parseInt(st.nextToken());

      graph.putIfAbsent(front, new ArrayList<>());
      graph.get(front)
          .add(back);

      ingress[back]++;
    }

    for (int i = 1; i <= n; i++) {
      if (ingress[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();

      sb.append(current)
          .append(" ");

      if (!graph.containsKey(current)) {
        continue;
      }

      for (int child : graph.get(current)) {
        if (--ingress[child] == 0) {
          queue.add(child);
        }
      }
    }

    System.out.println(sb);
  }

}
