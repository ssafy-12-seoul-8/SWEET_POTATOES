import java.io.*;
import java.util.*;

public class Main {

  static class Rule {
    int from;
    int to;
    int gap;
    int maxAcorns;

    Rule(int from, int to, int gap) {
      this.from = from;
      this.to = to;
      this.gap = gap;
      this.maxAcorns = (to - from) / gap + 1;
    }

    int countPossibleAcorns(int box) {
      if (to < box) {
        return maxAcorns;
      }

      if (from > box) {
        return 0;
      }

      return (box - from) / gap + 1;
    }
  }

  static int n, k, d;
  static Rule[] rules;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    rules = new Rule[k];

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int gap = Integer.parseInt(st.nextToken());
      rules[i] = new Rule(from, to, gap);
    }

    int left = 1;
    int right = n;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (isPossible(mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(left);
  }

  static boolean isPossible(int boxNum) {
    int count = 0;

    for (int i = 0; i < k; i++) {
      Rule rule = rules[i];

      int acorns = rule.countPossibleAcorns(boxNum);
      count += acorns;

      if (count >= d) {
        return true;
      }
    }

    return false;
  }

}
