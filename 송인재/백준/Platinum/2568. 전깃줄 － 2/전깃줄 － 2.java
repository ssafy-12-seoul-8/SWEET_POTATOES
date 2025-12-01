import java.io.*;
import java.util.*;

public class Main {
    
  static int INF = 500_001;
    
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] lines = new int[n][2];
    int[] lastBiggest = new int[n];
    int[] lisLength = new int[n];
    int length = 0;
    
    for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        lines[i][0] = Integer.parseInt(st.nextToken());
        lines[i][1] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(lines, Comparator.comparingInt(o -> o[0]));
    Arrays.fill(lastBiggest, INF);

    for (int i = 0; i < n; i++) {
      int b = lines[i][1];
      int left = 0;
      int right = n - 1;
      
      while (left <= right) {
          int mid = (left + right) / 2;
          
          if (b > lastBiggest[mid]) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      
      lastBiggest[left] = b;
      lisLength[i] = left + 1;
      length = Math.max(length, left + 1);
    }
    
    Deque<Integer> stack = new ArrayDeque<>();
    
    for (int i = n - 1; i >= 0; i--) {
        if (lisLength[i] != length) {
            stack.push(i);
            
            continue;
        }
        
        length--;
    }
    
    StringBuilder sb = new StringBuilder()
        .append(stack.size())
        .append(System.lineSeparator());
    
    while (!stack.isEmpty()) {
      int index = stack.pop();

      sb.append(lines[index][0])
          .append(System.lineSeparator());
    }
    
    System.out.println(sb);
  }
}