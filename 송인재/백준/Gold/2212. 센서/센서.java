import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    int[] sensors = new int[n];
    int[] dist = new int[n - 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int total = 0;

    for (int i = 0; i < n; i++) {
      sensors[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(sensors);

    for (int i = 0; i < n - 1; i++) {
      dist[i] = sensors[i + 1] - sensors[i];
      total += dist[i];
    }

    Arrays.sort(dist);

    for (int i = dist.length - 1; i >= Math.max(0, dist.length - k + 1); i--) {
      total -= dist[i];
    }

    System.out.println(total);
  }

}
