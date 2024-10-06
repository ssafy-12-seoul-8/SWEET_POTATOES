import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static String[] numbers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());

    for (int t = 1; t <= cases; t++) {
      n = Integer.parseInt(br.readLine());
      numbers = new String[n];

      for (int i = 0; i < n; i++) {
        numbers[i] = br.readLine();
      }

      Arrays.sort(numbers);
      System.out.println(isConsistent() ? "YES" : "NO");
    }
  }

  static boolean isConsistent() {
    for (int i = 1; i < n; i++) {
      if (numbers[i].startsWith(numbers[i - 1])) {
        return false;
      }
    }

    return true;
  }

}
