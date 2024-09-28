import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] scores = new int[n];
    int[] counts = new int[40_001];
    long count = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      scores[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      count += counts[20_000 - scores[i]];

      for (int j = 0; j < i; j++) {
        counts[20_000 + scores[i] + scores[j]]++;
      }
    }

    System.out.println(count);
  }

}