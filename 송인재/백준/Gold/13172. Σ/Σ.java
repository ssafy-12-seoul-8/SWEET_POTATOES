import java.io.*;
import java.util.*;

public class Main {

  static int P = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    long numer = 0;
    long denumer = 1;

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      numer = s * denumer + n * numer;
      denumer *= n;
      numer %= P;
      denumer %= P;
    }

    long sum = numer % denumer == 0 ? numer / denumer : numer * getInverse(denumer) % P;
    System.out.println(sum);
  }

  static int getInverse(long base) {
    long inverse = 1;
    int exp = P - 2;

    while (exp > 0) {
      if ((exp & 1) == 1) {
        inverse *= base;
        inverse %= P;
      }

      base *= base;
      base %= P;
      exp >>= 1;
    }

    return (int) inverse;
  }

}
