import java.io.*;
import java.util.*;

public class Main {

  static Map<String, String> parent;
  static Map<String, Integer> count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int t = 1; t <= cases; t++) {
      int n = Integer.parseInt(br.readLine());
      parent = new HashMap<>();
      count = new HashMap<>();

      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String user1 = st.nextToken();
        String user2 = st.nextToken();

        parent.putIfAbsent(user1, user1);
        parent.putIfAbsent(user2, user2);
        count.putIfAbsent(user1, 1);
        count.putIfAbsent(user2, 1);

        union(user1, user2);

        String parent1 = find(user1);

        sb.append(count.get(parent1))
            .append("\n");
      }
    }

    System.out.print(sb);
  }

  static String find(String user) {
    if (!Objects.equals(parent.get(user), user)) {
      parent.put(user, find(parent.get(user)));
    }

    return parent.get(user);
  }

  static void union(String user1, String user2) {
    String parent1 = find(user1);
    String parent2 = find(user2);

    if (Objects.equals(parent1, parent2)) {
      return;
    }

    int countSum = count.get(parent1) + count.get(parent2);

    if (parent1.compareTo(parent2) < 0) {
      parent.put(parent2, parent1);
      count.put(parent1, countSum);
    } else {
      parent.put(parent1, parent2);
      count.put(parent2, countSum);
    }
  }

}
