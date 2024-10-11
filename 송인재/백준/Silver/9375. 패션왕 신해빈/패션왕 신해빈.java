import java.io.*;
import java.util.*;

public class Main {

  static int count;
  static Map<String, Integer> map = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());

    for (int t = 1; t <= cases; t++) {
      int n = Integer.parseInt(br.readLine());
      map.clear();
      count = 1;

      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();

        String type = st.nextToken();

        map.put(type, map.getOrDefault(type, 0) + 1);
      }

      for (int clothes : map.values()) {
        count *= clothes + 1;
      }

      System.out.println(count - 1);
    }
  }

}
