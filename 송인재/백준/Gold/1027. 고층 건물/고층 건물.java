import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int max = 0;
    int[] buildings = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      buildings[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      int count = 0;
      double temp = 0;

      for (int j = i - 1; j >= 0; j--) {
        double slope = (double) (buildings[i] - buildings[j]) / (i - j);

        if (j == i - 1 || temp > slope) {
          count++;
          temp = slope;
        }
      }

      for (int j = i + 1; j < n; j++) {
        double slope = (double) (buildings[i] - buildings[j]) / (i - j);

        if (j == i + 1 || temp < slope) {
          count++;
          temp = slope;
        }
      }

      max = Math.max(max, count);
    }

    System.out.println(max);
  }

}