import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] sk = new int[20_000_001];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      sk[Integer.parseInt(st.nextToken()) + 10_000_000]++;
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      sb.append(sk[Integer.parseInt(st.nextToken()) + 10_000_000])
          .append(" ");
    }

    System.out.println(sb);
  }

}