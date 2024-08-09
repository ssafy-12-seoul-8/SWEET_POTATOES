import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];
            int comp = rest / speeds[i];
            
            if (rest % speeds[i] != 0) {
                comp += 1;
            }
            
            queue.add(comp);
        }
        
        // System.out.println(queue);
        
        List<Integer> list = new ArrayList<>();
        
        int curr = queue.poll();
        int count = 1;
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            
            if (curr < temp) {
                list.add(count);
                curr = temp;
                count = 1;
            } else {
                count++;
            }
            
            // 남은 값 queue.add();
            if (queue.isEmpty()) {
                list.add(count);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}