import java.io.*;

public class Main {

  static int[][] fibonacci;

  public static void main(String[] args) throws IOException {
    initFibonacci();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int t = 1; t <= cases; t++) {
      int n = Integer.parseInt(br.readLine());

      sb.append(fibonacci[n][0])
          .append(" ")
          .append(fibonacci[n][1])
          .append("\n");
    }

    System.out.print(sb);
  }

  static void initFibonacci() {
    fibonacci = new int[41][2];
    fibonacci[0][0] = 1;
    fibonacci[0][1] = 0;
    fibonacci[1][0] = 0;
    fibonacci[1][1] = 1;

    for (int i = 2; i <= 40; i++) {
      fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
      fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
    }
  }

}
