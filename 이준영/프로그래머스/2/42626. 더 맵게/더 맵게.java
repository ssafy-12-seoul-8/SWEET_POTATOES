import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
	        PriorityQueue<Integer> heap = new PriorityQueue<>();
	        for(int i:scoville) {
	        	heap.add(i);
	        }
	        while(true) {
	        	if(heap.isEmpty()) {
	        		answer = -1;
	        		break;
	        	} else if(heap.peek()>=K) {
	        		break;
	        	} else if(heap.size()==1) {
	        			answer = -1;
	        			break;
	        	} else {
	        		int a = heap.poll();
	        		int b = heap.poll();
	        		heap.add(a+2*b);
	        		answer+=1;
	        	}
	        }
	        return answer;
    }
}