import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
        
    	for (int num : scoville)
        	pq.add(num);
        
        int count = 0;
        int min = pq.peek();
        while (min < K) {
        	
        	if (pq.size() > 1) {
        		int first = pq.poll();
        		int second = pq.poll();
        		int newScoville = first + second * 2;
        		pq.add(newScoville);
        		
        		min = pq.peek();
        		count++;
        	} else
        		return -1;
        }
        
        return count;
        
    }
}