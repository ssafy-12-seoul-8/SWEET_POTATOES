import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    	
    	int N = progresses.length;
    	Queue <Integer> schedule = new LinkedList<>();
    	List <Integer> schedule2 = new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
    		schedule.add((100 - progresses[i] + (speeds[i]-1)) / speeds[i]);
    	}
    	
    	while (!schedule.isEmpty()) {
    		int day = schedule.poll();
    		int cnt = 1;
    		
    		while (!schedule.isEmpty() && schedule.peek() <= day) {
    			schedule.poll();
    			cnt++;
    		}
    		schedule2.add(cnt);	// 배열 변환 필요
    	}

    	int[] answer = new int[schedule2.size()];
    	int idx = 0;
    	for (int d : schedule2) {
    		answer[idx++] = d;
    	}
    	
    	return answer;
    	
    }
}