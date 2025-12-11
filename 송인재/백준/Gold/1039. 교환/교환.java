import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String input = st.nextToken();
    int k = Integer.parseInt(st.nextToken());
    Queue<String> queue = new LinkedList<>();

    queue.add(input);

    for (int i = 0; i < k; i++) {
      Set<String> visited = new HashSet<>();
      int limit = queue.size();

      for (int j = 0; j < limit; j++) {
        if (queue.isEmpty()) {
          break;
        }
        
        String current = queue.poll();

        for (int l = 0; l < current.length() - 1; l++) {
          for (int m = l + 1; m < current.length(); m++) {
            if (l == 0 && current.charAt(m) == '0') {
              continue;
            }

            String swapped = swap(current, l, m);

            if (visited.contains(swapped)) {
              continue;
            }

            visited.add(swapped);
            queue.add(swapped);
          }
        }
      }
    }

    int max = -1;

    while (!queue.isEmpty()) {
      max = Math.max(max, Integer.parseInt(queue.poll()));
    }

    System.out.println(max);
  }

  static String swap(String current, int i, int j) {
    return current.substring(0, i) + current.charAt(j) + current.substring(i + 1, j) + current.charAt(i) + current.substring(j + 1);
  }

}
