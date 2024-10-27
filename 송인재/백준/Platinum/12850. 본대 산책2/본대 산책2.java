import java.io.*;

public class Main {

  static long[][] matrix = {
      { 0, 1, 0, 1, 0, 0, 0, 0 },
      { 1, 0, 1, 1, 0, 0, 0, 0 },
      { 0, 1, 0, 1, 1, 1, 0, 0 },
      { 1, 1, 1, 0, 0, 1, 0, 0 },
      { 0, 0, 1, 0, 0, 1, 1, 0 },
      { 0, 0, 1, 1, 1, 0, 0, 1 },
      { 0, 0, 0, 0, 1, 0, 0, 1 },
      { 0, 0, 0, 0, 0, 1, 1, 0 }
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[][] powered = powerMatrix(matrix, n);

    System.out.println(powered[0][0]);
  }

  static long[][] powerMatrix(long[][] base, int n) {
    if (n <= 1) {
      return base;
    }

    long[][] powered = powerMatrix(base, n / 2);

    if (n % 2 == 0) {
      return multiply(powered, powered);
    }

    return multiply(powerMatrix(base, n - 1), base);
  }

  static long[][] multiply(long[][] base, long[][] mul) {
    long[][] temp = new long[8][8];

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        for (int k = 0; k < 8; k++) {
          temp[i][j] = (temp[i][j] + (base[i][k] * mul[k][j]) % 1_000_000_007) % 1_000_000_007;
        }
      }
    }

    return temp;
  }

}