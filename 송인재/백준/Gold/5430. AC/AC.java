import java.io.*;
import java.util.*;

public class Main {
    
    static final short FORWARD = 0;
    static final short BACKWARD = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= cases; t++) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String nums = br.readLine();
            StringTokenizer st = new StringTokenizer(nums.substring(1, nums.length() - 1), ",");
            int direction = FORWARD;
            
            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            
            boolean isError = false;
            
            for (int i = 0; i < commands.length(); i++) {
                char command = commands.charAt(i);
                
                if (command == 'R') {
                    direction = (direction + 1) % 2;
                    
                    continue;
                }
                
                if (command == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        
                        break;
                    }
                    
                    if (direction == FORWARD) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            
            if (isError) {
                sb.append("error");
            } else {
                sb.append("[");
                
                while (!deque.isEmpty()) {
                    sb.append(direction == FORWARD ? deque.pollFirst() : deque.pollLast())
                        .append(",");
                }
                
                if (sb.length() > 1) {
                    sb.setLength(sb.length() - 1);
                }
                
                sb.append("]");
            }
            
            System.out.println(sb);
        }
    }
    
}