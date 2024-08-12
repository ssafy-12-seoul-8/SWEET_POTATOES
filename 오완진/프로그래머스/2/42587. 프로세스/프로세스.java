import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static int solution(int[] priorities, int location) {
    	
    	Queue <Integer> processQueue = new LinkedList<>();
    	List <Integer> completedQueue = new ArrayList<>();
    	
    	for (int i = 0; i < priorities.length; i++) {
    		// 처음배열순서, 우선순위, 처음배열순서, 우선순위,,,
    		processQueue.offer(i);
    		processQueue.offer(priorities[i]);
    	}
    	
    	outer:
    	while (!(processQueue.isEmpty())) {
    		int tmpIndex = processQueue.poll();
    		int tmpPriority = processQueue.poll();
    		for (int i = 0; i < processQueue.size(); i += 2) {
    			if (tmpPriority < ((LinkedList<Integer>) processQueue).get(i + 1)) {
    				processQueue.offer(tmpIndex);
    				processQueue.offer(tmpPriority);
    				continue outer;
				}
	    	}
    		completedQueue.add(tmpIndex);
    	}
    	return completedQueue.indexOf(location) + 1;
    }
}