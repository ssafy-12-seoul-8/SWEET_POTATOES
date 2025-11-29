import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] inOrder;
  static int[] inOrderIndices;
  static int[] postOrder;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    inOrder = new int[n + 1];
    inOrderIndices = new int[n + 1];
    postOrder = new int[n + 1];
    sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      inOrder[i] = Integer.parseInt(st.nextToken());
      inOrderIndices[inOrder[i]] = i;
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      postOrder[i] = Integer.parseInt(st.nextToken());
    }

    dfs(1, n, 1, n);

    System.out.println(sb);
  }

  static void dfs(int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return;
    }

    int root = postOrder[postEnd];

    sb.append(root)
        .append(" ");

    int rootIndex = inOrderIndices[root];
    int leftTreeSize = rootIndex - inStart;
    int postLeftEnd = postStart + leftTreeSize - 1;

    dfs(inStart, rootIndex - 1, postStart, postLeftEnd);
    dfs(rootIndex + 1, inEnd, postLeftEnd + 1, postEnd - 1);
  }

}
