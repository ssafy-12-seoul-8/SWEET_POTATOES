import java.io.*;
import java.util.*;

public class Main {

  static Map<Integer, int[]> tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    tree = new HashMap<>();
    int root = 0;

    while (true) {
      int number = 0;

      try {
        number = Integer.parseInt(br.readLine());
      } catch (Exception e) {
        break;
      }

      if (tree.isEmpty()) {
        tree.put(number, new int[] { 0, 0 });

        root = number;

        continue;
      }

      makeTree(number, root);
    }

    StringBuilder sb = new StringBuilder();

    search(root, sb);

    System.out.print(sb);
  }

  static void makeTree(int number, int node) {
    int[] children = tree.get(node);
    int smallOrBig = number < node ? 0 : 1;

    if (children[smallOrBig] == 0) {
      children[smallOrBig] = number;

      tree.put(number, new int[] { 0, 0 });

      return;
    }

    makeTree(number, children[smallOrBig]);
  }

  static void search(int number, StringBuilder sb) {
    int[] children = tree.get(number);
    int left = children[0];
    int right = children[1];

    if (left == 0 && right == 0) {
      sb.append(number)
          .append(System.lineSeparator());

      return;
    }

    if (left != 0) {
      search(left, sb);
    }

    if (right != 0) {
      search(right, sb);
    }

    sb.append(number)
        .append(System.lineSeparator());
  }

}
