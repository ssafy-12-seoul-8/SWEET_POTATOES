import java.io.*;
import java.util.*;

public class Main {

  static Set<Long> twoPowers;
  static Map<Long, int[][]> twoMatrix;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    int[][] matrix = new int[n][n];
    twoPowers = new HashSet<>();
    twoMatrix = new HashMap<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
      }
    }

    twoPowers.add(1L);
    twoMatrix.put(1L, matrix);

    long max = getMax(1, b);
    int[][] result = getResult(b, max);
    StringBuilder sb = new StringBuilder();

    for (int[] row : result) {
      for (int num : row) {
        sb.append(num)
            .append(" ");
      }

      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static long getMax(long current, long b) {
    long doubled = current * 2L;

    if (doubled > b) {
      return current;
    }

    twoPowers.add(doubled);

    int[][] matrix = twoMatrix.get(current);
    int[][] powered = multiply(matrix, matrix);

    twoMatrix.put(doubled, powered);

    return getMax(doubled, b);
  }

  static int[][] getResult(long number, long twoPower) {
    if (twoPowers.contains(number)) {
      return twoMatrix.get(number);
    }

    while (number < twoPower) {
      twoPower /= 2;
    }

    int[][] last = getResult(number - twoPower, twoPower / 2);

    return multiply(twoMatrix.get(twoPower), last);
  }

  static int[][] multiply(int[][] first, int[][] second) {
    int[][] multiplied = new int[first.length][second[0].length];

    for (int i = 0; i < first.length; i++) {
      for (int j = 0; j < first[0].length; j++) {
        for (int k = 0; k < second[0].length; k++) {
          multiplied[i][j] += first[i][k] * second[k][j];
        }

        multiplied[i][j] %= 1000;
      }
    }

    return multiplied;
  }

}
