import java.io.*;
import java.util.*;

public class Main {

  static final List<Integer> all = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      int num = 0;

      if (st.hasMoreTokens()) {
        num = Integer.parseInt(st.nextToken());
      }

      switch (command) {
        case "add":
          set.add(num);
          break;
        case "remove":
          set.remove(num);
          break;
        case "check":
          sb.append(set.contains(num) ? 1 : 0)
              .append("\n");
          break;
        case "toggle":
          if (!set.remove(num)) {
            set.add(num);
          }
          break;
        case "all":
          set.clear();
          set.addAll(all);
          break;
        case "empty":
          set.clear();
      }
    }

    System.out.println(sb);
  }

}
