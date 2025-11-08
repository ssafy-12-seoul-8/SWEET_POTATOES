import java.io.*;

public class Main {

  static int MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    long[][] matrix = {
        { 1, 0 },
        { 0, 1 }
    };
    long[][] base = {
        { 1, 1 },
        { 1, 0 }
    };
    long exp = n;

    while (exp > 0) {
      if ((exp & 1) == 1) {
        matrix = multiply(matrix, base);
      }

      base = multiply(base, base);
      exp >>= 1;
    }

    System.out.println(matrix[0][1]);
  }

  static long[][] multiply(long[][] first, long[][] second) {
    long[][] multiplied = new long[first.length][second[0].length];

    for (int i = 0; i < multiplied.length; i++) {
      for (int j = 0; j < multiplied[0].length; j++) {
        for (int k = 0; k < second[0].length; k++) {
          multiplied[i][j] += (first[i][k] % MOD) * (second[k][j] % MOD);
          multiplied[i][j] %= MOD;
        }
      }
    }

    return multiplied;
  }

}
