import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n];
    int[] lastLargest = new int[n];
    int[] lisLength = new int[n];
    int maxLength = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.fill(lastLargest, 1_000_000_001);
    
    for (int i = 0; i < n; i++) {
        int num = nums[i];
        int left = 0;
        int right = maxLength;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (num > lastLargest[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        lastLargest[left] = num;
        lisLength[i] = left + 1;
        maxLength = Math.max(maxLength, lisLength[i]);
    }
    
    Deque<Integer> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder()
            .append(maxLength)
            .append(System.lineSeparator());
    
    for (int i = n - 1; i >= 0; i--) {
        if (maxLength != lisLength[i]) {
            continue;
        }
        
        maxLength--;
        stack.push(nums[i]);
    }
    
    while (!stack.isEmpty()) {
        sb.append(stack.pop())
            .append(" ");
    }
    
    System.out.println(sb);
  }
}