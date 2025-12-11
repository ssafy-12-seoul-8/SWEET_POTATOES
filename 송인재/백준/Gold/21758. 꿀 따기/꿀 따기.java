import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] honey = new int[n];
    int[] prefix = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      honey[i] = Integer.parseInt(st.nextToken());
      prefix[i] = honey[i];

      if (i >= 1) {
        prefix[i] += prefix[i - 1];
      }
    }

    int max = 0;

    for (int i = 1; i < n - 1; i++) {
      max = Math.max(max, prefix[n - 2] + prefix[i - 1] - honey[i]);
      max = Math.max(max, prefix[n - 1] - prefix[0] + prefix[n - 1] - prefix[i] - honey[i]);
      max = Math.max(max, prefix[i] - prefix[0] + prefix[n - 2] - prefix[i - 1]);
    }

    System.out.println(max);
  }

}
