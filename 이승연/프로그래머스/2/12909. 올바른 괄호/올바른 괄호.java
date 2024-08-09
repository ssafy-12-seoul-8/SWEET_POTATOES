import java.util.Queue;
import java.util.LinkedList;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                queue.add('(');
            } else if (!queue.isEmpty()) {
                queue.poll();
            } else {
                return false;
            }
        }

        if (!queue.isEmpty()) {
            return false;
        }
        
        return answer;
    }
}