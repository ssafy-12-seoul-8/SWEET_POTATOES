import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Map<String, Integer> alpha = new HashMap<>();
    Map<Integer, String> num = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      String pokemon = br.readLine();

      alpha.put(pokemon, i);
      num.put(i, pokemon);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      String input = br.readLine();

      if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
        sb.append(num.get(Integer.parseInt(input)));
      } else {
        sb.append(alpha.get(input));
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }

}
